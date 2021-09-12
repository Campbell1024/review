package com.campbell.entity;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Campbell
 * @date 2021/6/16
 */
public class ProxyDemo {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("aaa");
        strings.add("aaa");
        strings.add("bbb");
        strings.add("bbb");
        strings.add("bbb");
        strings.remove("aaa");
        System.out.println(strings);
        List<String> proxy = (List<String>) Proxy.newProxyInstance(strings.getClass().getClassLoader(), ArrayList.class.getInterfaces(), (p, m, a) -> {
            Object result = m.invoke(strings, a);
            if ("remove".equals(m.getName())) {
                Iterator<String> it = strings.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(a[0])) {
                        it.remove();
                    }
                }
            }
            return result;
        });
        proxy.remove("aaa");
        System.out.println(strings);
        proxy.set(0, "aaa");
        System.out.println(strings);
    }
}
