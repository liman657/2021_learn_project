package com.learn.springsourcedemo.demo.pattern.template;

public abstract class KTVRoom {
    public void procedure(){
        openDevice();
        orderSong();
        orderExtra();
        pay();
    }
    //模板自带方法，使用前必须得打开设备
    private void openDevice(){
        System.out.println("打开视频和音响");
    }
    //子类必须实现的方法，必须得选歌
    protected abstract void orderSong();
    //钩子，额外开销视情况选择
    protected void orderExtra(){};
    //模板自带方法，用后必须得付款
    private void pay(){
        System.out.println("支付本次的消费账单。。。");
    }
}
