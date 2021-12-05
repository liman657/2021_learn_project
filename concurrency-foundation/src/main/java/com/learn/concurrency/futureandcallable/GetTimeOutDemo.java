package com.learn.concurrency.futureandcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:Get方法的超时处理
 * 超时后需要单独处理的。演示cancel传入true和false表示是否中断正在执行的任务
 */
@Slf4j
public class GetTimeOutDemo {

    private static final Ad DEFAULT_AD = new Ad("无网络时的默认广告");

    private static final ExecutorService service = Executors.newFixedThreadPool(10);

    static class Ad {
        String name;

        public Ad(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Ad{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 获取广告的任务
     */
    static class FetchAdTask implements Callable<Ad> {

        @Override
        public Ad call() throws Exception {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                System.out.println("sleep期间被中断");
                return new Ad("被中断时候的默认广告");
            }
            return new Ad("钻石恒久远，一颗永流传");
        }
    }

    public void printAd() {
        Future<Ad> futureTask = service.submit(new FetchAdTask());
        Ad ad = null;
        try {
            //1秒钟的时间获取结果，是无法获取到的，因此会超时
            ad = futureTask.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("被中断");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("出现异常");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("获取Callable结果超时");
            ad = new Ad("被中断时的默认广告");
            //超时的处理，传入的参数为false，表示不需要发送中断信号中断正在运行的线程，true表示需要中断
            boolean cancel = futureTask.cancel(true);
            System.out.println("cancel的结果(是否正常取消正在运行的任务)"+cancel);
        }
        System.out.println(ad);
        service.shutdown();
    }

    public static void main(String[] args) {
        GetTimeOutDemo timeOutDemo = new GetTimeOutDemo();
        timeOutDemo.printAd();
    }
}
