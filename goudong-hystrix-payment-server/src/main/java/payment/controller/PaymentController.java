package payment.controller;

import com.goudong.module.pojo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/demo1")
    public Result demo1() {

        return Result.ofSuccess(serverPort+" 线程池：" + Thread.currentThread().getName() + "demo1");
    }

    /**
     * @HystrixCommand 服务报错了，超时了，都会调用 fallbackMethod 方法
     * @return
     */
    @GetMapping("/demo2")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
//        commandProperties = {
//                // 超时3000报错,走兜底方法
//                @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//        }
//    )
    public Result demo2() {
        int timenum = 2;
        try {
            TimeUnit.SECONDS.sleep(timenum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ofSuccess(serverPort + " 线程池：" + Thread.currentThread().getName() + "demo1 耗时 "+timenum+"秒钟");
    }

    /**
     * hystrix 服务兜底，报错时执行此方法
     * @return
     */
    public Result paymentInfo_TimeoutHandler () {
        return Result.ofFail("我是8001" + Thread.currentThread().getName() + " 服务器繁忙");
    }

    /*服务熔断*/

    @GetMapping("/demo3/{id}")
    @HystrixCommand(
            fallbackMethod = "RDMethod",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到value跳闸
            }

    )
    public Result demo3 (@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id " + id + "不能为服负数");
        }
        return Result.ofSuccess("8001:" + Thread.currentThread().getName() + "调用成功" + UUID.randomUUID());
    }

    /**
     * 熔断
     * @return
     */
    public Result RDMethod (Integer id) {
        return Result.ofFail("熔断回调方法：" + id);
    }
}
