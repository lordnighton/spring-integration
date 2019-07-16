package com.spring.integration.services;

import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.support.MessageBuilder;

public class TicketProducer {

    private QueueChannel channel;

    private TicketFactory ticketFactory;

    public void produceTickets() {
        ticketFactory.generateTickets().forEach(ticket -> channel.send(MessageBuilder.withPayload(ticket).build()));
    }

    public QueueChannel getChannel() {
        return channel;
    }

    public void setChannel(QueueChannel channel) {
        this.channel = channel;
    }

    public TicketFactory getTicketFactory() {
        return ticketFactory;
    }

    public void setTicketFactory(TicketFactory ticketFactory) {
        this.ticketFactory = ticketFactory;
    }
}