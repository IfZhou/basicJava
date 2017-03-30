package com.basicJava.model;


import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.sun.istack.internal.Nullable;

/**
 * Created by zhouyifu on 2017/3/27.
 */
public class OrderingFoo {
    @Nullable
     String sortedBy;
    int notSortedBy;

    public OrderingFoo() {
    }

    public OrderingFoo(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public int getNotSortedBy() {
        return notSortedBy;
    }

    public void setNotSortedBy(int notSortedBy) {
        this.notSortedBy = notSortedBy;
    }
}
