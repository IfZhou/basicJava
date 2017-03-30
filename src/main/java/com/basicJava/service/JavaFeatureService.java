package com.basicJava.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhouyifu on 2017/3/3.
 */
@Service
public class JavaFeatureService implements  ICommonService{
    @Override
    public Map<String, Object> excuteTest() {
        this.lambdaFeature();

        return null;
    }

    /**
     * lambda表达式
     */
    void lambdaFeature(){
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");
//        List<String> lowercaseNames = names.stream().map((name) ->
//                                        {
//                                            return name.toLowerCase();
//                                        }).collect(Collectors.toList());

        //与上述写法等价
        List<String> lowercaseNames = names.stream().map(String::toLowerCase).collect(Collectors.toList());

        String[] arrstr ={"111","222","333"};
        List<Integer> arrint = Arrays.stream(arrstr).map(Integer::parseInt).collect(Collectors.toList());
    }
    public String str="test";
    public void test(String str1){
        str1="changed";
    }


    public static void main(String[] args){
//        ICommonService service = new   JavaFeatureService();

//        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
//        LinkedHashSet<String> linkedHashSet =new LinkedHashSet<>();
//        ArrayList<String> arrayList = new ArrayList<>();
//        service.excuteTest();
        JavaFeatureService  service = new   JavaFeatureService();
        service.test(service.str);
    }


}
