package com.example.everis;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Reference")
                .version("1.0.0")
                .build();
    }

}