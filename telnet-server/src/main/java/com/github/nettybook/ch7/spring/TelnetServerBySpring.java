package com.github.nettybook.ch7.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TelnetServerBySpring {
	public static void main(String[] args) {
		AbstractApplicationContext springContext = null;
		try {
			springContext = new AnnotationConfigApplicationContext(
					TelnetServerConfig.class);
			springContext.registerShutdownHook();

			TelnetServer server = springContext.getBean(TelnetServer.class);
			server.start();
		}
		finally {
			springContext.close();
		}
	}
}
