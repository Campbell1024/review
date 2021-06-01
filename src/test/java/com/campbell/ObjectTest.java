package com.campbell;

import com.alibaba.fastjson.JSONObject;
import com.campbell.entity.Person;
import com.campbell.entity.Student;
import com.campbell.entity.Teacher;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Campbell
 * @date 2020/6/27
 */
public class ObjectTest extends BaseTest {

    /**
     * 方法的多态
     *
     * @param person
     */
    public void test(Person person) {
        person.work();
    }

    /**
     * 使用匿名内部类重写方法
     */
    @Test
    public void testObject() {
        test(new Person());
        test(new Student());
        test(new Teacher());

        Student student = new Student() {
            @Override
            public void work() {
                System.out.println("打游戏");
            }
        };
        student.work();
    }

    /**
     * 对象是否相等
     */
    @Test
    public void testEquals() {
        Integer a = 1;
        Integer b = 1;
        Integer c = new Integer(1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == c);
        System.out.println(a.equals(c));

        System.out.println("************分割线************");

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

        Map<Person, String> map = new HashMap<>();
        map.put(person1, person1.getName());
        map.put(person2, person2.getName());
        System.out.println(JSONObject.toJSONString(map));
    }
}
