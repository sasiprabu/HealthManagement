package com.vitalsigns.module.api.vitalsignsmoduleapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/vitalsigns.*"))
                .build();
    }
}
