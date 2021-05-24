package com.app.service;

public class MyService {

    public MyService() { }
    public void validate1() {
        System.out.println("MyService.validate1()");
    }
    public void validate2() {
        System.out.println("MyService.validate2()");
    }
    public void validate3() {
        System.out.println("MyService.validate3()");
    }
    public void testAround() {
        System.out.println("MyService.testAround()");
    }
    public void exceptionAdviceTest(int val) throws Exception {
        if (val != 666) {
            throw new ArithmeticException("val != 666");
        } else {
            System.out.println("Hail Satan!");
        }
    }
    public String returnHello() {
        return "MyService.returnHello()";
    }
    public String returnHelloAgain() {
        return "MyService.returnHelloAgain()";
    }
}
