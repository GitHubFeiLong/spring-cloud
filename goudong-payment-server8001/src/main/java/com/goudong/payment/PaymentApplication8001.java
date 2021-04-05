package com.goudong.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class PaymentApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8001.class, args);
    }
}
