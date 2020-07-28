package com.campbell.service;

/**
 * @author Campbell
 * @date 2020/6/23
 */
public abstract class ContactAbstract implements ContactService{

    @Override
    public void call() {
        System.out.println("aa");
    }

    public abstract void close();
}
