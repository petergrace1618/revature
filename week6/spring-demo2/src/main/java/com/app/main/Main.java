package com.app.main;

import com.app.model.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        Player p1=(Player) context.getBean("p1");
        System.out.println(p1+"\n\n");

        Player p2=(Player) context.getBean("p2");
        System.out.println(p2+"\n\n");

        Player p3=(Player) context.getBean("p3");
        System.out.println(p3);
    }
}