package com.laity.consumer.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration注解：告诉spring容器，进行配置文件扫描
@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket createRestApi() {

        Predicate<RequestHandler> predicate = RequestHandlerSelectors.basePackage("com");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //对controller生成接口文档
                .apis(predicate)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("resultsApi")
                .description("将results的项目改写成前后端分离的项目,此处为改写后的接口项目,resultsApi的使用")
                .version("1.0")
                .build();
    }
}
