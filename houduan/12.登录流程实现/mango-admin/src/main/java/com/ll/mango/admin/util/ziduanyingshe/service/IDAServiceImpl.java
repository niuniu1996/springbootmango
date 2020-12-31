package com.ll.mango.admin.util.ziduanyingshe.service;

import com.ll.mango.admin.util.ziduanyingshe.entity.Ida;
import com.ll.mango.admin.util.ziduanyingshe.entity.Sda;
import com.ll.mango.admin.util.ziduanyingshe.vo.IdaMappingBean;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 奥特曼
 * @Date 2020/12/28 0028 16:08
 * @Description TODO
 **/
@Service
public class IDAServiceImpl {

//    public List<IdaMappingBean> findHeadIdaMappingByMeta(Map<String,String> map,String orderByProperties){
//        List<Ida>idas=findBy(map,orderByProperties);
//        List<IdaMappingBean>result=new ArrayList<>();
//        for(Ida ida:idas){
//            //已有映射寻找
//            if(StringUtils.isEmpty(ida.getSdaId())){
//              Sda sda=sdadao.get(ida.getSdaId()){
//                  if(null!=sda){
//                      result.add(new IdaMappingBean(ida,sda));
//                      continue;
//                  }
//                }
//            }
//            if(ida.getStructName().equals("root")){
//                Sda sda=new Sda();
//                sda.setSdaMetadataId("root");
//                sda.setSdaStructAlias("根节点");
//                result.add(new IdaMappingBean(ida,sda));
//                continue;
//            }
//            if(ida.getStructName().equals("request")){
//                Sda sda=new Sda();
//                sda.setSdaMetadataId("request");
//                sda.setSdaStructAlias("请求报文体");
//                result.add(new IdaMappingBean(ida,sda));
//                continue;
//            }
//            if(ida.getStructName().equals("response")){
//                Sda sda=new Sda();
//                sda.setSdaMetadataId("response");
//                sda.setSdaStructAlias("响应报文体");
//                result.add(new IdaMappingBean(ida,sda));
//                continue;
//            }
//            //全行级别的匹配
//            String sql="select * from SDA s where s.id in (select distinct (i.sdaId) from Ida i where i.structName=? and i.sdaId is not null)";
//          // List<Sda>sdaList=;
//            return result;
//
//        }
//    }
}
