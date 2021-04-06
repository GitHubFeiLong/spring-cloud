package goudong.payment.service;

import com.goudong.module.pojo.Result;
import org.springframework.stereotype.Component;

/**
 * 为指定接口写降级处理方法
 * @Author msi
 * @Date 2021-04-06 13:20
 * @Version 1.0
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Result demo1() {
        return Result.ofFail("PaymentServiceImpl");
    }

    @Override
    public Result demo2() {
        return Result.ofFail("PaymentServiceImpl");
    }
}
