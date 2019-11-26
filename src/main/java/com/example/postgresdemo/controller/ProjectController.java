package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.EmployeeAssignment;
import com.example.postgresdemo.model.Project;
import com.example.postgresdemo.model.Survey;
import com.example.postgresdemo.repository.ProjectRepository;
import com.example.postgresdemo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping("/project/{projectId}")
    public Project getProjectById(@PathVariable Long projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    @GetMapping("/project/{projectId}/employees")
    public Set<EmployeeAssignment> getProjectEmployees(@PathVariable Long projectId){
        return projectRepository.findByProjectId(projectId).getEmployeeAssignments();
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
    public void addEmployeeToProject(@PathVariable Long employeeId, @PathVariable Long projectId){
        //Create Employee Assignement
        //Fetch all assignments from project
        //Create two surveys for each employee
    }

    @DeleteMapping("/project/removeEmployee/{employeeId}/{projectId}")
    public void removeEmployeeFromProject(@PathVariable Long employeeId, @PathVariable Long projectId){
        //Remove Employee Assignment
        //Delete Surveys where projectId = ? and employeeId = ?
    }

    @DeleteMapping("/project/{projectId}")
    public void deleteProject(@PathVariable Long projectId){
        projectRepository.deleteById(projectId);
        //DeleteEmployee assignments
        //DeleteSurveys
    }
}
