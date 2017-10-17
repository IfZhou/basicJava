package com.basicJava.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhouyifu on 2017/10/11.
 */
public class SleepUtils {
    public static final void second(long seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
