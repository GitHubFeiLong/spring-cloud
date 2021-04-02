package com.goudong.user.handler;

import com.alibaba.fastjson.JSON;
import com.goudong.module.pojo.Result;
import com.goudong.user.entity.AuthorityUserDO;
import com.goudong.user.service.UserService;
import com.goudong.user.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 * @Author msi
 * @Date 2021-04-02 13:33
 * @Version 1.0
 */
@Slf4j
@Component
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setCharacterEncoding("UTF-8");

        //表单输入的用户名
        String username = (String) authentication.getPrincipal();
//        Map<String, Object> userInfo = userService.findMenuInfoByUsername(username);
        AuthorityUserDO userRoleInfoByUsername = userService.findUserRoleInfoByUsername(username);

        Result result = Result.ofSuccess(userRoleInfoByUsername);

        // 生产token字符串
        String token = JwtTokenUtil.generateToken(userRoleInfoByUsername);

        AuthorityUserDO authorityUserDO = JwtTokenUtil.resolveToken(token);

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
        httpServletResponse.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
    }
}
