package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends AuditModel {

    public Employee(Long employeeId, String firstName, String lastName, String email, int roleId, int tsmId, int pmId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
        this.tsmId = tsmId;
        this.pmId = pmId;
    }

    @Id
    @GeneratedValue(generator = "employee_generator")
    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_sequence",
            initialValue = 1000
    )
    private Long employeeId;

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

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<EmployeeAssignment> employeeAssignments;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

}
