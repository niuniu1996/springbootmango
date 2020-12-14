package com.ll.mango.admin.service;

import com.ll.mango.admin.po.SysMenu;
import com.ll.mango.core.service.CurdService;

import java.util.List;

/**
 * @author liulan
 * @version 1.0
 * @date 2020/6/10 0010 下午 16:47
 */
public interface SysMenuService extends CurdService<SysMenu> {
    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<SysMenu> findByUserName(String userName);
}
