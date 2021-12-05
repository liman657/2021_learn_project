package com.learn.concurrency.futureandcallable;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021-12-01
 * comment:通过FutureTask来获取Future和任务的结果
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        Task task = new Task();
        FutureTask futureTask = new FutureTask<Integer>(task);
//        new Thread(futureTask).start();//将futureTask作为一个线程启动
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(futureTask);//将FutureTask提交给线程池
        try {
            Object result = futureTask.get();//直接利用FutureTask获取结果
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(3000);
        int sum =0;
        for (int i=0;i<=100;i++){
            sum+=i;
        }
        return sum;
    }
}