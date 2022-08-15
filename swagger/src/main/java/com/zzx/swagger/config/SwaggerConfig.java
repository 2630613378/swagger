package com.zzx.swagger.config;

import io.swagger.annotations.Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.function.Predicate;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){
        Profiles of = Profiles.of("test", "dev");
        boolean flat = environment.acceptsProfiles(of);
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("zzx")
                .enable(flat)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzx.swagger.controller"))
                .paths(PathSelectors.ant("/swagger/**"))
                .build();
    }

    @Bean
    public Docket docket01(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("zzx01")
                .enable(true);
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("zzx","www.zzx.com","263013378@qq.com");
        return new ApiInfo("swagger学习"
                , "学习文档"
                , "1.0"
                , "urn:tos"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }
}
