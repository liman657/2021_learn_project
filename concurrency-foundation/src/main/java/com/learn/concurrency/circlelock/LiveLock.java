package com.learn.concurrency.circlelock;

import java.util.Random;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment:活锁实例
 */
public class LiveLock {

    //勺子
    static class Spoon {

        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public void setOwner(Diner owner) {
            this.owner = owner;
        }

        public synchronized void use() {
            System.out.printf("%s吃完了!", owner.name);


        }
    }

    static class Diner {

        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            isHungry = true;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                //如果自己没有持有勺子
                if (spoon.owner != this) {
                    //进入等待1秒
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                //如果自己有勺子，并且饿了，为了避免死锁就先将勺子给对方
                Random random = new Random();
                if (spouse.isHungry
                        && random.nextInt(10) < 9
                        ) {
                    System.out.println(name + ": 亲爱的" + spouse.name + "你先吃吧");
                    spoon.setOwner(spouse);
                    continue;
                }

                //否则就自己吃
                spoon.use();
                isHungry = false;
                System.out.println(name + ": 我吃完了");
                spoon.setOwner(spouse);

            }
        }
    }


    public static void main(String[] args) {
        Diner husband = new Diner("牛郎");
        Diner wife = new Diner("织女");

        Spoon spoon = new Spoon(husband);

        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}