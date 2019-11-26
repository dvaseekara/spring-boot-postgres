package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Employee;

import com.example.postgresdemo.model.EmployeeAssignment;
import com.example.postgresdemo.model.Survey;
import com.example.postgresdemo.repository.EmployeeRepository;
import com.example.postgresdemo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @GetMapping("/employee/{employeeId}/projects")
    public Set<EmployeeAssignment> getEmployeeProjects(@PathVariable Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).getEmployeeAssignments();
    }

    @GetMapping("/employee/{employeeId}/surveys")
    public Set<Survey> getEmployeeSurveys(@PathVariable Long employeeId) {
        return surveyRepository.findByEmployeeId(employeeId);
        //return surveyRepository.findByEmployeeId(employeeId);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/employee/addProject/{employeeId}/{project_id}")
    public void addEmployeeToProject(@PathVariable Long employeeId, Long projectId){
        //Insert int EmployeeAssisngment
        //Get employees already on project
        //For each employee, INSERT two surveys one as employee and other as reviewer
    }

    @PostMapping("/employee/removeProject/{employeeId}/{project_id}")
    public void removeEmployeeFromProject(@PathVariable Long employeeId, Long projectId){
        //Insert int EmployeeAssisngment
        //DELETE SURVEY where porject_id = ? and reviewer_id = ?
        //DELETE SURVEY where project_id = ? and employee_id = ?
    }

    @DeleteMapping("/employee/{employee_id}")
    public void deleteEmployee(@PathVariable Long employeeId){
        //DELETE EMPLOYEEASSIGNMENT
        //DELETE SURVEYS where reviewer_id = ?
        //DELETE SURVEYS where employee_id = ?
        //DELETE EMPLOYEE where id = ?
    }

}
