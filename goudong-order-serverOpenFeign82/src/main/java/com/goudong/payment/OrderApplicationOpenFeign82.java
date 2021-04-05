package com.goudong.payment;

import com.goudong.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients // 开启Feign
public class OrderApplicationOpenFeign82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationOpenFeign82.class, args);
    }
}
