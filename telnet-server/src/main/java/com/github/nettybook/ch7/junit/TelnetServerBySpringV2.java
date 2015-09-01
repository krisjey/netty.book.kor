package com.github.nettybook.ch7.junit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TelnetServerBySpringV2 {
    public static void main(String[] args) {
        AbstractApplicationContext springContext = null;
        try {
            springContext = new AnnotationConfigApplicationContext(
                    TelnetServerConfigV2.class);
            springContext.registerShutdownHook();

            TelnetServerV3 server = springContext.getBean(TelnetServerV3.class);
            server.start();
        }
        finally {
            springContext.close();
        }
    }
}
