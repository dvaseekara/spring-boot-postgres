package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project extends AuditModel{

    public Project(Long projectId, String projectName, String summary, int tsmId, String projectStatus, String surveyStatus) {
        this.id = projectId;
        this.projectName = projectName;
        this.summary = summary;
        this.tsmId = tsmId;
        this.projectStatus = projectStatus;
        this.surveyStatus = surveyStatus;
    }

    public Project() {
    }

    @Id
    @GeneratedValue(generator = "project_generator")
    @SequenceGenerator(
            name = "project_generator",
            sequenceName = "project_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "summary")
    private String summary;

    @Column(name = "tsm_id")
    private int tsmId;
    
    @Column(name = "project_status")
    private String projectStatus;

    @Column(name = "survey_status")
    private String surveyStatus;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<EmployeeAssignment> employeeAssignments;

    @OneToMany(mappedBy= "project")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Survey> surveys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getTsmId() {
        return tsmId;
    }

    public void setTsmId(int tsmId) {
        this.tsmId = tsmId;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(String surveyStatus) {
        this.surveyStatus = surveyStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<EmployeeAssignment> getEmployeeAssignments() {
        return employeeAssignments;
    }

    public void setEmployeeAssignments(Set<EmployeeAssignment> employeeAssignments) {
        this.employeeAssignments = employeeAssignments;
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }
}
