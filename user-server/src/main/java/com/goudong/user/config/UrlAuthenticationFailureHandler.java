package com.goudong.user.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Andon
 * @date 2019/3/20
 * <p>
 * 自定义登录失败处理器：返回状态码402
 */
@SuppressWarnings("Duplicates")
@Component
public class UrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

//        response.setSuccess(false);
//        response.setCode("402");
//        response.setMessage(e.getMessage());
//        response.setData(null);
//
//        httpServletResponse.setStatus(402);
//        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setContentType("text/html;charset=UTF-8");
//        httpServletResponse.getWriter().write(GsonUtil.GSON.toJson(response));
    }
}
