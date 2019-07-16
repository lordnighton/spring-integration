package com.spring.integration.handlers;

import com.spring.integration.domain.Ticket;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;

public class TicketReceiver implements Runnable {

    private long timeout;

    private QueueChannel channel;

    @Override
    public void run() {
        for (;;) {
            Message<?> ticketMessage = channel.receive(timeout);
            if (ticketMessage == null) {
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Ticket ticket = (Ticket) ticketMessage.getPayload();
                System.out.println(ticket);
            }
        }
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public QueueChannel getChannel() {
        return channel;
    }

    public void setChannel(QueueChannel channel) {
        this.channel = channel;
    }
}