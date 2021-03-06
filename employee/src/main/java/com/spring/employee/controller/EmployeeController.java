package com.spring.employee.controller;

import com.spring.employee.model.Datum;
import com.spring.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployeeList")
    public List<Datum> getListofEmp() throws IOException {
        return employeeService.getAllEmployees();
    }

}
