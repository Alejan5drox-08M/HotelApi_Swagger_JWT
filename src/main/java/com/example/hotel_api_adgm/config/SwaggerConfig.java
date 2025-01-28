package com.example.hotel_api_adgm.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("HotelAPI")
                        .description("API REST de hoteles")
                        .contact(new Contact()
                                .name("Alejandro")
                                .email("alejandro.gremig@educa.jcyl.es")
                                .url("https://github.com/Alejan5drox-08M/HotelApi_Swagger_JWT.git"))
                        .version("1.0"));
    }

}
