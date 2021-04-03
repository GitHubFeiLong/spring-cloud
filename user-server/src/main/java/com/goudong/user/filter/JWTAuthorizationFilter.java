package com.goudong.user.filter;

import com.goudong.user.entity.AuthorityRoleDO;
import com.goudong.user.entity.AuthorityUserDO;
import com.goudong.user.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类描述：
 * 过滤器，用户请求时，获取请求头的token，并将其解析后设置到Authentication认证信息中去
 * 使用JWT token进行验证用户
 * @ClassName JWTAuthorizationFilter
 * @Description TODO
 * @Author msi
 * @Date 2021-04-03 18:14
 * @Version 1.0
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }

    /**
     * 这里从token中获取用户信息，并将用户名和角色信息，创建一个认证对象 Authentication
     * @param tokenHeader token
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        // 去掉前面的 "Bearer " 字符串
        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        // 解析token为对象
        AuthorityUserDO authorityUserDO = JwtTokenUtil.resolveToken(token);

        // 放置权限
        Set<SimpleGrantedAuthority> authoritiesSet = new HashSet<>();
        List<AuthorityRoleDO> authorityRoleDOS = authorityUserDO.getAuthorityRoleDOS();
        if (authorityRoleDOS != null && !authorityRoleDOS.isEmpty()) {
            authorityRoleDOS.parallelStream().forEach(f1->{
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(f1.getRoleName());
                authoritiesSet.add(simpleGrantedAuthority);
            });

        }
        String username = authorityUserDO.getUsername();
        if (username != null){
            // 用户名 密码 角色
            return new UsernamePasswordAuthenticationToken(username, null, authoritiesSet);
        }
        return null;
    }
}
