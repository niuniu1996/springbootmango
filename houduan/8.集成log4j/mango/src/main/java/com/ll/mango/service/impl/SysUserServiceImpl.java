package com.ll.mango.service.impl;


import com.ll.mango.dao.SysUserMapper;
import com.ll.mango.entity.SysUser;
import com.ll.mango.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

}