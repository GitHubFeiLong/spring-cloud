package com.goudong.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@EnableEurekaClient // 开启Eureka客户端
/// @RibbonClient(name = "GOUDONG-PAYMENT-SERVER", configuration = MySelfRule.class) // 配置该服务的负载均衡规则
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced // 负载均衡 /// 自定义时去掉注解
    public RestTemplate gerRestTemplate () {
        return new RestTemplate();
    }
}
