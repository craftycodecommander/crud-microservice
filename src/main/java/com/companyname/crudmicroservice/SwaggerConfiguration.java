package com.companyname.crudmicroservice;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Value("${swagger-info.contact.name}")
	String contactName;
	@Value("${swagger-info.contact.email}")
	String contactEmail;
	@Value("${swagger-info.contact.url}")
	String contactUrl;
	@Value("${swagger-info.api.title}")
	String title;
	@Value("${swagger-info.api.description}")
	String description;
	@Value("${info.version}")
	String version;
	@Value("${swagger-info.api.license}")
	String license;
	@Value("${swagger-info.api.licenseUrl}")
	String licenseUrl;
	@Value("${swagger-info.api.terms-of-service-url}")
	String termsOfServiceUrl;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(selectors())
                .paths(PathSelectors.any()) 
                .build()
                .apiInfo(metaData());
    }

    private Predicate<RequestHandler> selectors() {
        return RequestHandlerSelectors.basePackage("com.companyname");
    }
    
    private ApiInfo metaData() {
    	Contact contact = new Contact(contactName, contactUrl, contactEmail);
    	return new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, new ArrayList<>());
    }
}