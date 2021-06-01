package com.campbell;

import com.campbell.annotation.Book;
import com.campbell.annotation.BookStore;
import com.campbell.annotation.MyTest;
import com.campbell.annotation.MyTestDemo;
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
