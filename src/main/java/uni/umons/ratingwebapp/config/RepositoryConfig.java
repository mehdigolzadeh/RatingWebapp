package uni.umons.ratingwebapp.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"uni.umons.ratingwebapp.domain"})
@EnableJpaRepositories(basePackages = {"uni.umons.ratingwebapp.repository"})
@EnableTransactionManagement
public class RepositoryConfig {

}
