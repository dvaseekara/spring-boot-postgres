package com.example.postgresdemo;

import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.repository.EmployeeRepository;
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


    @Test
    public void whenFindByName_thenReturnEmployee() {
        Employee dan = new Employee();

        //Entity Setup
        dan.setEmail("dvaseekara3@gmail.com");
        dan.setFirstName("Daniel");
        dan.setLastName("Vaseekaran");
        dan.setPmId(1);
        dan.setRoleId(2);
        dan.setTsmId(1);

        entityManager.persist(dan);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByFirstName("Daniel");

        //then
        assertThat(found.getLastName())
                .isEqualTo(dan.getLastName());

    }

}
