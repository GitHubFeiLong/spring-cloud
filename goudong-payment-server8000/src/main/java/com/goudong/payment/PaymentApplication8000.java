package com.goudong.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:17
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient // 开启Eureka客户端
@EnableDiscoveryClient // 开启服务发现
public class PaymentApplication8000 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8000.class, args);
    }
}
