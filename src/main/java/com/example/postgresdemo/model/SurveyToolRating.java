//package com.example.postgresdemo.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "survey_tool_rating")
//public class SurveyToolRating extends AuditModel {
//    @Id
//    @GeneratedValue(generator = "survey_tool_generator")
//    @SequenceGenerator(
//            name = "survey_tool_generator",
//            sequenceName = "survey_tool_sequence",
//            initialValue = 1000
//    )
//    private Long surveyToolId;
//
//    @Column(name = "employee_id")
//    private int employeeId;
//
//    @Column(name = "tool_id")
//    private String toolId;
//
//    @Column(name = "reviewer_id")
//    private int reviewerId;
//
//    @Column(name = "rating")
//    private int rating;
//
//    @Column(name = "notes")
//    private String notes;
//
//    @Column(name = "frequence")
//    private int frequency;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "survey_id", insertable = false, updatable = false)
//    //@OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Survey survey;
//
//    public Long getSurveyToolId() {
//        return surveyToolId;
//    }
//
//    public void setSurveyToolId(Long surveyToolId) {
//        this.surveyToolId = surveyToolId;
//    }
//
//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getToolId() {
//        return toolId;
//    }
//
//    public void setToolId(String toolId) {
//        this.toolId = toolId;
//    }
//
//    public int getReviewerId() {
//        return reviewerId;
//    }
//
//    public void setReviewerId(int reviewerId) {
//        this.reviewerId = reviewerId;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
//
//    public int getFrequency() {
//        return frequency;
//    }
//
//    public void setFrequency(int frequency) {
//        this.frequency = frequency;
//    }
//
//    public Survey getSurvey() {
//        return survey;
//    }
//
//    public void setSurvey(Survey survey) {
//        this.survey = survey;
//    }
//
//
//}
