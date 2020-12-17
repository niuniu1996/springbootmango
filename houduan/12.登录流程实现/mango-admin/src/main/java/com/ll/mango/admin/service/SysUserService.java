package com.ll.mango.admin.service;

import com.ll.mango.admin.po.SysUser;
import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser> {
    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 根据用户名模糊得到List<SysUser>信息
     *
     * @param name
     * @return
     */
    List<SysUser> findByName(String name);


    /**
     * 创建用户信息excel文件
     *
     * @param pageRequest
     * @return
     */
    File creatUserExcelFile(PageRequest pageRequest);

    /**
     * 根据全名得到完整个人信息
     * @param name
     * @return
     */
    SysUser findByWholeName(String name);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    List MtO();


    List findUserRoles(Long userId);
}
