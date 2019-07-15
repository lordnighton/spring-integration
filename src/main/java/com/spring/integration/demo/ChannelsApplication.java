package com.spring.integration.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

public class ChannelsApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/channel-example-beans.xml");
		context.start();

		MessageChannel inputChannel = context.getBean("input", MessageChannel.class);
		inputChannel.send(MessageBuilder.withPayload("Hello world!").build());

		PollableChannel outputChannel = context.getBean("output", PollableChannel.class);

		Message<?> handledMessage = outputChannel.receive();
		System.out.println("Handled message = " + handledMessage);

		context.close();
	}

}
