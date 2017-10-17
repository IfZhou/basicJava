package com.basicJava.thread.basic;

/**
 * Created by zhouyifu on 2017/10/13.
 */
public class TimeoutPattern {

    public synchronized Object get(long mills) throws InterruptedException {
        Object result = null;
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        while((result == null)&& remaining > 0 ){
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }
        return result;
    }
}
