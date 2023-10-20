package com.taskcontroller.TaskController.docs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Task Controller")
                        .description("Api Spring Boot projeto TCD")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Gabriel Camargos")
                                .url("https://github.com/Gabrielcamargos28/Task_Controller")
                                .email("gabrielcamargosdev@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/Gabrielcamargos28/Task_Controller"))
                .components(new Components()
                        .addSecuritySchemes("BearerToken",new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Autorization")
                        ));
    }
}