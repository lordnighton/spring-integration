package com.spring.integration.demo;

import com.spring.integration.gateways.HelloWorldGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@ImportResource("config/integration-beans.xml")
public class HelloWorldApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HelloWorldApplication.class, args);
		HelloWorldGateway gateway = (HelloWorldGateway) ctx.getBean("helloWorldGateway");

		gateway.sayHello("Nick");

		String message = gateway.getHelloMessage("Nick (get message)");
		System.out.println(message);

		Future helloFuture = gateway.getHelloMessageAsync("Nick (get message async)");
		try {
			String helloFutureMsg = (String) helloFuture.get();
			System.out.println(helloFutureMsg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
