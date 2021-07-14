package com.campbell.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Campbell
 * @date 2021/7/13
 */
@Data
public class User {

    private Integer uid;

    private String username;

    private String sex;

    private Date birthday;

    private String address;
}
