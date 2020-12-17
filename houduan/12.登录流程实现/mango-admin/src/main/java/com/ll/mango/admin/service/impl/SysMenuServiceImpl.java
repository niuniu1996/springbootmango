package com.ll.mango.admin.service.impl;

import com.ll.mango.admin.dao.SysDictMapper;
import com.ll.mango.admin.dao.SysMenuMapper;
import com.ll.mango.admin.po.SysMenu;
import com.ll.mango.admin.service.SysMenuService;
import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/10 0010 下午 17:00
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findByUserName(String userName) {
        return sysMenuMapper.findByUserName(userName);
    }

    @Override
    public int save(SysMenu record) {
        return 0;
    }

    @Override
    public int delete(SysMenu record) {
        return 0;
    }

    @Override
    public int delete(List<SysMenu> records) {
        return 0;
    }

    @Override
    public SysMenu findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
