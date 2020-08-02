package com.campbell.service;

import com.campbell.entity.Person;
import com.campbell.entity.Student;
import com.campbell.entity.Teacher;
import com.campbell.service.impl.Common;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Campbell
 * @date 2020/8/1
 */
@Slf4j
public class CommonTest {

    @Test
    public void testCommon() {
        Common<Person> common = new Common<>();

        common.showGeneric(new Student("a", 1, "1"),new Teacher("a",1));

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", 1));
        personList.add(new Person("b", 2));
        common.showList(personList);

        List<Student> students = new ArrayList<>();
        students.add(new Student("a", 1, "1"));
        students.add(new Student("b", 2, "2"));
        common.showCommon(students);
    }

    @Test
    public void testInstance() {
        System.out.println("aa" instanceof Object);
    }

    @Test
    public void testClassName() {
        System.out.println(Student.class.getName());
        System.out.println(new Student().getClass().getName());
    }
}
