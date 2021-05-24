package com.app.main;

import com.app.model.Hello;
import com.app.model.HelloLazy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello h1=(Hello)context.getBean("h1");
        System.out.println("From main: "+h1.getMessage());
        System.out.println("Identity hashcode of h1: "+System.identityHashCode(h1));

        Hello h2=(Hello)context.getBean("h2");
//        Hello h2=context.getBean(Hello.class);
        System.out.println("From main: "+h2.getMessage());
        System.out.println("Identity hashcode of h2: "+System.identityHashCode(h2));

        Hello h3=(Hello)context.getBean("h3");
        System.out.println("From main: "+h3.getMessage());
        System.out.println("Identity hashcode of h3: "+System.identityHashCode(h3));

        HelloLazy hl=(HelloLazy) context.getBean("hl");
        System.out.println("From main: "+hl.getMessage());
        System.out.println("Identity hashcode of hl: "+System.identityHashCode(hl));
    }
}
