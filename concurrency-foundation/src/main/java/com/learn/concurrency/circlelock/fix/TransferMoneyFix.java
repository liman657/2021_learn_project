package com.learn.concurrency.circlelock.fix;

import com.learn.concurrency.circlelock.TransferAccount;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment: 转账的死锁修复
 * 通过避免相反的获取锁的顺序 利用对象的hashCode决定获取锁的顺序
 */
public class TransferMoneyFix implements Runnable {

    int flag = 1;
    static FixAccount fromAccount = new FixAccount(500);
    static FixAccount toAccount = new FixAccount(500);
    static Object extendLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoneyFix transferAccountOne = new TransferMoneyFix();
        TransferMoneyFix transferAccountTwo = new TransferMoneyFix();
        transferAccountOne.flag = 0;
        transferAccountTwo.flag = 1;
        Thread threadOne = new Thread(transferAccountOne);
        Thread threadTwo = new Thread(transferAccountTwo);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("账户from的余额:"+fromAccount.balance);
        System.out.println("账户to的余额:"+toAccount.balance);
    }

    @Override
    public void run() {
        if (flag == 1) {
            transMoney(fromAccount, toAccount, 200);
        }

        if (flag == 0) {
            transMoney(toAccount, fromAccount, 200);
        }
    }

    public static void transMoney(FixAccount fromAccount, FixAccount toAccount, int amount) {

        class Helper{
            public void transfer(){
                if (fromAccount.balance - amount < 0) {
                    System.out.println("余额不足，转账失败");
                }
                //转账操作
                fromAccount.balance -= amount;
                toAccount.balance = toAccount.balance + amount;
                System.out.println("转账成功" + amount + "元");
            }
        }

        int fromAccountHashCode = System.identityHashCode(fromAccount);
        int toAccountHashCode = System.identityHashCode(toAccount);

        if(fromAccountHashCode<toAccountHashCode) {
            synchronized (fromAccount) {
                //模拟通信耗时，有了这个就会造成死锁
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        }

        if(fromAccountHashCode > toAccountHashCode){
            synchronized (toAccount) {
                //模拟通信耗时
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        }

        //如果出现hashCode一样的情况，进入到加时赛
        if(fromAccountHashCode == toAccountHashCode){
            synchronized (extendLock){
                //任意顺序都可以
                synchronized (toAccount) {
                    //模拟通信耗时
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (fromAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    static class FixAccount {

        public FixAccount(int balance) {
            this.balance = balance;
        }

        int balance;
    }
}
