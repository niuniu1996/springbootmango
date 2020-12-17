package com.ll.mango.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ll.mango.admin.po.SysUser;
import com.ll.mango.admin.security.JwtAuthenticationToken;
import com.ll.mango.admin.service.SysUserService;
import com.ll.mango.admin.util.PasswordUtils;
import com.ll.mango.admin.util.SecurityUtils;
import com.ll.mango.admin.vo.LoginBean;
import com.ll.mango.common.utils.IOUtils;
import com.ll.mango.core.http.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * 登录控制器
 */
@RestController
public class SysLoginController {
    private static Logger logger= Logger.getLogger(SysLoginController.class);
    @Autowired
    private Producer producer;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     * 先验证验证码，之后是用户信息匹配
     * @param loginBean
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request)throws IOException{
        String name=loginBean.getName();
        String password=loginBean.getPassword();
        String captcha=loginBean.getCaptcha();
        //从session中获取之前保存的验证码，跟前台传来的验证码进行匹配
        Object kaptcha=request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha==null){
            logger.error("验证码已经失效了");
            return HttpResult.error("验证码已经失效了");
        }
        if(!captcha.equals(kaptcha)){
            logger.error("验证码不正确");
            return HttpResult.error("验证码不正确");
        }
        SysUser user=sysUserService.findByWholeName(name);
        if(user==null){
            logger.error("账户不存在");
            return HttpResult.error("账户不存在");
        }
        if(!PasswordUtils.matches(user.getSalt(),password,user.getPassword())){
            logger.error("密码不正确");
            return HttpResult.error("密码不正确");
        }
        //账户锁定
        if(user.getStatus()==0){
            logger.error("账户被锁定了");
            return HttpResult.error("账户被锁定了");
        }
        //系统登录认证
        JwtAuthenticationToken token=SecurityUtils.login(request,name,password,authenticationManager);
        return HttpResult.ok(token);
    }

}
