package com.kevin.springcoreweb.config;

import com.kevin.springcoreweb.common.Coach;
import com.kevin.springcoreweb.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // Custom Bean id with "aquatic" to replace the default id "swimCoach"
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
