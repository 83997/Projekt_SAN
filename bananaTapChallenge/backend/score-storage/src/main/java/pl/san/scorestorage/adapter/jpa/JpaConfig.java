package pl.san.scorestorage.adapter.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;

@Configuration
public class JpaConfig {
    @Bean
    IdGenerator idGenerator() {
        return new AlternativeJdkIdGenerator();
    }
}
