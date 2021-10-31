package com.learn.concurrency.circlelock;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment:哲学家就餐问题模拟
 */
public class DiningPhilosophers {

    public static class Philosopher implements Runnable {

        private Object leftChopstick;
        private Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
                //哲学家无止境的做某些事情，除了思考就是吃饭
                while (true) {
                    doAction("进行哲学思考");
                    synchronized (leftChopstick) {
                        doAction("拿起左边的筷子");
                        synchronized (rightChopstick) {
                            doAction("拿起右边的筷子");
                            doAction("吃饭......");
                            doAction("放下右边的筷子");
                        }
                        doAction("放下左边的筷子");
                    }


                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + ":" + action);
            Thread.sleep((long) (Math.random() * 10));
        }
    }

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];//初始化五个哲学家
        Object[] chopsticks = new Object[philosophers.length];//初始化5根筷子
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }
        //实例化哲学家，并启动线程
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i + 1) % chopsticks.length];

            //其中一位哲学家获取筷子的顺序与其他哲学家不同，可以避免死锁
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightChopstick, leftChopstick);
            } else {
                philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            }
            new Thread(philosophers[i], "哲学家" + (i + 1)).start();
        }
    }
}
