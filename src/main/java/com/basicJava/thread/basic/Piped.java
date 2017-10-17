package com.basicJava.thread.basic;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by zhouyifu on 2017/10/12.
 */
public class Piped {

    public static void main(String[] args)   {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        try {
            out.connect(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while((receive = System.in.read())!= 1){
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class Print implements  Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in= in;
        }
        @Override
        public void run() {
            int receive = 0;
            try {
                while((receive = in.read()) != -1 ){
                    System.out.println((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
