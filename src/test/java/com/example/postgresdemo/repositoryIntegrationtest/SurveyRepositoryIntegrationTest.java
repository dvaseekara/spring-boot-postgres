package com.example.postgresdemo.repositoryIntegrationtest;

import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.repository.EmployeeRepository;
import com.example.postgresdemo.repository.SurveyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SurveyRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    public void employeeAssignment() {


    }

    @Test
    public void addToolRatingToSurvey(){

    }

    @Test
    public void updateToolRating(){

    }

    @Test
    public void deleteToolRating(){

    }

    @Test
    public void addSecondToolRating(){

    }

    @Test
    public void deleteSurvey(){

    }



}
