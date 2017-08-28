package com.basicJava.model;

import java.util.Date;

/**
 * Created by zhouyifu on 2017/4/9.
 */
public class DynFlight {
    //航空公司
    private Airlines airlines;
    //执行日期
    private Date execdate;

    public DynFlight(Airlines airlines ,Date dt) {
        this.airlines=airlines;
        this.execdate=dt;
    }

    public Airlines getAirlines() {
        return airlines;
    }

    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    public Date getExecdate() {
        return execdate;
    }

    public void setExecdate(Date execdate) {
        this.execdate = execdate;
    }
}
