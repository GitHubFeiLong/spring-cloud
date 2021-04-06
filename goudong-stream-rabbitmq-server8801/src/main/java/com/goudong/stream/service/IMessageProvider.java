package com.goudong.stream.service;

import org.springframework.stereotype.Service;

/**
 * 接口描述：
 *
 * @Author msi
 * @Date 2021-04-06 21:22
 * @Version 1.0
 */
@Service
public interface IMessageProvider {
    String send();
}
