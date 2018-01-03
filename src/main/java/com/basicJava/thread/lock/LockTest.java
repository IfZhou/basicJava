package com.basicJava.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhouyifu on 2017/10/9.
 */
public class LockTest {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}
