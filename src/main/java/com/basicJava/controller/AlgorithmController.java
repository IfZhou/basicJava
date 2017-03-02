package com.basicJava.controller;

import com.basicJava.service.SingleLinkedListReversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by zhouyifu on 2017/2/28.
 */
@Controller
@RequestMapping("/algorithm")
public class AlgorithmController {

    @Autowired
    SingleLinkedListReversalService singleLinkedListReversalService;

    @RequestMapping("/singleLinkedListReversal")
    public Map SingleLinkedListReversal(){
        return singleLinkedListReversalService.excuteTest();
    }
}
