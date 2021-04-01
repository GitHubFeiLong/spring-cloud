package com.goudong.user.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Andon
 * @date 2019/3/20
 * <p>
 * 自定义登录成功处理器：返回状态码200
 */
@Component
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

//    @Resource
//    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

//        httpServletResponse.setCharacterEncoding("UTF-8");
//        com.nonce.restsecurity.config.UrlResponse response = new com.nonce.restsecurity.config.UrlResponse();
//        response.setSuccess(true);
//        response.setCode("200");
//        response.setMessage("Login Success!");
//
//        String username = (String) authentication.getPrincipal(); //表单输入的用户名
//        Map<String, Object> userInfo = userService.findMenuInfoByUsername(username, response);
//
//        response.setData(userInfo);
//
//        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setContentType("text/html;charset=UTF-8");
//        httpServletResponse.getWriter().write(GsonUtil.GSON.toJson(response));
    }
}
