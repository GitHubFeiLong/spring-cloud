package com.goudong.user.service;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询用户名对应的密码
     * @param username
     * @return
     */
    String findPasswordByUsernameAfterValidTime(String username);

    /**
     * 查询用户的权限
     * @param username
     * @return
     */
    List<String> findRoleNameByUsername(String username);

    /**
     * 查询用户相关的所有菜单信息
     * @param username
     * @return
     */
    Map<String,Object> findMenuInfoByUsername(String username);
}
