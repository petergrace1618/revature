package com.app.main;

import com.app.config.SpringBeanConfig;
import com.app.model.Hello;
import com.app.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        Hello h1 = (Hello) context.getBean("h1");
        System.out.println(h1.getMessage());

        MyService m1 = (MyService) context.getBean("myservice");
        m1.helloService();
    }
}
