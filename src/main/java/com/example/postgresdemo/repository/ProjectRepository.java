package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    void deleteById(Long projectId);
}
