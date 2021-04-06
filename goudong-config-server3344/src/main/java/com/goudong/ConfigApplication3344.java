package com.goudong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author msi
 * @Date 2021-04-06 15:45
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer // 开启config
public class ConfigApplication3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class, args);
    }
}
