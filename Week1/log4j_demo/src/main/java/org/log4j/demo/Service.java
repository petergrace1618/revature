package org.log4j.demo;

import org.apache.log4j.Logger;

public class Service {
    private static Logger log = Logger.getLogger(Service.class);
    public void service1(String val) {
        log.info("service1: "+val);
    }
    public void service2(String val) {
        log.info("service2: "+val);
    }
}
