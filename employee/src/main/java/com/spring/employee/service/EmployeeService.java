package com.spring.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.employee.model.Datum;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService{

    public List<Datum> getAllEmployees() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Datum datum = objectMapper.readValue
                (new File("src/main/resources/emp.json"), Datum.class);
        if(datum.getEmployeeSalary()>86000 && datum.employeeAge<45){
            return Arrays.asList(datum);
        }
        return Collections.emptyList();
    }
}
