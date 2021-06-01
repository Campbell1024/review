package com.campbell;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ReviewApplication.class)
@Slf4j
public class BaseTest {

    @BeforeAll
    protected static void beforeAll() {
        System.out.println("初始化");
    }

    @AfterAll
    protected static void afterAll() {
        System.out.println("清除");
    }

    @BeforeEach
    protected void beforeEach() {
        System.out.println("测试开始");
    }

    @AfterEach
    protected void afterEach() {
        System.out.println("测试结束");
    }

}
