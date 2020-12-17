package com.ll.mango.admin.config;

import com.ll.mango.admin.security.JwtAuthenticationFilter;
import com.ll.mango.admin.security.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/8 0008 下午 14:20
 * 主要进行一些安全的相关配置。比如权限URL匹配策略，认证过滤器配置，定制身份验证组件，开启权限认证注解等
 */
@Configuration
//开启Spring Security
@EnableWebSecurity
//开启权限注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
        //使用自定义身份验证组件
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
    }
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        //禁用csrf,由于使用JWT，所以不需要
        httpSecurity.cors().and().csrf().disable().authorizeRequests()
                //跨域预检请求
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                //web jars
                .antMatchers("/webjars/**").permitAll()
                //查看SQL监控(druid)
                .antMatchers("/druid/**").permitAll()
                //首页和登录页面
                .antMatchers("/").permitAll().antMatchers("/login").permitAll()
                //swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                //验证码
                .antMatchers("/captcha.jpg").permitAll()
                //服务监控
                .antMatchers("/actuator/**").permitAll()
                //其他所有的请求需要身份认证操作
                .anyRequest().authenticated();
        httpSecurity.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        //token验证过滤器
        httpSecurity.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()),UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
