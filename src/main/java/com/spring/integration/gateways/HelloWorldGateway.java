package com.spring.integration.gateways;

import org.springframework.integration.annotation.Gateway;

import java.util.concurrent.Future;

public interface HelloWorldGateway {

    @Gateway(requestChannel = "say.hello.channel")
    void sayHello(String name);

    @Gateway(requestChannel = "get.hello.channel")
    String getHelloMessage(String name);

    @Gateway(requestChannel = "get.hello.channel")
    Future getHelloMessageAsync(String name);

}
