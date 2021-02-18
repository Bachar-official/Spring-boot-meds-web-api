package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase (DrugRepository repository) {
        return args -> {
            log.info("Preloading " +
            repository.save(new Drug("Лоратадин", "аллергия", "там", "2020-01-01")));
            log.info("Preloading " +
            repository.save(new Drug("Лоперамид", "понос", "там", "2025-05-01")));
        };
    }
}