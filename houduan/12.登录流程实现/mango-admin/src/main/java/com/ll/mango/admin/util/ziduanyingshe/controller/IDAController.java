package com.ll.mango.admin.util.ziduanyingshe.controller;

import com.ll.mango.admin.util.ziduanyingshe.service.IDAServiceImpl;
import com.ll.mango.admin.util.ziduanyingshe.vo.IdaMappingBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author 奥特曼
 * @Date 2020/12/23 0023 11:28
 * @Description TODO
 **/
@RestController
@RequestMapping("ida")
public class IDAController {
    @Autowired
    private IDAServiceImpl idaService;
    private static Logger logger = Logger.getLogger(IDAController.class);

    /**
     * 服务治理平台报文头映射那一块,返回一个树形结构后前端进行处理
     *
     * @param headId
     * @return
     */
    public Map<String, Object> getHeadIdaMappingByMeta(@RequestParam String headId) {
        logger.info("返回给界面的结果集合，是一个树形菜单");
        Map<String, Object> map = new HashMap<>();
        logger.info("请求参数集合");
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("headId", headId);
        logger.info("获取映射集合");
        //List<IdaMappingBean> list=idaService.findHeadIdaMappingByMeta(reqMap,"seq");
        // map.put("total",list.size());
        //map.put("rows",list);
        return map;
    }
}
