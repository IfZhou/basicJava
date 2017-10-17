package com.basicJava.thread.exercise;

/**
 * Created by zhouyifu on 2017/10/9.
 *
 * 子线程循环10次，主线程循环100次，然后子线程循环10次，主线程循环100次，这样循环5次；
 *
 * synchornized+wait，notify方法；难点在于主线程的启动不需要start方法，因为程序的入口是main方法，在执行这个程序的时候，主线程已经启动了；
 */
public class SubMain {


    public static void main(String args[]) {
        CounterData cd = new CounterData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i < 5; i++){
                    cd.submethod();
                }

            }
        }).start();
        for(int i =0; i < 5; i++){
            cd.mainmethod();
        }
    }
}
class CounterData{
    private  boolean flag = true;


    public synchronized void submethod(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 10; i ++){
//            System.out.println("子线程循环中:"+ i);
        }
        System.out.println("子线程循环结束！");

        flag = false;
        this.notify();
    }


    public synchronized void mainmethod(){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 100; i ++){
//            System.out.println("主线程循环中:"+ i);
        }
        System.out.println("主线程循环结束！");
        flag = true;
        this.notify();
    }
}
