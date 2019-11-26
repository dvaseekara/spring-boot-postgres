package com.example.postgresdemo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "survey")
public class Survey extends AuditModel {
    public Survey(Employee employee, Project project, Employee reviewer, String status) {
        this.employee = employee;
        this.project = project;
        this.reviewer = reviewer;
        this.status = status;
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
        //fix this
    }

    public Survey() {
    }

    @Id
    @GeneratedValue(generator = "survey_generator")
    @SequenceGenerator(
            name = "survey_generator",
            sequenceName = "survey_sequence",
            initialValue = 1000
    )
    private Long id;

    //foreign key
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    //foreign key
    @ManyToOne
    @JoinColumn(name="reviewer_id")
    private Employee reviewer;

    //foreign key
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @Column(name = "status", nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date start_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "complete_date")
    private Date complete_date;

    @OneToMany(mappedBy = "survey")
    private List<SurveyToolRating> surveyToolRatings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Date complete_date) {
        this.complete_date = complete_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getReviewer() {
        return reviewer;
    }

    public void setReviewer(Employee reviewer) {
        this.reviewer = reviewer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<SurveyToolRating> getSurveyToolRatings() {
        return surveyToolRatings;
    }

    public void setSurveyToolRatings(List<SurveyToolRating> surveyToolRatings) {
        this.surveyToolRatings = surveyToolRatings;
    }
}