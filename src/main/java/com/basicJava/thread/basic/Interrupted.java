package com.basicJava.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhouyifu on 2017/10/11.
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        //sleeprunner不听尝试睡眠
        Thread sleepThread= new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        //休眠5秒，让两个线程充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread interrupt is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupt is " +  busyThread.isInterrupted());
        //防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements  Runnable{
        @Override
        public void run() {
            while(true){
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
