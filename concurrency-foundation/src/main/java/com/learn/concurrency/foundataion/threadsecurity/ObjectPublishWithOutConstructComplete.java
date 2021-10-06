package com.learn.concurrency.foundataion.threadsecurity;

/**
 * autor:liman
 * createtime:2021/9/27
 * comment:构造函数没有构造完成，就返回了对象
 */
public class ObjectPublishWithOutConstructComplete {
    static Point point;

    public static void main(String[] args) throws InterruptedException {
        new PointMaker().start();
        Thread.sleep(10);//如果睡眠时间过短，Y这个属性是来不及初始化的
        if(point!=null){
            System.out.println(point);
        }
    }

}

class Point{
    private final int x,y;

    public Point(int x,int y) throws InterruptedException {
        this.x = x;
        ObjectPublishWithOutConstructComplete.point = this;
        Thread.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class PointMaker extends Thread{
    @Override
    public void run() {
        try {
            new Point(1,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
