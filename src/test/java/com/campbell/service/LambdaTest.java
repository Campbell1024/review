package com.campbell.service;

import com.alibaba.fastjson.JSONObject;
import com.campbell.entity.Person;
import com.campbell.entity.Student;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Campbell
 * @date 2020/9/22
 */
public class LambdaTest {

    @Test
    public void supplierTest() {
        int[] array = {10, 20, 100, 30, 40, 50};
        printMax(() -> {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        });
    }

    public void printMax(Supplier<Integer> supplier) {
        int max = supplier.get();
        System.out.println(max);
    }

    @Test
    public void consumerTest() {
        String s = "hello";
        printString(string -> {
            System.out.println(string);
        }, s);
    }

    public void printString(Consumer<String> consumer, String s) {
        consumer.accept(s);
    }

    @Test
    public void functionTest() {
        String s = "10";
        changeType(string -> Integer.parseInt(string), s);
    }

    public void changeType(Function<String, Integer> function, String s) {
        int num = function.apply(s);
        System.out.println(num + 10);
    }

    @Test
    public void predicateTest() {
        System.out.println("请输入日期：");
        String s = new Scanner(System.in).nextLine();
        judgeString(string -> {
            boolean flag = true;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setLenient(false);
            try {
                sdf.parse(string);
            } catch (ParseException e) {
                flag = false;
            }
            return flag;
        }, s);
    }

    public void judgeString(Predicate<String> predicate, String s) {
        boolean result = predicate.test(s);
        System.out.println("日期格式是否正确？" + (result == true ? "正确" : "错误"));
    }

    @Test
    public void streamTest() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);

        long limit = list.stream().filter(s -> s.startsWith("张")).limit(2).count();
        System.out.println(limit);

        long skip = list.stream().filter(s -> s.startsWith("张")).skip(2).count();
        System.out.println(skip);

        Stream<String> streamA = Stream.of("张三", "李四");
        Stream<String> streamB = Stream.of("王五", "赵六");
        Stream<String> result = Stream.concat(streamA, streamB);
        List<Character> charList = result.map(string -> string.charAt(0)).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(charList));
    }

}
