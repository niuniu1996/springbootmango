package com.ll.mango.backup.controller;


import com.ll.mango.backup.constants.BackupConstants;
import com.ll.mango.backup.datasource.BackupDataSourceProperties;
import com.ll.mango.backup.service.MysqlBackupService;
import com.ll.mango.backup.util.HttpResult;
import com.ll.mango.common.utils.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 系统数据备份还原
 *
 * @Author 奥特曼
 * @Date 2020/12/28 0028
 */
@RestController
@RequestMapping("/backup")
public class MySqlBackupController {
    private static Logger logger = Logger.getLogger(MySqlBackupController.class);

    @Autowired
    MysqlBackupService mysqlBackupService;
    @Autowired
    BackupDataSourceProperties properties;

    @GetMapping("/backup")
    public HttpResult backup() {
        String backupFodlerName = BackupConstants.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(BackupConstants.DATE_FORMAT)).format(new Date());
        logger.info("备份的文件名称：" + backupFodlerName);
        logger.info("备份数据库脚本开始");
        return backup(backupFodlerName);
    }

    private HttpResult backup(String backupFodlerName) {
        String host = properties.getHost();
        String userName = properties.getUserName();
        String password = properties.getPassword();
        String database = properties.getDatabase();
        String backupFolderPath = BackupConstants.BACKUP_FOLDER + backupFodlerName + File.separator;
        String fileName = BackupConstants.BACKUP_FILE_NAME;
        try {
            logger.info("参数是：host=" + host + ",username=" + userName + ",password=" + password + ",database=" + database + ",backupFolderPath=" + backupFolderPath);
            boolean success = mysqlBackupService.backup(host, userName, password, backupFolderPath, fileName, database);
            if (!success) {
                logger.equals("数据备份失败");
                HttpResult.error("数据备份失败");
            } else {
                logger.equals("数据备份成功");
            }
        } catch (Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

    @GetMapping("/restore")
    public HttpResult restore(@RequestParam String name) throws IOException {
        String host = properties.getHost();
        String userName = properties.getUserName();
        String password = properties.getPassword();
        String database = properties.getDatabase();
        String restoreFilePath = BackupConstants.RESTORE_FOLDER + name;
        logger.info("还原数据库的参数是：host=" + host + ",username=" + userName + ",password=" + password + ",database=" + database + ",restoreFilePath=" + restoreFilePath);
        try {
            logger.info("开始进行数据库还原");
            boolean flag = mysqlBackupService.restore(restoreFilePath, host, userName, password, database);
            if (flag) {
                logger.info("还原数据库成功");
            } else {
                logger.info("还原数据库失败");
            }
        } catch (Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

    /**
     * 查找备份文件，用于查找和向用户展示数据备份文件
     * @return
     */
    @GetMapping("/findRecords")
    public HttpResult findBackupRecords() {
        logger.info("查找备份文件，用于查找和向用户展示数据备份文件");
        logger.info("备份文件："+BackupConstants.DEFAULT_RESTORE_FILE);
        if (!new File(BackupConstants.DEFAULT_RESTORE_FILE).exists()) {
            // 初始默认备份文件
            backup(BackupConstants.DEFAULT_BACKUP_NAME);
        }
        List<Map<String, String>> backupRecords = new ArrayList<>();
        File restoreFolderFile = new File(BackupConstants.RESTORE_FOLDER);
        if (restoreFolderFile.exists()) {
            for (File file : restoreFolderFile.listFiles()) {
                Map<String, String> backup = new HashMap<>();
                backup.put("name", file.getName());
                backup.put("title", file.getName());
                if (BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
                    backup.put("title", "系统默认备份");
                }
                backupRecords.add(backup);
            }
        }
        // 排序，默认备份最前，然后按时间戳排序，新备份在前面
        backupRecords.sort((o1, o2) -> BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1
                : BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 : o2.get("name").compareTo(o1.get("name")));
        return HttpResult.ok(backupRecords);
    }

    @GetMapping("/delete")
    public HttpResult deleteBackupRecord(@RequestParam String name) {
        logger.info("删除备份数据库文件");
        if (BackupConstants.DEFAULT_BACKUP_NAME.equals(name)) {
            return HttpResult.error("系统默认备份无法删除!");
        }
        String restoreFilePath = BackupConstants.BACKUP_FOLDER + name;
        try {
            FileUtils.deleteFile(new File(restoreFilePath));
        } catch (Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

}
