package com.campbell.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.campbell.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Campbell
 * @date 2020/8/2
 */
public class CollectionTest {

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
        System.out.println(people);
    }

    @Test
    public void testIterator() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三", 12));
        personList.add(new Person("李四", 15));
        personList.add(new Person("王五", 18));
        System.out.println(JSONObject.toJSONString(personList));
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if ("张三".equals(person.getName())) {
                personIterator.remove();
            }
        }
        System.out.println(JSONObject.toJSONString(personList));
    }

    @Test
    public void testComparator() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("rose", 18));
        list.add(new Person("jack", 16));
        list.add(new Person("abc", 20));
        list.forEach(System.out::println);

        list.sort(Comparator.comparingInt(Person::getAge).reversed());
        Collections.sort(list, Comparator.comparingInt(Person::getAge).reversed());

        List<Integer> ageList = list.stream().sorted(Comparator.comparingInt(Person::getAge)).map(Person::getAge).collect(Collectors.toList());
        System.out.println(ageList.toString());

        Optional<Person> personOptional = list.stream().findFirst();
        personOptional.ifPresent(System.out::println);
    }

    @Test
    public void testMap() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("rose", 18));
        list.add(new Person("jack", 16));
        list.add(new Person("abc", 20));

        Map<String, Person> personMap = list.stream().collect(Collectors.toMap(Person::getName, person -> person));

        Set<String> nameSet = personMap.keySet();
        System.out.println(JSONObject.toJSONString(nameSet));

        Collection<Person> personCollection = personMap.values();
        System.out.println(JSONObject.toJSONString(personCollection));

        System.out.println(personMap.containsKey("rose"));

        Set<Map.Entry<String, Person>> entrySet = personMap.entrySet();
        System.out.println(JSONObject.toJSONString(entrySet));
        System.out.println(JSONObject.toJSONString(personMap));

        nameSet.forEach(name -> {
            System.out.println(name + ":" + JSONObject.toJSONString(personMap.get(name)));
        });

        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + JSONObject.toJSONString(entry.getValue()));
        }

        personMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + JSONObject.toJSONString(entry.getValue()));
        });

        Properties properties = new Properties();
        //存储键值对
        properties.setProperty("k1", "v1");
        properties.setProperty("k2", "v2");
        properties.setProperty("k3", "v3");
        properties.setProperty("k4", "v4");
        System.out.println(properties);
        //获取k2键对应的值
        String value = properties.getProperty("k2");
        System.out.println(value);
        //所有的键存储到Set集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "==" + properties.getProperty(key));
        }
    }
}
