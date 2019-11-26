package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Employee;

import com.example.postgresdemo.model.EmployeeAssignment;
import com.example.postgresdemo.model.Project;
import com.example.postgresdemo.model.Survey;
import com.example.postgresdemo.repository.EmployeeAssignmentRepository;
import com.example.postgresdemo.repository.EmployeeRepository;
import com.example.postgresdemo.repository.ProjectRepository;
import com.example.postgresdemo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeAssignmentRepository employeeAssignmentRepository;

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @GetMapping("/employee/{id}/projects")
    public Set<EmployeeAssignment> getEmployeeProjects(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get().getEmployeeAssignments();
        }else {
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }
    }

    @GetMapping("/employee/{id}/surveys")
    public Set<Survey> getEmployeeSurveys(@PathVariable Long id) {
        return surveyRepository.findByEmployeeId(id);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/addProject/{employeeId}/{projectId}")
    public Set<Survey> addEmployeeToProject(@PathVariable Long employeeId, @PathVariable Long projectId){
        Optional<Employee> employee  = employeeRepository.findById(employeeId);
        Optional<Project> project = projectRepository.findById(projectId);

        if(employeeAssignmentRepository.findByProjectIdAndEmployeeId(projectId, employeeId).isEmpty()){

            if(project.isPresent() && employee.isPresent()) {
                EmployeeAssignment employeeAssignment = new EmployeeAssignment(project.get(), employee.get(), null, null);

                List<EmployeeAssignment> fetchedAssignments = employeeAssignmentRepository.findByProjectId(projectId);
                if (!fetchedAssignments.isEmpty()) {
                    fetchedAssignments.forEach(assignment -> {
                        surveyRepository.save(new Survey(employee.get(), project.get(), assignment.getEmployee(), "issued"));
                        surveyRepository.save(new Survey(assignment.getEmployee(), project.get(), employee.get(), "issued"));
                    });
                }

                employeeAssignmentRepository.save(employeeAssignment);


                return surveyRepository.findByProjectId(projectId);
            }else{
                throw new ResourceNotFoundException("Employee or Project not found for employee id " + employeeId + " and " + projectId);
            }
        }else{
            throw new ResourceNotFoundException("Employee already assigned to project");
        }
    }

    @DeleteMapping("/employee/removeProject/{employeeId}/{project_id}")
    public void removeEmployeeFromProject(@PathVariable Long employeeId, Long projectId){
        employeeAssignmentRepository.deleteByEmployeeIdAndProjectId(employeeId, projectId);
        surveyRepository.deleteByEmployeeIdAndProjectId(employeeId, projectId);
        surveyRepository.deleteByReviewerIdAndProjectId(employeeId, projectId);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeRepository.deleteById(employeeId);

    }

}
