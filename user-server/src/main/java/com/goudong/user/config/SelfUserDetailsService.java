package com.goudong.user.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Andon
 * @date 2019/3/20
 * <p>
 * 自定义用户认证
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

//    @Resource
//    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        com.nonce.restsecurity.config.SelfUserDetails userInfo = new com.nonce.restsecurity.config.SelfUserDetails();
//        userInfo.setUsername(username); //任意登录用户名
//
//        String password = userService.findPasswordByUsernameAfterValidTime(username);
//        if (ObjectUtils.isEmpty(password)) {
//            throw new UsernameNotFoundException("User name" + username + "not find!!");
//        }
//        userInfo.setPassword(password); //从数据库获取密码
//
//        Set<SimpleGrantedAuthority> authoritiesSet = new HashSet<>();
//        List<String> roles = userService.findRoleNameByUsername(username);
//        for (String roleName : roles) {
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName); //用户拥有的角色
//            authoritiesSet.add(simpleGrantedAuthority);
//        }
//        userInfo.setAuthorities(authoritiesSet);
//
//        return userInfo;
        return null;
    }
}
