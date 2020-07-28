package com.campbell.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.campbell.ReviewApplicationTests;
import com.campbell.entity.Person;
import com.campbell.entity.Student;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Campbell
 * @date 2020/6/27
 */
public class PersonTest extends ReviewApplicationTests {

    @Test
    public void testPerson() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName("abc" + i);
            person.setAge(i);
            person.setGender(i);
            personList.add(person);
        }
        System.out.println(personList.size());
        String personString = JSONObject.toJSONString(personList);

        List<Person> people = JSONObject.parseObject(personString, new TypeReference<List<Person>>() {
        });
        System.out.println(people.get(0).getName());

        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            if (personIterator.next().getAge() == 1) {
                personIterator.remove();
            }
        }
        System.out.println(personList.size());

        Map<String, Person> map = new HashMap<>();

        personList.forEach(person -> {
            map.put(person.getName(), person);
        });

        System.out.println(map.size());
        System.out.println(JSONObject.toJSONString(map));

    }

    public static <T> void show1(List<T> list) {
        list.forEach(t -> {
            System.out.println(JSONObject.toJSONString(t));
        });
    }

    public static void show2(List<?> list) {
        list.forEach(object -> {
            System.out.println(JSONObject.toJSONString(object));
        });
    }

    public static <T> void getClassName(T t){
        System.out.println(t.getClass().getName());
    }

    /**
     * 使用匿名内部类重写方法
     */
    @Test
    public void testStudent(){
        Student student1 = new Student();
        student1.study();

        Student student2 = new Student(){
            @Override
            public void study() {
                System.out.println("打游戏");
            }
        };
        student2.study();
    }

}
