package com.example.postgresdemo.repositoryIntegrationtest;

import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){

    }


    @Test
    public void insertEmployee() {
        entityManager.clear();
        Employee dan = new Employee((long) 1, "test_first", "test_last", "test@test.com", 1, 2, 2);
        entityManager.persist(dan);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByFirstName("Daniel");

        //then
        assertThat(found.getLastName())
                .isEqualTo("Vaseekaran");

    }

    @Test
    public void addEmployeeToProject(){

    }

    @Test
    public void fetchEmployeeProjects(){

    }

    @Test
    public void addSecondEmployeeToProject(){
        //validate survey creation
    }

    @Test
    public void deleteEmployee(){
        //validate survey deletion
        //validate employeeAssignment deletion
    }



}
