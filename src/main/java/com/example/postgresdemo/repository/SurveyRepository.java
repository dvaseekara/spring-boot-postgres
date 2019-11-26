package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;


@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Optional<Survey> findById(Long surveyId);
    Set<Survey> findByEmployeeId(Long employeeId);
    Set<Survey> findByProjectId(Long projectId);
    void deleteByEmployeeIdAndProjectId(Long employeeId, Long projectId);
    void deleteByReviewerIdAndProjectId(Long employeeId, Long projectId);
    void deleteByReviewerId(Long employeeId);
    void deleteByEmployeeId(Long employeeId);
    void deleteByProjectId(Long projectId);
}

