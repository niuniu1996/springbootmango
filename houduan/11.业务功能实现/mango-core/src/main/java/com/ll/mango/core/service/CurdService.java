package com.ll.mango.core.service;

import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.page.PageResult;

import java.util.List;

/**
 * 通用CRRD接口
 * @author liulan
 */
public interface CurdService<T> {
    /**
     * 保存操作
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 删除操作
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除操作
     * @param records
     */
    int delete(List<T> records);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 分页查询
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象
     * @param pageRequest
     * @return PageResult
     */
    PageResult findPage(PageRequest pageRequest);
}

