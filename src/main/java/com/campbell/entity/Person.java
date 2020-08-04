package com.campbell.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

/**
 * @author Campbell
 * @date 2020/6/22
 */
@SuperBuilder
@Getter
@Setter
@ToString
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer gender;

    public Person(){

    }

    public Person(String name, Integer age){
        this(name,age,1);
    }

    public Person(String name, Integer age, Integer gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void work(){
        System.out.println("工作");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象被回收");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return name.equals(person.name) &&
                age.equals(person.age) &&
                gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
