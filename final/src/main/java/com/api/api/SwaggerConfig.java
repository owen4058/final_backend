package com.api.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String API_NAME = "API ��";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "API �����Դϴ�.";
    
	@Bean // �ʼ��׸�
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()                   // return ApiSelectoorBuilder(ȭ�� ����)
	                .apis(RequestHandlerSelectors.basePackage("com")) // Swagger�� ������ ��Ű��
	                .paths(PathSelectors.any()) // url path ����(������� PathSelectors.ant("/home/**")�� ��� /home/ path�� ���� url�� �����ϰڴٴ� �ǹ�. any�� ��� ��ü url
	                .build();                   // selector build
	    }
	
	//**apiInfo()** �޼��忡���� API ������ ����, ����, ���� ���� ������ �� **ApiInfo** ��ü�� ��ȯ��. �� ������ Swagger UI�� ���� API ������ �����ϰ� ǥ���ϴ� �� ����
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
	}
