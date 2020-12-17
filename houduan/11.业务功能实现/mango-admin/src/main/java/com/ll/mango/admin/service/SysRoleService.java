package com.ll.mango.admin.service;

import com.ll.mango.admin.po.SysMenu;
import com.ll.mango.admin.po.SysRole;
import com.ll.mango.admin.po.SysRoleMenu;
import com.ll.mango.core.service.CurdService;

import java.util.List;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/12/5 0005 下午 20:30
 */
public interface SysRoleService extends CurdService<SysRole> {
    /**
     * 根据名称查询角色
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);

    List<SysRole> findAll();

    /**
     * 分页查询
     *
     * @return
     */
    List<SysRole> findPage();


    /**
     * 查询角色菜单集合
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    int saveRoleMenus(List<SysRoleMenu> records);
}
