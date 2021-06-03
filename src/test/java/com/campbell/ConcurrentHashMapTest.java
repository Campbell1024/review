package com.campbell;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Campbell
 * @date 2020/8/8
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            map.put("d", 1);
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void testConcurrentHashMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 2000; i++) {
            map.put("第" + (i + 1) + "个", i);
        }

        Runnable r1 = () -> {
            for (int i = 0; i < 500; i++) {
                map.remove("第" + (i + 1) + "个");
            }
        };

        Runnable r2 = () -> {
            for (int i = 1000; i < 1500; i++) {
                map.remove("第" + (i + 1) + "个");
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.size());
    }
}
