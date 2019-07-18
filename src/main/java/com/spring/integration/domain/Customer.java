package com.spring.integration.domain;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Customer {

    private long id;

    private String name;

    private String surname;

}