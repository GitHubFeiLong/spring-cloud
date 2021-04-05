package com.goudong.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:17
 * @Version 1.0 
 */
@SpringBootApplication
@EnableDiscoveryClient // 服务发现
public class OrderApplicationConsul81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationConsul81.class, args);
    }

    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate gerRestTemplate () {
        return new RestTemplate();
    }
}
