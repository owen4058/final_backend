package com.api.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String API_NAME = "API 명세";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "API 명세서입니다.";
    
	@Bean // 필수항목
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()                   // return ApiSelectoorBuilder(화면 관리)
	                .apis(RequestHandlerSelectors.basePackage("com")) // Swagger를 적용할 패키지
	                .paths(PathSelectors.any()) // url path 지정(예를들면 PathSelectors.ant("/home/**")인 경우 /home/ path를 가진 url만 공개하겠다는 의미. any인 경우 전체 url
	                .build();                   // selector build
	    }
	
	//**apiInfo()** 메서드에서는 API 문서의 제목, 버전, 설명 등을 설정한 후 **ApiInfo** 객체를 반환함. 이 설정은 Swagger UI를 통해 API 문서를 생성하고 표시하는 데 사용됨
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
	}
