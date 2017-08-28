package com.basicJava.model;

import java.util.Comparator;

/**
 * Created by zhouyifu on 2017/4/9.
 */
public class sortClass implements Comparator<DynFlight>{

    @Override
    public int compare(DynFlight o1, DynFlight o2) {
        int flag1 = o1.getExecdate().compareTo(o2.getExecdate());
        if(flag1==0){
            int flag2 = o1.getAirlines().getTwocharcode().compareTo(o2.getAirlines().getTwocharcode());
            return flag2;
        }
        return flag1;
    }
}
