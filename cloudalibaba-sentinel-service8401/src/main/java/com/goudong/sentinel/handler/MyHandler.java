package com.goudong.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.goudong.module.pojo.Result;

/**
 * 全局兜底方法
 * @Author msi
 * @Date 2021-04-07 14:59
 * @Version 1.0
 */
public class MyHandler {
    public static Result handlerException1(BlockException blockException) {
        return Result.ofFail("全局兜底----1");
    }

    public static Result handlerException2(BlockException blockException) {
        return Result.ofFail("全局兜底----2");
    }
}
