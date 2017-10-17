package com.basicJava.thread.exercise.pipeline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhouyifu on 2017/9/29.
 */
public class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<Msg>();

    public void run() {
        while (true){
            try {
                Msg msg=bq.take();
                msg.j=msg.i+msg.j;
                Multiply.bq.add(msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}