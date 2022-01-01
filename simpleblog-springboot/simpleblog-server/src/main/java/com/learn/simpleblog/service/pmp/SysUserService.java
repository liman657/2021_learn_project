package com.learn.simpleblog.service.pmp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.SysUserEntity;

import java.util.Map;

public interface SysUserService extends IService<SysUserEntity> {

    //修改密码
    boolean updatePassword(Long userId, String oldPassword, String newPassword);

    PageUtil queryPage(Map<String, Object> map);

    Long saveUser(SysUserEntity entity);

    SysUserEntity getInfo(Long userId);

    void updateUser(SysUserEntity entity);

    void deleteUser(Long[] ids);

    void updatePsd(Long[] ids);
}
































