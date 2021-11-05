package com.learn.concurrency.circlelock.fix;

import com.learn.concurrency.circlelock.TransferAccount;

import java.util.Random;

/**
 * autor:liman
 * createtime:2021-10-30
 * comment: 多人同时转账 依旧很危险
 */
public class ManyPersonTransMoneyFix {

    //账户个数，随机从500个账户中抽出多个进行转账
    private static final int NUM_ACCOUNTS = 500;
    private static final int ACCOUNT_MONEY = 1000;
    //模拟每秒在线转账的次数
    private static final int TRANS_MONEY_COUNT = 1000000;
    private static final int NUM_TRANS_THREAD = 20;
    static Object extendLock = new Object();

    public static void main(String[] args) {
        Random random = new Random();
        FixAccount[] accounts = new FixAccount[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new FixAccount(ACCOUNT_MONEY);
        }

        class TransferThread extends Thread{
            @Override
            public void run() {
                //模拟每次转账的账户个数
                for(int i=0;i<TRANS_MONEY_COUNT;i++){
                    //随机得到转账账户和金额
                    int fromAcct = random.nextInt(NUM_ACCOUNTS);
                    int toAcct = random.nextInt(NUM_ACCOUNTS);
                    if(fromAcct!=toAcct){
                        int amount = random.nextInt(ACCOUNT_MONEY);
                        //转账
                        transMoney(accounts[fromAcct],accounts[toAcct],amount);
                    }
                }
            }
        }

        //启动多个线程，进行转账
        for(int i=0;i<NUM_TRANS_THREAD;i++){
            new TransferThread().start();
        }
    }

    /**
     * 模拟转账的函数
     * @param fromAccount 转出账号
     * @param toAccount     转入账号
     * @param amount    金额
     */
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
            synchronized (extendLock){//任意顺序都可以，谁抢到这个锁，谁先执行
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

    //简单的账户对象
    static class FixAccount {

        public FixAccount(int balance) {
            this.balance = balance;
        }

        int balance;
    }
}
