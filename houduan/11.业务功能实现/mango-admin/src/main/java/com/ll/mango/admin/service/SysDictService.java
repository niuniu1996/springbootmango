package com.ll.mango.admin.service;

import com.ll.mango.admin.po.SysDict;
import com.ll.mango.core.service.CurdService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {
    /**
     * 查询全部用户信息
     * @return
     */
    List<SysDict> findAll();
    /**
     * 查询全部用户信息
     * @return
     */
    List<SysDict> findByLabel(String lable);
    /**
     * 根据标签名称分页查询
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);
}
