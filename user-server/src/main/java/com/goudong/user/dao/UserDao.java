package com.goudong.user.dao;

import com.goudong.user.entity.AuthorityUserDO;

import java.util.List;
import java.util.Map;

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
     * 查询用户名的昵称和备注
     * @param username
     * @return
     */
    Map<String, Object> findUserIdAndNickNameAndRemarkByUsername(String username);

    /**
     * 查询用户的能访问的路径
     * @param username
     * @return
     */
    List<String> findUrlsByUsername(String username);

    /**
     * 查询最高权限能访问的路径
     * @return
     */
    List<Map<String, Object>> findRootMenuInfo();

    /**
     * 查询子路径
     * @param id
     * @return
     */
    List<Map<String, Object>> findMenuInfoByParentId(int id);

    /**
     * 查询用户能访问的所有菜单
     * @param username
     * @return
     */
    List<Map<String, Object>> findRootMenuInfoByUsername(String username);

    List<Integer> findRootMenuIdOfPartialPermission(String username);

    Map<String, Object> findMenuInfoByMenuId(Integer menuId);

    /**
     *
     * @param username
     * @param menuId
     * @return
     */
    List<Map<String, Object>> findChildrenMenuInfoByUsernameAndParentId(String username, Integer menuId);

    /**
     * 查询用户的角色信息
     * @param username
     * @return
     */
    AuthorityUserDO findUserRoleInfoByUsername(String username);
}
