package com.goudong.nacos.service;

import com.goudong.module.pojo.Result;
import org.springframework.stereotype.Component;

/**
 * @Author msi
 * @Date 2021-04-07 16:01
 * @Version 1.0
 */
@Component
public class PaymentServiceImpl implements PaymentService{
    @Override
    public Result demo1(Integer id) {

        return Result.ofFail("服务降级返回 PaymentServiceImpl id:" + id);
    }
}
