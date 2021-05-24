package com.app.config;

import com.app.model.Hello;
import com.app.service.MyService;
import com.app.service.impl.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean(name="h1")
    public Hello getHello() {
        return new Hello("Hello from Bean Annotation Configuration");
    }

    @Bean(name="myservice")
    public MyService getMyService() {
        return new MyServiceImpl();
    }
}
