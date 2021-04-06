package goudong.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:17
 * @Version 1.0 
 */
@SpringBootApplication
@EnableEurekaClient // 开启Eureka客户端
@EnableFeignClients // 开启feign
@EnableHystrix //开启hystrix
public class OrderApplicationHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationHystrix80.class, args);
    }
}
