package com.basicJava.thread.exercise.pipeline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhouyifu on 2017/9/29.
 */
public class Div implements  Runnable{

    public static BlockingQueue<Msg> bq=new LinkedBlockingDeque<Msg>();
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i / 2;
                System.out.println("计算结果" + msg.orgStr + "=" + msg.i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}