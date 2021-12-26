package com.coderman.learn.testmapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderman.learn.mybatisplus.MyBatisPlusThresholdApplication;
import com.coderman.learn.mybatisplus.entity.UserEntity;
import com.coderman.learn.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/26
 * comment: 十几个复杂的查询实例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MyBatisPlusThresholdApplication.class)
@Slf4j
public class ComplexSelectTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryWrapper01() {
        //title_01、名字中包含雨并且年龄小于40
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();//直接实例化

        //like就是模糊查询，会在SQL查询条件中拼上 like '%雨%'的条件，le是小于的意思，最终的SQL如下图日志所示
        queryWrapper.like("name", "雨").le("age", 40);

        List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
        log.info("wrapper user list:{}", userEntities);
    }

    @Test
    public void testQueryWrapper02() {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();//直接实例化
        /**
         * 2、名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
         *  name like '%雨%' and age between 20 and 40 and email is not null
         */
        queryWrapper.like("name", "雨").between("age", 20, 31).isNotNull("email");
        List<UserEntity> userEntitiesTitle2 = userMapper.selectList(queryWrapper);
        log.info("title 2 result:{}", userEntitiesTitle2);

    }

    @Test
    public void testQueryWrapper03() {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();//直接实例化
        /**
         * 3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
         *    name like '王%' or age>=25 order by age desc,id asc
         */
        queryWrapper.likeRight("name", "王").or().ge("age", 25).orderByDesc("age").orderByAsc("id");
        List<UserEntity> userEntitiesTitle3 = userMapper.selectList(queryWrapper);
        log.info("title 3 result:{}", userEntitiesTitle3);
    }

    @Test
    public void testQueryWrapper04() {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();//直接实例化
        /**
         * 4、创建日期为2019年2月14日并且直属上级为名字为王姓
         * date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id in (select id from user where name like '王%')
         *
         * 这个也行，但是会有SQL注入的风险
         * queryWrapper.apply("date_format(create_time,'%Y-%m-%d')= 2019-02-14")
         */
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-02-14")
                .inSql("manager_id", "select id from t_user where name like '王%'");
        List<UserEntity> userEntitiesTitle4 = userMapper.selectList(queryWrapper);
        log.info("mysql 日期函数，复合查询结果为:{}", userEntitiesTitle4);

    }

    @Test
    public void testQueryWrapper05() {
        /**
         * 5、名字为王姓并且（年龄小于40或邮箱不为空）
         * name like '王%' and (age<40 or email is not null)
         * and方法接受一个Function的函数式接口
         */
        QueryWrapper<UserEntity> queryNew = Wrappers.<UserEntity>query(); //静态方法实例化
        queryNew.likeRight("name", "王").and(wq -> wq.lt("age", 41).or().isNotNull("email"));
        List<UserEntity> userEntitiesTitle5 = userMapper.selectList(queryNew);
        log.info("and 函数实例结果为:{}", userEntitiesTitle5);
    }

    @Test
    public void testQueryWrapper06() {
        /**
         * 6、名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
         * name like '王%' or (age<40 and age>20 and email is not null)
         */
        QueryWrapper<UserEntity> querySix = Wrappers.<UserEntity>query(); //静态方法实例化
        querySix.likeRight("name", "王").or(wq -> wq.lt("age", 40)
                .gt("age", 20).isNotNull("email"));
        List<UserEntity> userEntityListSix = userMapper.selectList(querySix);
        log.info("and 函数实例结果为:{}", userEntityListSix);
    }

    @Test
    public void testQueryWrapper07() {
        /**
         * 7、（年龄小于40或邮箱不为空）并且名字为王姓
         *  (age<40 or email is not null) and name like '王%'
         */
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();
        queryWrapper.nested(wp -> wp.lt("age", 40).or().isNotNull("email")).likeRight("name", "王");
        List<UserEntity> userEntitiesResult7 = userMapper.selectList(queryWrapper);
        log.info("第7个集合查询结果为:{}", userEntitiesResult7);

    }

    @Test
    public void testQueryWrapper08() {
        /**
         * 8、年龄为30、31、34、35
         * age in (30、31、34、35)
         */
        List<Integer> ages = Arrays.asList(30, 31, 34, 35);
        QueryWrapper<UserEntity> queryAgeInWrapper = new QueryWrapper<UserEntity>();
        queryAgeInWrapper.in("age", ages);
        List<UserEntity> userAgeInResult = userMapper.selectList(queryAgeInWrapper);
        log.info("age in result:{}", userAgeInResult);
    }

    @Test
    public void testQueryWrapper09() {
        /**
         * 9、只返回满足条件的其中一条语句即可
         * limit 1
         */
        QueryWrapper<UserEntity> queryLimitWrapper = new QueryWrapper<UserEntity>();
        queryLimitWrapper.last("limit 1");//无视SQL优化，有SQL注入的风险，慎用
        List<UserEntity> userEntityListLimit = userMapper.selectList(queryLimitWrapper);
        log.info("user limit result:{}", userEntityListLimit);
    }

    @Test
    public void testQueryWrapper10() {
        /**
         * 包含雨并且年龄小于40
         * select id,name
         * from user
         * where name like '%雨%' and age<40
         */
        QueryWrapper<UserEntity> queryNotAllWrapper = new QueryWrapper<UserEntity>();
        queryNotAllWrapper.select("id", "name").like("name", "雨").lt("age", 40);
        List<UserEntity> userEntities = userMapper.selectList(queryNotAllWrapper);
        log.info("not all column result:{}", userEntities);
    }

//    @Test
//    public void testConditionWrapper() {
//        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();
//        //如果没有condition参数，则会一个个去判断，一个个去拼接
//        //if (StringUtils.isNotEmpty(name)) {
//        //    queryWrapper.like("name", name);
//        //}
//
//        //if (StringUtils.isNotEmpty(email)) {
//        //    queryWrapper.like("email", email);
//        //}
//
//        //如果某一个字符串不为空，才会将其加入到where语句中
//        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name)
//                .like(StringUtils.isNotEmpty(email), "email", email);
//    }

    /**
     * 对象作为查询条件
     */
    @Test
    public void searchEntityParamTest(){
        UserEntity paramUserEntity = new UserEntity();
        paramUserEntity.setName("张雨琪");
        paramUserEntity.setAge(31);

        //默认是等值比对，如果想利用对象查询的同时，需要在对应属性上加入非等值的条件查询，就需要在Entity上加入TableField注解
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>(paramUserEntity);
        List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
        //queryWrapper.like("name","雨");//这里拼接的查询条件与实体拼接的查询条件不冲突
        log.info("entity search result:{}",userEntities);
    }

    @Test
    public void searchAllEqTest(){
        Map<String,Object> params = new HashMap<>();
        params.put("name","张雨琪");
        params.put("age",null);

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(params);
        //queryWrapper.allEq(params);//where 之后出现 age is null
        //queryWrapper.allEq(params,false);// 之后不会出现 age is null;
        //queryWrapper.allEq((k,v)->!k.equals("age"),params);//第一个参数根据条件过滤，符合条件的才会加入到查询条件里头
        List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
        log.info("allEq query result:{}",userEntities);
    }



}
