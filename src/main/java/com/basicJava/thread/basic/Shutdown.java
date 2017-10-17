package com.basicJava.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhouyifu on 2017/10/11.
 *
 * 创建了一个线程CountThread，它不断地进行变量累加，而主线程尝试对其进行中断操作和停止操作。
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Runner one= new Runner();
        Thread countThread = new Thread(one,"countThread");
        countThread.start();
        //睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two= new Runner();
        countThread = new Thread(two,"countThread");
        countThread.start();
        //睡眠1秒，main线程对two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i ++ ;
            }
            System.out.println("Count i="+ i);
        }
        public void cancel(){
            on = false;
        }
    }
}
