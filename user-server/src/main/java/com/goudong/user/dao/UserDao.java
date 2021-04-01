package com.goudong.user.dao;

import java.util.List;

/**
 * 接口描述：
 *
 * @ClassName UserDao
 * @Author msi
 * @Date 2021-04-01 21:11
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 查询所有菜单的地址
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
