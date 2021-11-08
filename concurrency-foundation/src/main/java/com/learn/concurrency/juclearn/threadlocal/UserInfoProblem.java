package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/8
 * comment: 不断传递用户信息的问题
 */
@Slf4j
public class UserInfoProblem {

    public static void main(String[] args) {
        log.info("开始调用");
        ServiceOne serviceOne = new ServiceOne();
        serviceOne.process();
        log.info("调用结束");
    }
    
    
}

class ServiceOne{
    public void process(){
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        System.out.println("service one 设置用户"+user);
        ServiceTwo serviceTwo = new ServiceTwo();
        serviceTwo.process();
    }
}

class ServiceTwo{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("server two 中拿到的对象"+user);
        ServiceThree serviceThree = new ServiceThree();
        serviceThree.process();
    }
}

class ServiceThree{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("server three 中拿到的对象"+user);
    }
}

//Holder是持有者的意思
class UserContextHolder{
    public static ThreadLocal<User> holder =
            new ThreadLocal<>();
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}