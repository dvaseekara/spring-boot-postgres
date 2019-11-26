package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.EmployeeAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeAssignmentRepository extends JpaRepository<EmployeeAssignment, Long> {
    List<EmployeeAssignment> findByProjectId(Long projectId);
    void deleteByEmployeeId(Long employeeId);
    void deleteByEmployeeIdAndProjectId(Long employeeId, Long projectId);

    List<EmployeeAssignment> findByProjectIdAndEmployeeId(Long projectId, Long employeeId);

}

