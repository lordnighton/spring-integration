package com.spring.integration.demo;

import com.google.common.collect.ImmutableMap;
import com.spring.integration.handlers.TicketReceiver;
import com.spring.integration.services.TicketProducer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class TransformerApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/transformer-beans.xml");
		context.start();

		QueueChannel channel = (QueueChannel) context.getBean("channel");
		channel.send(MessageBuilder.withPayload(ImmutableMap.of("id", "1", "name" , "Lord", "surname" , "Nighton")).build());

		Message<?> message = channel.receive(1000);
		System.out.println(message);

		context.close();
	}

}
