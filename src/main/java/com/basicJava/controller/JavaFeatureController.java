package com.basicJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by zhouyifu on 2017/3/3.
 */
@Controller
@RequestMapping("/java")
public class JavaFeatureController {

    @RequestMapping("/test")
    public Map test() {
        List<String> strList =new ArrayList<>();
        return new HashMap();
    }
}
