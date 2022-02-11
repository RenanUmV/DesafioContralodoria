package com.challenge.mv.controllership.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_TITLE = "Converter APT";
    private static final String API_VERSION_1 = "API v1";
    private static final String API_DESCRIPTION = "\"REST API for Convert Patterns Microservice\"";

    @Bean
    public Docket apiV1() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metaData("1.0"))
                .useDefaultResponseMessages(false)
                .groupName(API_VERSION_1)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/v1.*"))
                .build();
    }



    private ApiInfo metaData(final String version) {

        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(version)
                .build();
    }
}
