package com.learn.concurrency.circlelock;

/**
 * autor:liman
 * createtime:2021-10-30
 * comment:转账 会产生死锁的实例
 */
public class TransferAccount implements Runnable {

    int flag = 1;
    static Account fromAccount = new Account(500);
    static Account toAccount = new Account(500);

    public static void main(String[] args) throws InterruptedException {
        TransferAccount transferAccountOne = new TransferAccount();
        TransferAccount transferAccountTwo = new TransferAccount();
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

    /**
     * 模拟转账的函数
     * @param fromAccount 转出账号
     * @param toAccount     转入账号
     * @param amount    金额
     */
    public static void transMoney(Account fromAccount, Account toAccount, int amount) {
        synchronized (fromAccount) {//先获取转出账号的锁

            //模拟通信耗时，有了这个就会造成死锁
            //try {
            //    Thread.sleep(500);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}

            synchronized (toAccount) {//再获取转入账号的锁
                if (fromAccount.balance - amount < 0) {
                    System.out.println("余额不足，转账失败");
                }
                //转账操作
                fromAccount.balance -= amount;
                toAccount.balance = toAccount.balance + amount;
                System.out.println("转账成功" + amount + "元");
            }
        }
    }

    //简单的账户对象
    static class Account {

        public Account(int balance) {
            this.balance = balance;
        }

        int balance;
    }
}
