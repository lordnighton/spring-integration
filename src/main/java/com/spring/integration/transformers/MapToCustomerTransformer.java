package com.spring.integration.transformers;

import com.spring.integration.domain.Customer;

import java.util.Map;

public class MapToCustomerTransformer {

    public Customer convert(Map<String, String> map) {
        return Customer.builder().id(Long.valueOf(map.get("id"))).name(map.get("name")).name(map.get("surname")).build();
    }

}