package com.basicJava.model;

/**
 * Created by zhouyifu on 2017/4/9.
 */
public class Airlines {

    //航空公司二字码（如CA、CZ、3U等）
    private String twocharcode;
    //航空公司中文名
    private String cnshortname;

    public Airlines(String twocharcode) {
        this.twocharcode = twocharcode;
    }

    public String getTwocharcode() {
        return twocharcode;
    }

    public void setTwocharcode(String twocharcode) {
        this.twocharcode = twocharcode;
    }

    public String getCnshortname() {
        return cnshortname;
    }

    public void setCnshortname(String cnshortname) {
        this.cnshortname = cnshortname;
    }
}
