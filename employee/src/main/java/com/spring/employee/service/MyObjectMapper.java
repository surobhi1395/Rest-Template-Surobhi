package com.spring.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MyObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 4219938065516862637L;

    public MyObjectMapper() {
        super();
        enable(SerializationFeature.INDENT_OUTPUT);
    }

}
