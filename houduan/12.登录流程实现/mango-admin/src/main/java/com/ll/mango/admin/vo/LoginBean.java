package com.ll.mango.admin.vo;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/12 0012 下午 15:47
 * 封装登录对象，用户名，密码，验证码
 */
public class LoginBean {
    private String name;
    private String password;
    private String captcha;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
