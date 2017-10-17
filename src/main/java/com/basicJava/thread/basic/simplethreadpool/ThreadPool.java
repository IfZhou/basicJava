package com.basicJava.thread.basic.simplethreadpool;

/**
 * Created by zhouyifu on 2017/10/16.
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();
}
