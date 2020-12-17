package com.ll.mango.admin.security;

import com.ll.mango.admin.po.SysUser;
import com.ll.mango.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/10 0010 下午 14:03
 * 登录验证器肯定是要从数据库获取用户信息进行匹配，而这个获取用户信息的任务是通过spring Security的UserDetailService组件来完成的
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser=sysUserService.findByWholeName(s);
        if(sysUser==null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        //用户权限列表，根据权限标识例如：@preAuthorize("hasAuthority"('sys:menu:view')")标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermissions(sysUser.getName());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(sysUser.getName(), sysUser.getPassword(), sysUser.getSalt(), grantedAuthorities);
    }
}
