package com.goudong.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-04 14:10
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer // 激活EurekaServer
public class EurekaApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7002.class, args);
    }
}
