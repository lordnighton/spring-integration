package com.spring.integration.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

public class MessageTransformerApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/queue-transformation-beans.xml");
		context.start();

		JmsTemplate template = context.getBean("jmsTemplate", JmsTemplate.class);
		template.send(new MessageCreator() {
			@Override
			public javax.jms.Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString("surname", "Lord");
				message.setString("name", "Nighton");
				message.setString("id", "2");

				System.out.println("Sending message: " + message);

				return message;
			}
		});

		PollableChannel outputChannel = (PollableChannel) context.getBean("outputChannel");
		Message<?> reply = outputChannel.receive();
		System.out.println("received: " + reply.getPayload());

		context.close();
	}

}
