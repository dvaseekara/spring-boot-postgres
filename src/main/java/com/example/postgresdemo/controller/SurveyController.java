package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Employee;

import com.example.postgresdemo.model.EmployeeAssignment;
import com.example.postgresdemo.model.EmployeeSurveys;
import com.example.postgresdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;import java.util.List;
import java.util.Set;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    //fetch EMPLOYEE by PROJECT
    //fetch EMPLOYEES by TSM
    //CREATE EMPLOYEE
    //add PROJECT to EMPLOYEE
        //ADD surveys for EMPLOYEE and PEER combination
    //DELETE USER
        //Delete all surveys associated with EMPLOYEE


    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @GetMapping("/employee/{employeeId}/projects")
    public Set<EmployeeAssignment> getEmployeeProjects(@PathVariable Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).getEmployeeAssignments();
    }

    @GetMapping("/employee/{employeeId}/surveys")
    public Set<EmployeeSurveys> getEmployeeSurveys(@PathVariable Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).getEmployeeSurveys();
    }




}
