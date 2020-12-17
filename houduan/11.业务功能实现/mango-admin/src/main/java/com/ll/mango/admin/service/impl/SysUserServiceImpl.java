package com.ll.mango.admin.service.impl;

import com.ll.mango.admin.dao.SysDeptMapper;
import com.ll.mango.admin.dao.SysUserMapper;
import com.ll.mango.admin.dao.SysUserRoleMapper;
import com.ll.mango.admin.po.SysDept;
import com.ll.mango.admin.po.SysMenu;
import com.ll.mango.admin.po.SysUser;
import com.ll.mango.admin.po.SysUserRole;
import com.ll.mango.admin.service.SysMenuService;
import com.ll.mango.admin.service.SysUserService;
import com.ll.mango.common.utils.PoiUtis;
import com.ll.mango.core.page.MybatisPageHelper;
import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.page.PageResult;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SysUserServiceImpl implements SysUserService {
    private Map<String, List<String>> MProToOConMap = new HashMap<>();
    private Map<String, List<String>> MConToOProMap = new HashMap<>();
    private Map<String, List<String>> OneMapC = new LinkedHashMap<>();
    private Map<String, List<String>> OneMapP = new LinkedHashMap<>();
    private static Logger logger = Logger.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysDeptMapper sysDeptMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Transactional
    @Override
    public int save(SysUser record) {
        logger.info("创建用户后需要给用户分配角色");
        Long id = null;
        if (sysUserMapper.selectByPrimaryKey(record.getId()) == null) {
            //部门表是外键，先要根据查询部门表中的id是否存在
            logger.info("部门表是外键，先要根据查询部门表中的id是否存在，开始");
            SysDept sysDept = sysDeptMapper.selectByPrimaryKey(record.getDeptId());
            if (sysDept != null) {
                logger.info("部门id存在，开始插入用户信息");
                // 新增用户
                sysUserMapper.insertSelective(record);
                id = record.getId();
            }
        } else {
            // 更新用户信息
            sysUserMapper.updateByPrimaryKeySelective(record);
        }
        // 更新用户角色
        if (id != null && id == 0) {
            return 1;
        }
        if (id != null) {
            logger.info("如果新增是是插入用户信息数据时，角色相关信息也需要更新，开始");
            for (SysUserRole sysUserRole : record.getUserRoles()) {
                sysUserRole.setUserId(id);
            }
        } else {
            logger.info("如果是修改信息数据时，角色相关信息也需要更新，原先用户角色要删除，开始");
            sysUserRoleMapper.deleteByUserId(record.getId());
        }
        for (SysUserRole sysUserRole : record.getUserRoles()) {
            //得到用户角色表主键最大值加一
            logger.info("得到用户角色表主键最大值加一");
            int rolePri = sysUserRoleMapper.getMaxId() + 1;
            sysUserRole.setId((long) rolePri);
            sysUserRoleMapper.insertSelective(sysUserRole);
        }
        return 1;
    }

    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysUser> records) {
        for (SysUser record : records) {
            logger.info("根据用户集合信息删除用户数据，先删除用户角色信息");
            sysUserRoleMapper.deleteByUserId(record.getId());
            delete(record);
        }
        return 1;
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysUserMapper);
    }

    @Override
    public File creatUserExcelFile(PageRequest pageRequest) {
        PageResult pageResult = findPage(pageRequest);
        return creatUserExcelFile(pageResult.getContent());
    }

    /**
     * 根据用户名得到SysUser信息
     *
     * @param name
     * @return
     */
    @Override
    public List<SysUser> findByName(String name) {
        logger.info("根据用户名" + name + "模糊匹配得到List<SysUser>信息" + sysUserMapper.findByName(name));
        return sysUserMapper.findByName(name);
    }

    /**
     * 导出excel报表
     *
     * @param records
     * @return
     */
    public static File creatUserExcelFile(List<?> records) {
        logger.info("导出excel报表");
        if (records == null) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        int columnNo = 0;
        row.createCell(columnNo).setCellValue("No");
        row.createCell(++columnNo).setCellValue("ID");
        row.createCell(++columnNo).setCellValue("用户名");
        row.createCell(++columnNo).setCellValue("昵称");
        row.createCell(++columnNo).setCellValue("机构");
        row.createCell(++columnNo).setCellValue("邮箱");
        row.createCell(++columnNo).setCellValue("手机号");
        row.createCell(++columnNo).setCellValue("状态");
        row.createCell(++columnNo).setCellValue("创建人");
        row.createCell(++columnNo).setCellValue("创建时间");
        row.createCell(++columnNo).setCellValue("最后更新人");
        row.createCell(++columnNo).setCellValue("最后更新时间");
        //填充文件
        for (int i = 0; i < records.size(); i++) {
            SysUser user = (SysUser) records.get(i);
            Row row0 = sheet.createRow(i + 1);
            for (int j = 0; j < columnNo + 1; j++) {
                row0.createCell(j);
            }
            columnNo = 0;
            row0.getCell(columnNo).setCellValue(i + 1);
            row0.getCell(++columnNo).setCellValue(user.getId());
            row0.getCell(++columnNo).setCellValue(user.getName());
            row0.getCell(++columnNo).setCellValue(user.getNickName());
            row0.getCell(++columnNo).setCellValue(user.getDeptId());
            row0.getCell(++columnNo).setCellValue(user.getEmail());
            row0.getCell(++columnNo).setCellValue(user.getMobile());
            row0.getCell(++columnNo).setCellValue(user.getStatus());
            row0.getCell(++columnNo).setCellValue(user.getCreateBy());
            //将datetime转换为string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            row0.getCell(++columnNo).setCellValue(sdf.format(user.getCreateTime()));
            row0.getCell(++columnNo).setCellValue(user.getLastUpdateBy());
            row0.getCell(++columnNo).setCellValue(sdf.format(user.getLastUpdateTime()));
        }
        return PoiUtis.createExcelFile(workbook, "download_user");//download_user是文件名称
    }

    /**
     * 根据用户名得到SysUser信息
     *
     * @param name
     * @return
     */
    @Override
    public SysUser findByWholeName(String name) {
        logger.info("根据用户名完整匹配" + name + "得到SysUser信息" + sysUserMapper.findByWholeName(name));
        return sysUserMapper.findByWholeName(name);
    }


    /**
     * 根据用户名查找菜单列表
     *
     * @param userName
     * @return
     */
    @Override
    public Set<String> findPermissions(String userName) {

        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUserName(userName);
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }


    /**
     * 调用关系，提供方-调用方类似功能
     *
     * @return
     */
    public List MtO() {
        List list = sysUserMapper.MtO();

        long start = System.currentTimeMillis();
        logger.info("当前时间：" + start);
//        if (list != null & list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                List tempCon = new ArrayList();
//                List tempPro = new ArrayList();
//                //取值list.get(i)里面的
//                Object[] objectsi = (Object[]) list.get(i);
//                String coni = objectsi[0].toString();
//
//                String proi = objectsi[1].toString();
//                for (int j = 0; j < list.size(); j++) {
//                    Object[] objectsj = (Object[]) list.get(j);
//                    if (objectsj[0].toString().equals(coni)) {
//                        //同一个调用方多个提供方
//                        tempPro.add(objectsj[1].toString());
//                    }
//                    if (objectsj[1].toString().equals(proi)) {
//                        //同一个提供方多个调用方
//                        tempCon.add(objectsj[0].toString());
//                    }
//                }
//                MProToOConMap.put(coni, tempPro);
//                MConToOProMap.put(proi, tempCon);
//            }
//
//
//
//            logger.info("花费时间：" + (System.currentTimeMillis() - start));
//            //同一个提供方多个调用方
//            //排序整体分为1.2.3.4步骤
//            //1
//            Map<String, Integer> retMapC = new HashMap<>();
//            for (Map.Entry<String, List<String>> entry : MConToOProMap.entrySet()) {
//                String key = entry.getKey().toString();
//                List<String> values = entry.getValue();
//                int finalValue = values.size();
//                retMapC.put(key, finalValue);
//            }
//            //2.排序出来哪一个提供方被调用方调用的个数多少mapList
//            List<Map.Entry<String, Integer>> mapListC = new LinkedList<>(retMapC.entrySet());
//            Collections.sort(mapListC, new Comparator<Map.Entry<String, Integer>>() {
//                @Override
//                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                    return o2.getValue().compareTo(o1.getValue());
//                }
//            });
//            //3
//            for(Map.Entry<String,Integer>entry:mapListC){
//                List<String>temp=MConToOProMap.get(entry.getKey());
//                OneMapC.put(entry.getKey(),temp);
//            }
//
//
//            //同一个调用方多个提供方
//            //排序整体分为1.2.3.4步骤
//            //1
//            Map<String, Integer> retMapP = new HashMap<>();
//            for (Map.Entry<String, List<String>> entry : MProToOConMap.entrySet()) {
//                String key = entry.getKey().toString();
//                List<String> values = entry.getValue();
//                int finalValue = values.size();
//                retMapP.put(key, finalValue);
//            }
//            //2.排序出来哪一个提供方被调用方调用的个数多少mapList
//            List<Map.Entry<String, Integer>> mapListP = new LinkedList<>(retMapP.entrySet());
//            Collections.sort(mapListP, new Comparator<Map.Entry<String, Integer>>() {
//                @Override
//                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                    return o2.getValue().compareTo(o1.getValue());
//                }
//            });
//            //3
//            for(Map.Entry<String,Integer>entry:mapListC){
//                List<String>temp=MProToOConMap.get(entry.getKey());
//                OneMapP.put(entry.getKey(),temp);
//            }


        //第二种情况list是map的形式
        if (list != null & list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                List tempCon = new ArrayList();
                List tempPro = new ArrayList();
                String namei = null;
                String remarki = null;
                //取值list.get(i)里面的
                Map<String, String> mapi = (Map<String, String>) list.get(i);
                for (Object oi : mapi.keySet()) {
                    //同一个名称多个角色
                    if (oi.toString().equals("nick_name")) {
                        namei = mapi.get(oi);
                    }
                    //同一个名称多个角色
                    if (oi.toString().equals("remark")) {
                        remarki = mapi.get(oi);
                    }
                }

                for (int j = 0; j < list.size(); j++) {
                    Map<String, String> mapj = (Map<String, String>) list.get(j);
                    for (Object oj : mapj.keySet()) {
                        //同一个名称多个角色
                        if (oj.toString().equals("nick_name")) {
                            if (mapj.get(oj).equals(namei)) {
                                //同一个调用方多个提供方
                                tempPro.add(mapj.get("remark"));
                            }
                        }
                        if (oj.toString().equals("remark")) {
                            if (mapj.get(oj).equals(remarki)) {
                                //同一个提供方多个调用方
                                tempCon.add(mapj.get("nick_name"));
                            }
                        }
                    }
                }
                MProToOConMap.put(namei, tempPro);
                MConToOProMap.put(remarki, tempCon);
            }

        }

        logger.info("花费时间：" + (System.currentTimeMillis() - start));
        //同一个昵称多个角色
        //排序整体分为1.2.3.4步骤
        //1
        logger.info("1：得到map里面的list大小");
        Map<String, Integer> retMapC = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : MConToOProMap.entrySet()) {
            String key = entry.getKey().toString();
            List<String> values = entry.getValue();
            int finalValue = values.size();
            retMapC.put(key, finalValue);
        }
        //2.排序出来哪一个提供方被调用方调用的个数多少mapList
        List<Map.Entry<String, Integer>> mapListC = new LinkedList<>(retMapC.entrySet());
        Collections.sort(mapListC, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //3，把一个key里面的size的位置排好
        for (Map.Entry<String, Integer> entry : mapListC) {
            List<String> temp = MConToOProMap.get(entry.getKey());
            OneMapC.put(entry.getKey(), temp);
        }


        //同一个调用方多个提供方
        //排序整体分为1.2.3.4步骤
        //1
        Map<String, Integer> retMapP = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : MProToOConMap.entrySet()) {
            String key = entry.getKey().toString();
            List<String> values = entry.getValue();
            int finalValue = values.size();
            retMapP.put(key, finalValue);
        }
        //2.排序出来哪一个提供方被调用方调用的个数多少mapList
        List<Map.Entry<String, Integer>> mapListP = new LinkedList<>(retMapP.entrySet());
        Collections.sort(mapListP, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //3
        for (Map.Entry<String, Integer> entry : mapListP) {
            List<String> temp = MProToOConMap.get(entry.getKey());
            OneMapP.put(entry.getKey(), temp);
        }
        return list;
    }

    @Override
    public List findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }
}