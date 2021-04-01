package com.goudong.user.service;

import java.util.List;

/**
 * 接口描述：
 *
 * @ClassName UserService
 * @Description TODO
 * @Author msi
 * @Date 2021-04-01 20:58
 * @Version 1.0
 */
public interface UserService {

    /**
     * 查询所有菜单列表
     * @return
     */
    List<String> findAllMenuUrl();

    /**
     * 查询需要什么角色才能访问路径
     * @param url
     * @return
     */
    List<String> findRoleNameByMenuUrl(String url);
}
