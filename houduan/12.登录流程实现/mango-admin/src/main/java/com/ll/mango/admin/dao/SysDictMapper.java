package com.ll.mango.admin.dao;

import com.ll.mango.admin.po.SysDict;
import com.ll.mango.admin.po.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface SysDictMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    int insert(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    int insertSelective(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    SysDict selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    int updateByPrimaryKeySelective(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    int updateByPrimaryKey(SysDict record);

    /**
     * 查询全部
     * @return
     */
    List<SysDict> findAll();

    /**
     * 分页查询
     * @return
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(@Param(value = "label") String label);
    /**
     * 根据标签名称分页查询
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);
}