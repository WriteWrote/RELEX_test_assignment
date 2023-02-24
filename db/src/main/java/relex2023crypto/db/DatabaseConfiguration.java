package relex2023crypto.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {
        "relex2023crypto.db.entities"
})
@EnableJpaRepositories(basePackages = {
        "relex2023crypto.db.repositories"
})
@EnableTransactionManagement
public class DatabaseConfiguration {
}
