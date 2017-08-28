package com.basicJava.model;


/**
 * Created by zhouyifu on 2017/3/30.
 */
public class Dervied extends Base {
    private String name = "dervied";

    public Dervied(){
        tellName();
    }
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    public static void main(String[] args){
        new Dervied();
    }
}
