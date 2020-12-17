package com.ll.mango.admin.security;

import com.ll.mango.admin.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/8 0008 下午 15:55
 * 登录认证过滤器负责登录认证时检查并生产令牌保存到上下文，接口权限认证过程中，系统从上下文获取令牌校验接口访问权限
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException,ServletException
    {
        //获取token，并检查登录状态
        SecurityUtils.checkAuthentication(request);
        chain.doFilter(request,response);
    }
}
