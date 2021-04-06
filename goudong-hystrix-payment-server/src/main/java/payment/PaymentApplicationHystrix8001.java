package payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
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
@EnableCircuitBreaker //开启回路
public class PaymentApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationHystrix8001.class, args);
    }

    /**
     * 此配置是为了服务监控而复制（hystrix-dashboard），与服务容错本身无关
     * spring cloud升级后的坑，
     * ServletRegistrationBean因为spring boot的默认路径不是“/hystrix.stream”
     * 只要在自己的项目里配置上下main的servlet就可以了
     */
//    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
