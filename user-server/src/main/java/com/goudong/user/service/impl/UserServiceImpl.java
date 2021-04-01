package com.goudong.user.service.impl;

import com.goudong.user.dao.UserDao;
import com.goudong.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类描述：
 *
 * @ClassName UserServiceImpl
 * @Author msi
 * @Date 2021-04-01 20:58
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    /**
     * 查询所有菜单列表
     *
     * @return
     */
    @Override
    public List<String> findAllMenuUrl() {
        return userDao.findAllMenuUrl();
    }

    /**
     * 查询需要什么角色才能访问路径
     *
     * @param url
     * @return
     */
    @Override
    public List<String> findRoleNameByMenuUrl(String url) {
        return userDao.findRoleNameByMenuUrl(url);
    }
}
