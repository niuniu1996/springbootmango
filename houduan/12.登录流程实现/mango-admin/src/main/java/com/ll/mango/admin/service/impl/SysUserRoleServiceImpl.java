package com.ll.mango.admin.service.impl;

import com.ll.mango.admin.po.SysUserRole;
import com.ll.mango.admin.service.SysUserRoleService;
import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/11/28 0028 下午 20:37
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Override
    public int save(SysUserRole record) {
        return 0;
    }

    @Override
    public int delete(SysUserRole record) {
        return 0;
    }

    @Override
    public int delete(List<SysUserRole> records) {
        return 0;
    }

    @Override
    public SysUserRole findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }

}
