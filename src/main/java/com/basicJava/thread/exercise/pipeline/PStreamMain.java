package com.basicJava.thread.exercise.pipeline;

/**
 * Created by zhouyifu on 2017/9/29.
 */
public class PStreamMain {
    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        //每个线程中会有一个阻塞的“先进先出”的栈，是通过每个线程类中的这个栈进行任务顺序连接的

        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                Msg msg=new Msg();
                msg.i=i;
                msg.j=j;
                msg.orgStr="(("+i+"+"+j+")*"+i+")/2";
                Plus.bq.add(msg);
            }
        }
    }
}