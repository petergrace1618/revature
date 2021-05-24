package com.app.main;

import com.app.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aopbeans.xml");
        MyService service = (MyService) context.getBean("service");

        service.validate1();
        service.validate2();
        service.validate3();
        service.testAround();
        try {
            service.exceptionAdviceTest(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(service.returnHello());
        System.out.println(service.returnHelloAgain());
    }
}
