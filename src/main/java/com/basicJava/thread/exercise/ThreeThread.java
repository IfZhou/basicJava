package com.basicJava.thread.exercise;

/**
 * Created by zhouyifu on 2017/10/9.
 *
 * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
 */
public class ThreeThread {


    public static void main(String args[]) {
        PrintABC printABC = new PrintABC();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 5; i ++){
                    printABC.printC();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 5; i ++){
                    printABC.printA();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 5; i ++){
                    printABC.printB();
                }
            }
        }).start();
    }

}
class PrintABC{
    private int flag = 1;

    public synchronized void printA(){
        while(flag != 1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        flag = 2;
        this.notifyAll();
    }
    public synchronized void printB(){
        while(flag != 2){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        flag = 3;
        this.notifyAll();
    }
    public synchronized void printC(){
        while(flag != 3){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("C");
        flag = 1;
        this.notifyAll();

    }

}
