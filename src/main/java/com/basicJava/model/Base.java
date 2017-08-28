package com.basicJava.model;

/**
 * Created by zhouyifu on 2017/3/30.
 */
public class Base {
    private String name ="I am Bease!";

    public  Base(){
        tellName();
    }

    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }


}
