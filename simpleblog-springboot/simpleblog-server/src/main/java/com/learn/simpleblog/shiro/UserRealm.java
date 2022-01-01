package com.learn.simpleblog.shiro;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.module.domain.SysMenuEntity;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.module.mapper.SysUserDao;
import com.learn.simpleblog.service.pmp.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * shiro用于认证用户~授权
 * @Author:debug (SteadyJack)
 **/
@Component
public class UserRealm extends AuthorizingRealm {

    private static final Logger log= LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 资源-权限分配 ~ 授权 ~ 需要将分配给当前用户的权限列表塞给shiro的权限字段中去
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录用户（主体）
        SysUserEntity user= (SysUserEntity) principalCollection.getPrimaryPrincipal();
        Long userId=user.getUserId();
        List<String> perms= Lists.newLinkedList();

        //系统超级管理员拥有最高的权限，不需要发出sql的查询，直接拥有所有权限；否则，则需要根据当前用户id去查询权限列表
        if (Objects.equals(userId, Constant.SUPER_ADMIN)){
            List<SysMenuEntity> list=sysMenuService.list();
            if (list!=null && !list.isEmpty()){
                perms=list.stream().map(SysMenuEntity::getPerms).collect(Collectors.toList());
            }
        }else{
            perms=sysUserDao.queryAllPerms(userId);
        }

        //对于每一个授权编码进行 , 的解析拆分
        Set<String> stringPermissions= Sets.newHashSet();
        if (perms!=null && !perms.isEmpty()){
            for (String p:perms){
                if (StringUtils.isNotBlank(p)){
                    stringPermissions.addAll(Arrays.asList(StringUtils.split(p.trim(),",")));
                }
            }
        }

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setStringPermissions(stringPermissions);
        return info;
    }

    /**
     * 用户认证 ~ 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        final String userName=token.getUsername();
        final String password=String.valueOf(token.getPassword());

        log.info("用户名: {} 密码：{}",userName,password);

        //SysUserEntity entity=sysUserDao.selectOne(new QueryWrapper<SysUserEntity>().eq("username",userName));
        SysUserEntity entity=sysUserDao.selectByUserName(userName); //演示sql注入攻击
        //账户不存在
        if (entity==null){
            throw new UnknownAccountException("账户不存在!");
        }
        //账户被禁用
        if (0 == entity.getStatus()){
            throw new DisabledAccountException("账户已被禁用,请联系管理员!");
        }

        //第一种 : 明文匹配
        //账户名密码不匹配
        /*if (!entity.getPassword().equals(password)){
            throw new IncorrectCredentialsException("账户密码不匹配!");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(entity,password,getName());*/

        //第三种验证逻辑
        /*String realPassword=ShiroUtil.sha256(password,entity.getSalt());
        if (StringUtils.isBlank(realPassword) || !realPassword.equals(entity.getPassword())){
            throw new IncorrectCredentialsException("账户密码不匹配!");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(entity,password,getName());*/

        //第二种验证逻辑-交给shiro的密钥匹配器去实现
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(entity, entity.getPassword(), ByteSource.Util.bytes(entity.getSalt()), getName());
        return info;
    }

    /**
     * 密码验证器~匹配逻辑 ~ 第二种验证逻辑
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtil.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtil.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}























