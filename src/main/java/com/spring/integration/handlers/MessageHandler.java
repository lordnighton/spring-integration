package com.spring.integration.handlers;

public class MessageHandler {

    public String handleMessage(final String message) {
        System.out.println("Message obtained = " + message);

        return "MESSAGE: " + message;
    }

}