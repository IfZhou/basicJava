package com.basicJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by zhouyifu on 2017/6/13.
 */
@Controller
public class JavaCoreConceptController {
/*
第三章习题
 */

    /**
     *习题1
     */
    @RequestMapping("/exercisesNo1")
    public void exercisesNo1(){
        Integer i;
        for(i = 1; i <= 1000; i++  ){
            System.out.println("number: "+ i.toString());
        }
    }

    @RequestMapping("/exercisesNo2")
    public void exercisesNo2(){
        Integer i;
        for(i = 1; i <= 1000; i++  ){
            System.out.println("number: "+ i.toString());
            if(i == 47)
                return ;
        }
    }
    @RequestMapping("/exercisesNo3")
    public void exercisesNo3(){
        Integer i;
        for(i = 1; i <= 10; i++  ){
            System.out.println("number: "+ i.toString());
            switch (i){//没有break，会从该case依次往下执行
                case 1:
                    System.out.println("case 1: "+ i.toString());
                    break;
                case 2:
                    System.out.println("case 2: "+ i.toString());
                    break;
                case 3:
                    System.out.println("case 3: "+ i.toString());
                    break;
                case 4:
                    System.out.println("case 4: "+ i.toString());
                    break;
                case 5:
                    System.out.println("case 5: "+ i.toString());
                    break;
                default:
                    System.out.println("case default: "+ i.toString());
                    break;
            }
        }
    }



/*
第四章习题
*/
    @RequestMapping("/charpter4Exe1")
    public void charpter4Exe1(){
        class test1{
            
        }
    }


    public static void main(String[] args){
        JavaCoreConceptController javaCoreConceptController = new JavaCoreConceptController();
        System.out.println("-------------------------------习题1-------------------------------");
        javaCoreConceptController.exercisesNo1();
        System.out.println("-------------------------------习题2-------------------------------");
        javaCoreConceptController.exercisesNo2();
        System.out.println("-------------------------------习题3-------------------------------");
        javaCoreConceptController.exercisesNo3();

    }

}
