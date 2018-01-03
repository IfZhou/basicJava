package com.basicJava.service;

import com.basicJava.model.Airlines;
import com.basicJava.model.DynFlight;
import com.basicJava.model.sortClass;
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
        List<String> newList = names.stream().filter(name->name.equals("ZhiFuBao")).map(String::toString).collect(Collectors.toList());
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
        ICommonService service = new   JavaFeatureService();

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        LinkedHashSet<String> linkedHashSet =new LinkedHashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        service.excuteTest();

        Class class1 = JavaFeatureService.class;
        Class class2  = service.getClass();
//        JavaFeatureService  service = new   JavaFeatureService();
//        service.test(service.str);

        /**
         * 排序
         */
//        List<DynFlight> dynFlightList = new ArrayList<>();
//        Date dt =new Date();
//        dynFlightList.add(new DynFlight(new Airlines("CZ"),dt));
//        dynFlightList.add(new DynFlight(new Airlines("CA"),dt));
//        dynFlightList.add(new DynFlight(new Airlines("CA"),new Date(dt.getTime()+1000*60*60*24)));
//        sortClass sortob =new sortClass();
//        Collections.sort(dynFlightList,sortob);




    }





}
