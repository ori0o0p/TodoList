package com.dsm.todolist.external.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * http://localhost:8080/swagger-ui/index.html#/
 *
 */ 
@Configuration
class OpenApiConfiguration {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private static Info apiInfo() {
        return new Info()
                .title("TodoList API");
    }

}
