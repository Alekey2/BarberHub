package br.com.smartmenu.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI smartMenu(){
        return new OpenAPI()
                .info(
                        new Info().title("Smart Menu API")
                                .description("Projeto desenvolvido para entrega do Tech Challenge ")
                                .version("v1.0.0")
                                .license(new License().name("Version 1.0")
                                        .url("https://github.com/higotaviano-commits/tech-challenge-fase-1"))
                );
    }
}
