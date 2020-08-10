package com.campbell.service.impl;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author Campbell
 * @date 2020/8/1
 */
public class Generic<T> {

    /**
     * 泛型可变参数
     *
     * @param list
     */
    public void showGeneric(T... list) {
        for (T t : list) {
            System.out.println(JSONObject.toJSONString(t));
        }
    }

    public void showList(List<T> list) {
        list.forEach(t -> System.out.println(JSONObject.toJSONString(t)));
    }

    /**
     * 通配符上限
     *
     * @param list
     */
    public void showCommon(List<? extends T> list) {
        list.forEach(o -> System.out.println(JSONObject.toJSONString(o)));
    }

}
