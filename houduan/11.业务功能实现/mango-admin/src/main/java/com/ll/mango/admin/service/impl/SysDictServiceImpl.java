package com.ll.mango.admin.service.impl;



import com.ll.mango.admin.dao.SysDictMapper;
import com.ll.mango.admin.po.SysDict;
import com.ll.mango.admin.service.SysDictService;
import com.ll.mango.core.page.MybatisPageHelper;
import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {
    
    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findAll() {
        return sysDictMapper.findAll();
    }

    @Override
    public int save(SysDict record) {
        if(record.getId()==null||record.getId()==0){
            //增加
            return sysDictMapper.insertSelective(record);
        }
        //修改
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for(SysDict record:records){
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label=pageRequest.getParam("label");
        if(label!=null){
            return MybatisPageHelper.findPage(pageRequest,sysDictMapper,"findPageByLabel",label);
        }
        return MybatisPageHelper.findPage(pageRequest,sysDictMapper);
    }
    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public List<SysDict> findPageByLabel(String label) {
        return sysDictMapper.findPageByLabel(label);
    }
}