package com.goudong.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 类描述：
 * 用户模块启动类
 * @ClassName UserService
 * @Author msi
 * @Date 2021/2/9 16:56
 * @Version 1.0
 */
@EnableOpenApi
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.goudong.dao"}) // 可以不在mapper层添加注解
public class UserService {
    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
    }
}
