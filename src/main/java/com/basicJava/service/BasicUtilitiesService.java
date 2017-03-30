package com.basicJava.service;


import com.basicJava.model.OrderingFoo;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Ordering;
import org.springframework.stereotype.Service;
import com.google.common.base.Preconditions;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyifu on 2017/3/27.
 */

@Service
public class BasicUtilitiesService implements  ICommonService {
    private String section;

    @Override
    public Map<String, Object> excuteTest() {
        return null;
    }

    /**
     * 条件判断
     */
    public void preconditions(){

        // 抛出IllegalArgumentException异常
        Preconditions.checkArgument(3>4,"看看3>4是否成立");

        //IndexOutOfBoundsException异常
        Preconditions.checkPositionIndexes(3,6,8);
        //IndexOutOfBoundsException异常
        Preconditions.checkElementIndex(1,10);
        //NullPointerException异常
        Object ob = null;
        Preconditions.checkNotNull(ob);
        //IllegalStateException异常
        boolean test= false;
        Preconditions.checkState(test);

    }

    /**
     *常见Object方法
     */
    public void objects(){
        //相等判断
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true

        //用对象的所有字段作散列[hash]运算。
        Objects.hashCode(new Object());

        //轻松编写有用的toString方法
        // Returns "ClassName{x=1}"
        MoreObjects.toStringHelper(this).add("x", 1).toString();
        // Returns "MyObject{x=1}"
        MoreObjects.toStringHelper("MyObject").add("x", 1).toString();

    }

    /**
     * 排序器
     */
    public void order(){
        //创建排序器
        Ordering<OrderingFoo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<OrderingFoo, String>() {
            public String apply(OrderingFoo foo) {
                return foo.getSortedBy();
            }
        });

        List<OrderingFoo> orderingFooList = new ArrayList<>();
        orderingFooList.add(new OrderingFoo("bca"));
        orderingFooList.add(new OrderingFoo("abc"));
        orderingFooList.add(new OrderingFoo("cba"));
        //运用排序器
        ordering.sortedCopy(orderingFooList);

    }
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    public static void main(String[] args){
        BasicUtilitiesService basicUtilitiesService = new BasicUtilitiesService();
//        basicUtilitiesService.preconditions();
//        basicUtilitiesService.objects();
        basicUtilitiesService.order();
    }




}
