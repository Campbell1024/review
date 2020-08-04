package com.campbell.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Campbell
 * @date 2020/6/30
 */
@SuperBuilder
@Data
public class Student extends Person{

    private String num;

    private Integer grade;

    public  Student(){

    }

    public Student(String name,Integer age,String num){
        this(name,age,1,num,1);
    }

    public  Student(String name,Integer age,Integer gender,String num,Integer grade){
        super(name, age, gender);
        this.num = num;
        this.grade = grade;
    }

    @Override
    public void work(){
        System.out.println("学习");
    }

}
