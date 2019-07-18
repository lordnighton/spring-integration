package com.spring.integration.domain;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private long id;

    private String name;

    private String surname;

}