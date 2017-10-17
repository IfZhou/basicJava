package com.basicJava.thread.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by zhouyifu on 2017/10/11.
 *
 * 用JMX查看普通Java程序包含哪些线程
 *
 * 输出为：
 * [8] JDWP Command Reader
 [7] JDWP Event Helper Thread
 [6] JDWP Transport Listener: dt_socket
 [5] Attach Listener
 [4] Signal Dispatcher
 [3] Finalizer
 [2] Reference Handler
 [1] main
 */
public class MultiThread {

    public static void main(String[] args){
        //获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for(ThreadInfo threadInfo : threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"] "+ threadInfo.getThreadName());
        }
    }
}
