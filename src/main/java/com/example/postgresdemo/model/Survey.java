package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import java.util.Set;



@Entity
@Table(name = "survey")
public class Survey extends AuditModel {
    @Id
    @GeneratedValue(generator = "survey_generator")
    @SequenceGenerator(
            name = "survey_generator",
            sequenceName = "survey_sequence",
            initialValue = 1000
    )
    private Long surveyId;

    //foreign key
    @Column(name = "employee_id", nullable = false, updatable = false)
    @JoinColumn()
    private Long employeeId;

    //foreign key
    @Column(name = "reviewer_id", nullable = false, updatable = false)
    private Long reviewerId;

    //foreign key
    @Column(name = "project_id", insertable = false, updatable = false)
    private Long projectId;

    @Column(name = "status", nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date start_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "complete_date", nullable = false, updatable = false)
    private Date complete_date;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

}