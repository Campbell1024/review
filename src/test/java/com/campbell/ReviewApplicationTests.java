package com.campbell;

import com.alibaba.fastjson.JSONObject;
import com.campbell.constants.Grade;
import com.campbell.entity.Person;
import com.campbell.entity.Student;
import com.campbell.entity.Teacher;
import com.campbell.service.PersonTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ReviewApplication.class)
@Slf4j
public class ReviewApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        System.out.println("aa" instanceof Object);
    }

    @Test
    public void test2() {
        System.out.println(String.class.getName());
    }

    @Test
    public void test3() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 20, "0001"));
        studentList.add(new Student("lisi", 21, "0002"));
        studentList.add(new Student("wangwu", 22, "0003"));
        PersonTest.show1(studentList);

        System.out.println("************分割线**************");

        List list = new ArrayList();
        list.add(new Student("小白", 18, "0010"));
        list.add(new Teacher("王", 30));
        list.add(new Person("人", 10));
        PersonTest.show2(list);

        System.out.println(Student.class.getName());

        Person person = new Teacher();
        System.out.println(person.getClass().getName());

        PersonTest.getClassName(new ConcurrentHashMap<>());

        if (Objects.nonNull(person)) {
            System.out.println(Objects.nonNull(person));
        }

        try {
            Person person1 = Person.class.newInstance();
            person1.setName("");
            person1.setAge(0);
            person1.setGender(0);
            System.out.println(JSONObject.toJSONString(person1));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(Person.class.getPackage().getName());
    }

    @Test
    public void test4() {
        while (true) {
            System.out.println("请输入年级：");
            int i = 0;
            try {
                Scanner scanner = new Scanner(System.in);
                i = scanner.nextInt();
            } catch (Exception e) {
                log.error("error", e);
            }
            String gradeName;
            switch (i) {
                case Grade.GRADE_ONE_CODE:
                    gradeName = Grade.GRADE_ONE_NAME;
                    break;
                case Grade.GRADE_TWO_CODE:
                    gradeName = Grade.GRADE_TWO_NAME;
                    break;
                case Grade.GRADE_THREE_CODE:
                    gradeName = Grade.GRADE_THREE_NAME;
                    break;
                case Grade.GRADE_FOUR_CODE:
                    gradeName = Grade.GRADE_FOUR_NAME;
                    break;
                case Grade.GRADE_FIVE_CODE:
                    gradeName = Grade.GRADE_FIVE_NAME;
                    break;
                case Grade.GRADE_SIX_CODE:
                    gradeName = Grade.GRADE_SIX_NAME;
                    break;
                default:
                    gradeName = null;
                    break;
            }
            log.info(gradeName);
            if (i == 3) {
                break;
            }
        }
    }

    @Test
    public void test5() {
        //构造方法的方式得到对象
        char[] chs = {'a', 'b', 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);

        //直接赋值的方式得到对象
        String s3 = "abc";
        String s4 = "abc";

        //比较字符串对象地址是否相同
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("--------");

        //比较字符串内容是否相同
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }

    @Test
    public void test6() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        date.setTime(0);
        System.out.println(date);

        System.out.println("--------------------");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        System.out.println(time);

        String time2 = "2020-01-01 12:00:00";
        try {
            Date date1 = sdf.parse(time2);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalendar() {
        System.out.println("请输入年份：");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 2, 1);
        calendar.add(Calendar.DATE, -1);
        int day = calendar.get(Calendar.DATE);
        System.out.println(day);
    }

    @Test
    public void testSystem() {
        new Person();
        new Person();
        new Person();
        new Person();
        new Person();
        System.gc();
    }

    @Test
    public void testString() {
        String tel = "18896813767";
        String telReg = "1[345678][0-9]{9}";
        boolean flag = tel.matches(telReg);
        System.out.println(flag);

        Student student = Student.builder()
                .name("aa")
                .age(1)
                .gender(2)
                .num("22")
                .grade(2)
                .build();

        System.out.println(JSONObject.toJSONString(student));
    }

    @Test
    public void testEquals() {
        Integer a = 1;
        Integer b = 1;
        Integer c = new Integer(1);
        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(a == c);
        System.out.println(a.equals(c));

        String aa = "a";
        String bb = "a";
        String cc = new String("a");
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));

        System.out.println(aa == cc);
        System.out.println(aa.equals(cc));

        System.out.println("************分割线************");

        Person person1 = new Person("zhangsan", 18);
        Person person2 = new Person("zhangsan", 18);
        System.out.println(person1.equals(person2));
        System.out.println(person1 == person2);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1.hashCode() == person2.hashCode());

        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        System.out.println(JSONObject.toJSONString(personSet));

        Map<Person,String> map = new HashMap<>();
        map.put(person1, person1.getName());
        map.put(person2, person2.getName());
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void testIterator() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三", 12));
        personList.add(new Person("李四", 15));
        personList.add(new Person("王五", 18));
        System.out.println(personList.toString());
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if ("张三".equals(person.getName())) {
                personIterator.remove();
            }
        }
        System.out.println(personList.toString());
    }

    @Test
    public void testComparator() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("rose", 18));
        list.add(new Person("jack", 16));
        list.add(new Person("abc", 20));
        Collections.sort(list, Comparator.comparingInt(Person::getAge).reversed());
        list.forEach(person -> System.out.println(person));

        List<Integer> ageList = list.stream().sorted(Comparator.comparingInt(Person::getAge)).map(Person::getAge).collect(Collectors.toList());
        System.out.println(ageList.toString());
        Optional<Person> personOptional = list.stream().findFirst();
        personOptional.ifPresent(person -> System.out.println(person));
    }

    @Test
    public void testMap(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("rose", 18));
        list.add(new Person("jack", 16));
        list.add(new Person("abc", 20));

        Map<String,Person> personMap = list.stream().collect(Collectors.toMap(Person::getName, person -> person));

        Set<String> nameSet = personMap.keySet();
        System.out.println(JSONObject.toJSONString(nameSet));

        Collection<Person> personCollection = personMap.values();
        System.out.println(JSONObject.toJSONString(personCollection));

        System.out.println(personMap.containsKey("rose"));

        Set<Map.Entry<String,Person>> entrySet = personMap.entrySet();
        System.out.println(JSONObject.toJSONString(entrySet));
        System.out.println(JSONObject.toJSONString(personMap));

        nameSet.forEach(name -> {
            System.out.println(name+":"+JSONObject.toJSONString(personMap.get(name)));
        });

        for (Map.Entry<String,Person> entry : personMap.entrySet()){
            System.out.println(entry.getKey()+":"+JSONObject.toJSONString(entry.getValue()));
        }

        personMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()+":"+JSONObject.toJSONString(entry.getValue()));
        });

        Properties properties = new Properties();
        //存储键值对
        properties.setProperty("k1","v1");
        properties.setProperty("k2","v2");
        properties.setProperty("k3","v3");
        properties.setProperty("k4","v4");
        System.out.println(properties);
        //获取k2键对应的值
        String value = properties.getProperty("k2");
        System.out.println(value);
        //所有的键存储到Set集合
        Set<String> set = properties.stringPropertyNames();
        for(String key : set){
            System.out.println(key+"=="+properties.getProperty(key));
        }
    }

}
