package com.campbell.service;

import com.campbell.annotations.Book;
import com.campbell.annotations.BookStore;
import com.campbell.annotations.MyTest;
import com.campbell.annotations.MyTestDemo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Campbell
 * @date 2020/9/26
 */
public class AnnotationTest {

    @Test
    public void testAnnotation() {
        Class cla = BookStore.class;
        if (cla.isAnnotationPresent(Book.class)) {
            Book book = (Book) cla.getAnnotation(Book.class);
            System.out.println(book.value());
            System.out.println(book.price());
            System.out.println(Arrays.toString(book.authors()));
        }
    }

    @Test
    public void myTest() throws Exception {
        Class cla = MyTestDemo.class;
        Method[] methods = cla.getMethods();
        Object object = cla.newInstance();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(object);
            }
        }
    }
}
