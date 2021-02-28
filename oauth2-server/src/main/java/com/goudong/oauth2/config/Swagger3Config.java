package com.goudong.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * 类描述：
 * 配置 swagger<br>
 * 访问 ip:port/swagger-ui/index.html#/
 * ip:port/swagger-ui
 *
 * @ClassName Swagger3Config
 * @Author msi
 * @Date 2020/10/17 10:00
 * @Version 1.0
 */
@Configuration
public class Swagger3Config {

    @Bean
    public Docket qqDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("QQ模块")
                .description("qq相关的认证")
                .version("1.0")
                .contact(new Contact("Evan", "http://www.baidu.com", "123456@qq.com"))
                .build();

        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .apiInfo(apiInfo)
                .select()
                // 全部扫描
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.goudong.oauth2.qq"))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(new LinkedHashSet<>(Arrays.asList("http", "https")))
                // 在子模块中使用groupName 可以使用右上的下拉功能
                .groupName("QQ")
                ;

    }

    @Bean
    public Docket weChatDocket() {
        ApiInfo apiInfo =  new ApiInfoBuilder()
                .title("WeChat")
                .description("微信OAuth")
                .version("1.0")
                .contact(new Contact("Evan", "http://www.baidu.com", "123456@qq.com"))
                .build();
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.goudong.oauth2.wechat"))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(new LinkedHashSet<>(Arrays.asList("http", "https")))
                .groupName("WeChat")
                ;

    }
}