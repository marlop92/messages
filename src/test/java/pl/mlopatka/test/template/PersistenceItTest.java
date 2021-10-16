package pl.mlopatka.test.template;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class PersistenceItTest {

    private static final String DB_DOCKER_IMG = "postgres:11.1";

    @Container
    private final static PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer<>(DB_DOCKER_IMG)
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",
                () -> String.format("jdbc:postgresql://localhost:%d/integration-tests-db",
                        POSTGRESQL_CONTAINER.getFirstMappedPort()));
        registry.add("spring.datasource.username", () -> "sa");
        registry.add("spring.datasource.password", () -> "sa");
    }

}
