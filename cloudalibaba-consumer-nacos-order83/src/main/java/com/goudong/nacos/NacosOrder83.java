package com.goudong.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author msi
 * @Date 2021-04-07 10:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder83.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
}
