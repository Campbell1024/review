package com.campbell.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Campbell
 * @date 2020/6/30
 */
@SuperBuilder
@Data
public class Teacher extends Person {

    private Integer type;

    private Integer level;

    public Teacher() {

    }

    public Teacher(String name, Integer age) {
        this(name, age, 1, 1, 1);
    }

    public Teacher(String name, Integer age, Integer gender, Integer type, Integer level) {
        super(name, age, gender);
        this.type = type;
        this.level = level;
    }

    @Override
    public void work() {
        System.out.println("教学");
    }
}
