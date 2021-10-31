package com.learn.concurrency.circlelock;

import java.util.Random;

import com.learn.concurrency.circlelock.TransferAccount.Account;

/**
 * autor:liman
 * createtime:2021-10-30
 * comment: 多人同时转账 依旧很危险
 */
public class ManyPersonTransMoney {

    //账户个数，随机从500个账户中抽出多个进行转账
    private static final int NUM_ACCOUNTS = 500;
    private static final int ACCOUNT_MONEY = 1000;
    //模拟每秒在线转账的次数
    private static final int TRANS_MONEY_COUNT = 1000000;
    private static final int NUM_TRANS_THREAD = 20;

    public static void main(String[] args) {
        Random random = new Random();
        Account[] accounts = new Account[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(ACCOUNT_MONEY);
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
                        TransferAccount.transMoney(accounts[fromAcct],accounts[toAcct],amount);
                    }
                }
            }
        }

        //启动多个线程，进行转账
        for(int i=0;i<NUM_TRANS_THREAD;i++){
            new TransferThread().start();
        }
    }
}
