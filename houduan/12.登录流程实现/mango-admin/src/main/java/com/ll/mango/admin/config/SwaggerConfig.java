package com.ll.mango.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
/**
 * Swager配置类
 * Swagger是一个规范和完整的框架，用于生成、描述、调用和可视化RESTful风格的Web服务。
 * 简单来说，Swagger是一个功能强大的接口管理工具，并且提供了多种编程语言的前后端分离解决方案。
 * Swagger可以整合到代码中，在开发时通过注解，编写注释，自动生成API文档；
 * 方便前后端分离开发
 */
public class SwaggerConfig {
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//    }
@Bean
public Docket createRestApi(){
//    // 添加请求参数，我们这里把token作为请求头部参数传入后端
//    ParameterBuilder parameterBuilder = new ParameterBuilder();
//    List<Parameter> parameters = new ArrayList<Parameter>();
//    parameterBuilder.name("token").description("令牌")
//            .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//    parameters.add(parameterBuilder.build());
//    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//            .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
//            .build().globalOperationParameters(parameters);
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
       		.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
}
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().build();
    }

}
