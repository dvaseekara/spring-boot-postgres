package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends AuditModel {

    public Employee(Long employeeId, String firstName, String lastName, String email, int roleId, int tsmId, int pmId) {
        this.id = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
        this.tsmId = tsmId;
        this.pmId = pmId;
    }

    public Employee(){}

    @Id
    @GeneratedValue(generator = "employee_generator")
    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "tsm_id")
    private int tsmId;

    @Column(name = "pm_id")
    private int pmId;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Set<EmployeeAssignment> employeeAssignments;

    @OneToMany(mappedBy= "employee")
    @JsonIgnore
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Set<Survey> surveys;

    @OneToMany(mappedBy= "reviewer")
    @JsonIgnore
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Set<Survey> peerSurveys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getTsmId() {
        return tsmId;
    }

    public void setTsmId(int tsmId) {
        this.tsmId = tsmId;
    }

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    public Set<EmployeeAssignment> getEmployeeAssignments() {
        return employeeAssignments;
    }

    public void setEmployeeAssignments(Set<EmployeeAssignment> employeeAssignments) {
        this.employeeAssignments = employeeAssignments;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }

    public Set<Survey> getPeerSurveys() {
        return peerSurveys;
    }

    public void setPeerSurveys(Set<Survey> peerSurveys) {
        this.peerSurveys = peerSurveys;
    }
}
