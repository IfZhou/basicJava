package com.basicJava.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by zhouyifu on 2017/10/11.
 一个独占锁的基本实现。
 什么是独占锁：
 同一时刻只能有一个线程获取到锁，其他线程只能在队列中等待，直到释放了锁


 锁的自定义：实现锁接口->定义静态内部类继承同步器->重写模板方法->将Lock接口的方法代理到自己定义的同步器上
 */
public class Mutex implements Lock {
    //静态内部类，自定义同步器
    private static  class Sync extends AbstractQueuedSynchronizer{
        //是否处于占用状态
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
        //状态为0的时候获取锁
        public boolean tryAcquire(int acquire){
            if(compareAndSetState(0,1)){ //表示期望值0与内存值0相等时，内存值将被修改成1，即被当前线程占用
                setExclusiveOwnerThread(Thread.currentThread());//设置当前线程拥有独占权限
                return true;
            }
            return false;
        }
        //释放锁，将状态设置为0
        protected boolean tryRealse(int release){
            if(getState() == 0){
                /*这个异常意味着：
                一个线程在不拥有指定监视器的情况下，尝试等待一个对象的监视器或者通知其他线程等待一个对象的监视器
                简单的说在线程不拥有锁的情况下尝试解锁就会抛出该异常
                */
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        //返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }
    //仅需要将操作代理到Sync上即可。
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public boolean isLocked(){
        return  sync.isHeldExclusively();
    }
}
