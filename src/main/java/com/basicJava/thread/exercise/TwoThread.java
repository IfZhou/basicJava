package com.basicJava.thread.exercise;

/**
 * Created by zhouyifu on 2017/10/9.
 *
 * 题目要求：
 * 写两个线程，一个线程打印1~52，另一个线程打印A~Z，打印顺序是12A34B...5152Z；
 *
 *
 */
public class TwoThread {

    public static void main(String args[]) {
        ShareData sd = new ShareData();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {
                    sd.printNumber();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {
                    sd.printAlphabet();
                }
            }
        });

        t1.start();
        t2.start();
    }

}

class ShareData{
    private int count = 1;
    private boolean flag = true;//true 打印数字，false打印字母
    public synchronized void printAlphabet(){
        while(this.flag == true){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char) ('A'+ (count-1)));
        this.flag = true;
        count ++;
        this.notify();
    }

    public synchronized void printNumber(){
        while(this.flag == false){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.print(count * 2 -1 );
        System.out.print(count * 2);
        flag = false;
        this.notify();
    }

}
