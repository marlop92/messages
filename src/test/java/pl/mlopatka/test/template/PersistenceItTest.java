package pl.mlopatka.test.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class PersistenceItTest {

    private static final String DB_DOCKER_IMG = "postgres:11.1";

    @Container
    private final static PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer<>(DB_DOCKER_IMG)
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa");

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    protected void dbContainerSetup() {
        TestPropertyValues.of(
                "spring.datasource.url=" + POSTGRESQL_CONTAINER.getJdbcUrl(),
                "spring.datasource.username=" + POSTGRESQL_CONTAINER.getUsername(),
                "spring.datasource.password=" + POSTGRESQL_CONTAINER.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
