package com.example.postgresdemo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_assignment")
public class EmployeeAssignment extends AuditModel {
    public EmployeeAssignment(Project project, Employee employee, Date startDate, Date endDate) {
        this.project = project;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
    }

    public EmployeeAssignment(){}

    @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   @JoinColumn(name="project_id")
   private Project project;

   @ManyToOne
   @JoinColumn(name="employee_id")
   private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = true)
    @LastModifiedDate
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
