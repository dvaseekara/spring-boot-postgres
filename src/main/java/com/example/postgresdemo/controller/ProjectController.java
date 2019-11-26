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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeAssignmentRepository employeeAssignmentRepository;

    @GetMapping("/project/{projectId}")
    public Optional<Project> getProjectById(@PathVariable Long projectId) {
        return projectRepository.findById(projectId);
    }

    @GetMapping("/project/{projectId}/employees")
    public Set<EmployeeAssignment> getProjectEmployees(@PathVariable Long projectId){
        Optional<Project> project = projectRepository.findById(projectId);
        if(project.isPresent()){
            return project.get().getEmployeeAssignments();
        }else{
            throw new ResourceNotFoundException("Project not found for project id: " + projectId);
        }
    }

    @GetMapping("/project/{projectId}/surveys")
    public Set<Survey> getProjectSurveys(@PathVariable Long projectId){
        return surveyRepository.findByProjectId(projectId);
    }

    @PostMapping("/project")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PostMapping("/project/addEmployee/{employeeId}/{projectId}")
    public Set<Survey> addEmployeeToProject(@PathVariable Long employeeId, @PathVariable Long projectId){
        Optional<Employee> employee  = employeeRepository.findById(employeeId);
        Optional<Project> project = projectRepository.findById(projectId);

        if(employeeAssignmentRepository.findByProjectIdAndEmployeeId(projectId, employeeId).isEmpty()){
            if(project.isPresent() && employee.isPresent()) {
                EmployeeAssignment employeeAssignment = new EmployeeAssignment(project.get(), employee.get(), null, null);

                List<EmployeeAssignment> fetchedAssignments = employeeAssignmentRepository.findByProjectId(projectId);
                if (!fetchedAssignments.isEmpty()) {
                    fetchedAssignments.forEach(assignment -> {
                        surveyRepository.save(new Survey(employee.get(), project.get(), employeeAssignment.getEmployee(), "issued"));
                        surveyRepository.save(new Survey(employeeAssignment.getEmployee(), project.get(), employee.get(), "issued"));
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

    @DeleteMapping("/project/removeEmployee/{employeeId}/{projectId}")
    public void removeEmployeeFromProject(@PathVariable Long employeeId, @PathVariable Long projectId){
        employeeAssignmentRepository.deleteByEmployeeIdAndProjectId(employeeId, projectId);
        surveyRepository.deleteByEmployeeIdAndProjectId(employeeId, projectId);
        surveyRepository.deleteByReviewerIdAndProjectId(employeeId, projectId);
    }

    @DeleteMapping("/project/{projectId}")
    public void deleteProject(@PathVariable Long projectId){
        projectRepository.deleteById(projectId);
    }
}
