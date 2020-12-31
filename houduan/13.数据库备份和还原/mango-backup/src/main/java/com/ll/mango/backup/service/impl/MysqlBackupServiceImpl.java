package com.ll.mango.backup.service.impl;


import com.ll.mango.backup.service.MysqlBackupService;
import com.ll.mango.backup.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

@Service
/**
 * @Author 奥特曼
 * @Date 2020/12/28 0028
 */
public class MysqlBackupServiceImpl implements MysqlBackupService {

	@Override
	public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
			String database) throws Exception {
		return MySqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
	}

	@Override
	public boolean restore(String restoreFilePath, String host, String userName, String password, String database)
			throws Exception {
		return MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
	}

}
