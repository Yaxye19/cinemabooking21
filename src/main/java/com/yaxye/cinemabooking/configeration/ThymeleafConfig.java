package com.yaxye.cinemabooking.configeration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class ThymeleafConfig {

	@Bean
	@Lazy
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
  }
}

