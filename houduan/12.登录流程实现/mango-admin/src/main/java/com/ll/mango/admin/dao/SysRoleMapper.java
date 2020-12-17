package com.ll.mango.admin.dao;

import com.ll.mango.admin.po.SysMenu;
import com.ll.mango.admin.po.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated Fri Dec 04 18:10:37 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated Fri Dec 04 18:10:37 CST 2020
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated Fri Dec 04 18:10:37 CST 2020
     */
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated Fri Dec 04 18:10:37 CST 2020
     */
    SysRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated Fri Dec 04 18:10:37 CST 2020
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated Fri Dec 04 18:10:37 CST 2020
     */
    int updateByPrimaryKey(SysRole record);

    List<SysRole> findByName(String name);

    List<SysRole> findAll();
    /**
     * 分页查询
     *
     * @return
     */
    List<SysRole> findPage();

}