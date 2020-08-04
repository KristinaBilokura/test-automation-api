package com.testing.context;

import org.springframework.context.annotation.Bean;
import com.testing.fakes.service.CustomClientService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class CoreContext {

    @Bean
    public CustomClientService customClientService(){return new CustomClientService();}
}
