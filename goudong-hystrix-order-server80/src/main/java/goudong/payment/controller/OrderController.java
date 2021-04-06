package goudong.payment.controller;

import com.goudong.module.pojo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import goudong.payment.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述：
 *
 * @Author msi
 * @Date 2021-04-05 15:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/order")
///@DefaultProperties(defaultFallback = "globalFallback") // 配置默认的hystrix兜底方法
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/demo1")
    public Result demo1 () {
        return paymentService.demo1();
    }


    /**
     * @HystrixCommand 服务报错了，超时了，都会调用 fallbackMethod 方法
     * @return
     */
    @GetMapping("/demo2")
//    @HystrixCommand(
//            fallbackMethod = "paymentInfo_TimeoutHandler",
//            commandProperties = {
//                    // 超时3000报错,走兜底方法
//                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "50000")
//            }
//    )
    @HystrixCommand // 单独的使用该注解，如果出现异常使用类上面的全局默认的兜底方法
    public Result demo2() {
        return paymentService.demo2();
    }

    /**
     * hystrix 服务兜底，报错时执行此方法
     * @return
     */
    public Result paymentInfo_TimeoutHandler () {
        return Result.ofFail("我是80" + Thread.currentThread().getName() + " 服务器繁忙");
    }


    /**
     * 全局兜底方法
     * @return
     */
    public Result globalFallback () {
        return Result.ofFail("全局hystrix兜底方法");
    }


}
