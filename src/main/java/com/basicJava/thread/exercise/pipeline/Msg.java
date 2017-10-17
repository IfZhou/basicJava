package com.basicJava.thread.exercise.pipeline;

/**
 * Created by zhouyifu on 2017/9/29.
 *
 * 实现流水线模式
 *
 * 定义一个计算中间体
 * 计算(B+C)*B/2=?
 * 适用场景:将我们串行的程序分为一步步流水
 */
public class Msg {
    public double i;
    public double j;
    public String orgStr=null;
}
