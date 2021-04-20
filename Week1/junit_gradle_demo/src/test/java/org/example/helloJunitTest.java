package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class helloJunitTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Hello from beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    public void helloTest1() {
        System.out.println("Test1");
    }

    @Test
    public void helloTest2() {
        System.out.println("Test2");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Hello from afterAll");
    }
}
