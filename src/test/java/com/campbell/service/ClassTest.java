package com.campbell.service;

import com.alibaba.fastjson.JSONObject;
import com.campbell.ReviewApplicationTests;
import com.campbell.entity.Person;
import com.campbell.entity.Student;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author Campbell
 * @date 2020/8/2
 */
public class ClassTest extends ReviewApplicationTests {

    /**
     * 类的全限定名
     */
    @Test
    public void testClass() {
        Student student = null;
        try {
            student = Student.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        student.setName("a");
        student.setAge(0);
        student.setGender(0);
        if (Objects.nonNull(student) && student instanceof Person) {
            System.out.println(JSONObject.toJSONString(student));
            System.out.println(student.getClass().getName());
        }
        System.out.println(Student.class.getName());
        System.out.println(Student.class.getPackage().getName());
    }

}
