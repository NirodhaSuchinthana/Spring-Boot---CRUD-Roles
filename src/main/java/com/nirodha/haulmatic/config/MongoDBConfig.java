package com.nirodha.haulmatic.config;
import com.nirodha.haulmatic.documents.Roles;
import com.nirodha.haulmatic.repository.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@EnableMongoRepositories(basePackageClasses = RolesRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(RolesRepository rolesRepository){
        return strings -> {
            rolesRepository.save(new Roles(1,"Company", "Jack", "Carter", "123456789", Roles.RoleType.DRIVER));
        };

    }

}
