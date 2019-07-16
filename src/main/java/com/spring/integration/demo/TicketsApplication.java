package com.spring.integration.demo;

import com.spring.integration.handlers.TicketReceiver;
import com.spring.integration.services.TicketProducer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

public class TicketsApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/tickets-channel-beans.xml");
		context.start();

		TicketProducer producer = (TicketProducer) context.getBean("ticketProducer");
		producer.produceTickets();

		TicketReceiver receiver = (TicketReceiver) context.getBean("ticketReceiver");

		Thread thread = new Thread(receiver);
		thread.start();

		context.close();
	}

}
