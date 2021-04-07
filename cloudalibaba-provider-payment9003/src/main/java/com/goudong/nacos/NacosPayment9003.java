package com.goudong.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author msi
 * @Date 2021-04-07 10:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9003.class, args);
    }
}
