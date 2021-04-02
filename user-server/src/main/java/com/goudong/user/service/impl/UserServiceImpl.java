package com.goudong.user.service.impl;

import com.goudong.user.dao.UserDao;
import com.goudong.user.entity.AuthorityUserDO;
import com.goudong.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询用户名对应的密码
     * @param username
     * @return
     */
    @Override
    public String findPasswordByUsernameAfterValidTime(String username) {
        return userDao.findPasswordByUsernameAfterValidTime(username);
    }

    /**
     * 查询用户的权限
     *
     * @param username
     * @return
     */
    @Override
    public List<String> findRoleNameByUsername(String username) {
        return userDao.findRoleNameByUsername(username);
    }

    /**
     * 查询用户相关的所有菜单信息
     *
     * @param username
     * @return
     */
    @Override
    public Map<String, Object> findMenuInfoByUsername(String username) {
        // todo 查询用户相关的权限和菜单信息

        Map<String, Object> userIdAndNickNameByUsername = userDao.findUserIdAndNickNameAndRemarkByUsername(username);
        int userId = (int) userIdAndNickNameByUsername.get("id");
        String nickname = (String) userIdAndNickNameByUsername.get("nickname");
        String remark = (String) userIdAndNickNameByUsername.get("remark");
        Map<String, Object> userInfo = new HashMap<>();
        List<Map<String, Object>> menuInfoList = new ArrayList<>();
        // 判断是否最高权限
        List<String> rootUrlByUsername = userDao.findUrlsByUsername(username);
        boolean isHighestAuthority = rootUrlByUsername.contains("/**");
        if (isHighestAuthority) {
            List<Map<String, Object>> rootMenuInfoList = userDao.findRootMenuInfo();
            rootMenuInfoList.forEach(rootMenuInfo -> {
                int id = (int) rootMenuInfo.get("id");
                List<Map<String, Object>> children = userDao.findMenuInfoByParentId(id);
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("url", rootMenuInfo.get("url"));
                map.put("menuName", rootMenuInfo.get("menuName"));
                map.put("parentId", rootMenuInfo.get("parentId"));
                map.put("remark", rootMenuInfo.get("remark"));
                map.put("urlPre", rootMenuInfo.get("urlPre"));
                map.put("children", children);
                menuInfoList.add(map);
            });
        } else {
            List<Map<String, Object>> rootMenuInfoByUsername = userDao.findRootMenuInfoByUsername(username);
            if (!ObjectUtils.isEmpty(rootMenuInfoByUsername)) {
                rootMenuInfoByUsername.forEach(rootMenuInfo -> {
                    int id = (int) rootMenuInfo.get("id");
                    List<Map<String, Object>> children = userDao.findMenuInfoByParentId(id);
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", id);
                    map.put("url", rootMenuInfo.get("url"));
                    map.put("menuName", rootMenuInfo.get("menuName"));
                    map.put("parentId", rootMenuInfo.get("parentId"));
                    map.put("remark", rootMenuInfo.get("remark"));
                    map.put("urlPre", rootMenuInfo.get("urlPre"));
                    map.put("children", children);
                    menuInfoList.add(map);
                });
            }
            List<Integer> rootMenuIdOfPartialPermission = userDao.findRootMenuIdOfPartialPermission(username);
            if (!ObjectUtils.isEmpty(rootMenuIdOfPartialPermission)) {
                rootMenuIdOfPartialPermission.forEach(menuId -> {
                    Map<String, Object> rootMenuInfo = userDao.findMenuInfoByMenuId(menuId);
                    List<Map<String, Object>> children = userDao.findChildrenMenuInfoByUsernameAndParentId(username, menuId);
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", menuId);
                    map.put("url", rootMenuInfo.get("url"));
                    map.put("menuName", rootMenuInfo.get("menuName"));
                    map.put("parentId", rootMenuInfo.get("parentId"));
                    map.put("remark", rootMenuInfo.get("remark"));
                    map.put("urlPre", rootMenuInfo.get("urlPre"));
                    map.put("children", children);
                    menuInfoList.add(map);
                });
            }
        }
        userInfo.put("nickname", nickname);
        userInfo.put("userId", userId);
        userInfo.put("username", username);
        userInfo.put("remark", remark);
        userInfo.put("menuList", menuInfoList);
//        if (!ObjectUtils.isEmpty(menuInfoList)) {
//            response.setTotal(menuInfoList.size());
//        }
        return userInfo;
    }

    /**
     * 用户名查询用户的角色
     * @param username
     * @return
     */
    public AuthorityUserDO findUserRoleInfoByUsername (String username) {
        return userDao.findUserRoleInfoByUsername(username);
    }

}
