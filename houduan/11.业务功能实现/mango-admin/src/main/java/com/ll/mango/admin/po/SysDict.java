package com.ll.mango.admin.po;

import java.util.Date;

public class SysDict {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.id
     *
     * @mbg.generated Wed Jun 03 20:29:20 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.value
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String value;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.label
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String label;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.type
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.description
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.sort
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private Long sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.create_by
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.create_time
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.last_update_by
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String lastUpdateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.last_update_time
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.remarks
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dict.del_flag
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    private Byte delFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.id
     *
     * @return the value of sys_dict.id
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.id
     *
     * @param id the value for sys_dict.id
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.value
     *
     * @return the value of sys_dict.value
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.value
     *
     * @param value the value for sys_dict.value
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.label
     *
     * @return the value of sys_dict.label
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.label
     *
     * @param label the value for sys_dict.label
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.type
     *
     * @return the value of sys_dict.type
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.type
     *
     * @param type the value for sys_dict.type
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.description
     *
     * @return the value of sys_dict.description
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.description
     *
     * @param description the value for sys_dict.description
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.sort
     *
     * @return the value of sys_dict.sort
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public Long getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.sort
     *
     * @param sort the value for sys_dict.sort
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.create_by
     *
     * @return the value of sys_dict.create_by
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.create_by
     *
     * @param createBy the value for sys_dict.create_by
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.create_time
     *
     * @return the value of sys_dict.create_time
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.create_time
     *
     * @param createTime the value for sys_dict.create_time
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.last_update_by
     *
     * @return the value of sys_dict.last_update_by
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.last_update_by
     *
     * @param lastUpdateBy the value for sys_dict.last_update_by
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.last_update_time
     *
     * @return the value of sys_dict.last_update_time
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.last_update_time
     *
     * @param lastUpdateTime the value for sys_dict.last_update_time
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.remarks
     *
     * @return the value of sys_dict.remarks
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.remarks
     *
     * @param remarks the value for sys_dict.remarks
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dict.del_flag
     *
     * @return the value of sys_dict.del_flag
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dict.del_flag
     *
     * @param delFlag the value for sys_dict.del_flag
     *
     * @mbg.generated Wed Jun 03 20:29:21 CST 2020
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}