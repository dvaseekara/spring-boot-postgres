package com.example.postgresdemo.repositoryIntegrationtest;

import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.model.Project;
import com.example.postgresdemo.repository.EmployeeRepository;
import com.example.postgresdemo.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;


    @Test
    public void insertProject() {
        Project consultant360  = new Project((long) 1, "Consultant 360", "Streamlining peer feedback", 1, "ongoing", "incomplete");
        entityManager.persist(consultant360);
        entityManager.flush();

        // when
        Optional<Project> found = projectRepository.findById((long) 1);

        //then
        assertThat(found.get().getProjectName())
                .isEqualTo(consultant360.getProjectName());

    }

    @Test
    public void assignProjectToEmployee(){

    }

    @Test
    public void assignSecondProjectToEmployee(){

    }

    @Test
    public void validateProjectSurveys(){

    }

    @Test
    public void deleteProject(){

    }
}
