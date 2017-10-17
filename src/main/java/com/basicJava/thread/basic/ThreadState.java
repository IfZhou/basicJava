package com.basicJava.thread.basic;

/**
 * Created by zhouyifu on 2017/10/11.
 *
 *具体的操作如下：
 *
 * 启动该程序后，打开命令行：
 *
 * C:\Users\zhouyifu>jps
 2688 RemoteMavenServer
 12440 Launcher
 13400 Jps
 15528 ThreadState
 14684

 C:\Users\zhouyifu>jstack 13400
 13400: no such process

 C:\Users\zhouyifu>jstack 15528
 2017-10-11 11:04:14
 Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.111-b14 mixed mode):

 "DestroyJavaVM" #17 prio=5 os_prio=0 tid=0x00000000022f5000 nid=0x2b40 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE
//Blocked-2阻塞在获取Block.class的锁上
 "Blocked-2" #16 prio=5 os_prio=0 tid=0x000000001d2ab000 nid=0x3f88 waiting for monitor entry [0x000000001e35f000]
 java.lang.Thread.State: BLOCKED (on object monitor)
 at com.basicJava.thread.basic.ThreadState$Blocked.run(ThreadState.java:49)
 - waiting to lock <0x000000076b416c38> (a java.lang.Class for com.basicJava.thread.basic.ThreadState$Blocked)
 at java.lang.Thread.run(Thread.java:745)
//BlockedThread-1获取了Block.class的锁
 "BlockedThread-1" #15 prio=5 os_prio=0 tid=0x000000001d2aa000 nid=0xa90 waiting on condition [0x000000001e25f000]
 java.lang.Thread.State: TIMED_WAITING (sleeping) //但一直在Sleep
 at java.lang.Thread.sleep(Native Method)
 at java.lang.Thread.sleep(Thread.java:340)
 at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 at com.basicJava.thread.basic.SleepUtils.second(SleepUtils.java:11)
 at com.basicJava.thread.basic.ThreadState$Blocked.run(ThreadState.java:49)
 - locked <0x000000076b416c38> (a java.lang.Class for com.basicJava.thread.basic.ThreadState$Blocked)
 at java.lang.Thread.run(Thread.java:745)
//在Waiting实力上等待
 "WaitingThread" #14 prio=5 os_prio=0 tid=0x000000001d2a9800 nid=0x49cc in Object.wait() [0x000000001e15e000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x000000076b413f10> (a java.lang.Class for com.basicJava.thread.basic.ThreadState$Waiting)
 at java.lang.Object.wait(Object.java:502)
 at com.basicJava.thread.basic.ThreadState$Waiting.run(ThreadState.java:34)
 - locked <0x000000076b413f10> (a java.lang.Class for com.basicJava.thread.basic.ThreadState$Waiting)
 at java.lang.Thread.run(Thread.java:745)
//一直在超时等待中
 "TimeWaitingThread" #13 prio=5 os_prio=0 tid=0x000000001d2a9000 nid=0x3530 waiting on condition [0x000000001e05f000]
 java.lang.Thread.State: TIMED_WAITING (sleeping)
 at java.lang.Thread.sleep(Native Method)
 at java.lang.Thread.sleep(Thread.java:340)
 at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 at com.basicJava.thread.basic.SleepUtils.second(SleepUtils.java:11)
 at com.basicJava.thread.basic.ThreadState$TimeWaiting.run(ThreadState.java:22)
 at java.lang.Thread.run(Thread.java:745)

 "Service Thread" #12 daemon prio=9 os_prio=0 tid=0x000000001be0e800 nid=0x41b0 runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "C1 CompilerThread2" #11 daemon prio=9 os_prio=2 tid=0x000000001be01000 nid=0x4d4c waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "C2 CompilerThread1" #10 daemon prio=9 os_prio=2 tid=0x000000001be00000 nid=0x4b0c waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "C2 CompilerThread0" #9 daemon prio=9 os_prio=2 tid=0x000000001be07000 nid=0x2dd8 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "JDWP Command Reader" #8 daemon prio=10 os_prio=0 tid=0x000000001bdee000 nid=0x3968 runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "JDWP Event Helper Thread" #7 daemon prio=10 os_prio=0 tid=0x000000001bdea800 nid=0x4ef8 runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "JDWP Transport Listener: dt_socket" #6 daemon prio=10 os_prio=0 tid=0x000000001bde7000 nid=0x75c runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001d1a3800 nid=0x3c74 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001bdc3000 nid=0xd68 runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001bda0000 nid=0x1984 in Object.wait() [0x000000001d0fe000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x000000076b308e98> (a java.lang.ref.ReferenceQueue$Lock)
 at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
 - locked <0x000000076b308e98> (a java.lang.ref.ReferenceQueue$Lock)
 at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
 at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

 "Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x00000000023e5000 nid=0x498 in Object.wait() [0x000000001cfff000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x000000076b306b40> (a java.lang.ref.Reference$Lock)
 at java.lang.Object.wait(Object.java:502)
 at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
 - locked <0x000000076b306b40> (a java.lang.ref.Reference$Lock)
 at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

 "VM Thread" os_prio=2 tid=0x000000001bd77800 nid=0x15b0 runnable

 "GC task thread#0 (ParallelGC)" os_prio=0 tid=0x000000000230a800 nid=0x1aa4 runnable

 "GC task thread#1 (ParallelGC)" os_prio=0 tid=0x000000000230c000 nid=0x4fc8 runnable

 "GC task thread#2 (ParallelGC)" os_prio=0 tid=0x000000000230e000 nid=0x89c runnable

 "GC task thread#3 (ParallelGC)" os_prio=0 tid=0x000000000230f800 nid=0x3b54 runnable

 "VM Periodic Task Thread" os_prio=2 tid=0x000000001d25a800 nid=0x3ab4 waiting on condition

 JNI global references: 1472
 *
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"Blocked-2").start();
    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized(Blocked.class){
                while (true){
                    SleepUtils.second(100);
                }
            }
        }
    }
}
