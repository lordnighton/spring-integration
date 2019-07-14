package com.spring.integration.services;

public class HelloService {

    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }

    public String generateHelloMessage(String name) {
        return ("Hello " + name + "!!");
    }

}