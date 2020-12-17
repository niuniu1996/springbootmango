package com.ll.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/10 0010 下午 13:42
 * 权限封装
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
