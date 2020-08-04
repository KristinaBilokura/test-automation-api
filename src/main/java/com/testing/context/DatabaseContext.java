package com.testing.context;

import com.testing.database.service.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class DatabaseContext {
    @Bean
    public Database database() { return new Database(); }
}
