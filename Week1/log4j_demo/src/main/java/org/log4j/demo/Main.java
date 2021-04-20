package org.log4j.demo;

import org.apache.log4j.Logger;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.trace("TRACE");
        log.debug("DEBUG");
        log.info("INFO");
        log.warn("WARN");
        log.error("ERROR");
        log.fatal("FATAL");

        Service s = new Service();
        s.service1("testservice1");
        s.service2("testservice2");
    }
}
