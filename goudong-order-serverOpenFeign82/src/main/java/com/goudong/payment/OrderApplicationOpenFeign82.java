package com.goudong.payment;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:17
 * @Version 1.0 
 */
@SpringBootApplication
@EnableEurekaClient // 开启Eureka客户端
@EnableFeignClients // 开启Feign
public class OrderApplicationOpenFeign82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationOpenFeign82.class, args);
    }

    /**
     * 配置Feign 日志
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLeavel(){
        return Logger.Level.FULL;
    }
}
