package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:
 */
public class SyncDeCompileDemo {

    private Object object = new Object();

    public void syncMethod(){
        synchronized (object){

        }
    }

}
