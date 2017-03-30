package com.basicJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouyifu on 2017/3/27.
 */
@Controller
public class GuavaController {


    @RequestMapping("/basicUtilities")
    public Map basicUtilities() {




        return new HashMap();
    }
}
