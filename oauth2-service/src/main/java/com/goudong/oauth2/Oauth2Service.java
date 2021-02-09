package com.goudong.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 类描述：
 *
 * @ClassName Oauth2Service
 * @Author msi
 * @Date 2021/2/9 19:20
 * @Version 1.0
 */
@EnableOpenApi
@SpringBootApplication
public class Oauth2Service {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Service.class, args);
    }
}
