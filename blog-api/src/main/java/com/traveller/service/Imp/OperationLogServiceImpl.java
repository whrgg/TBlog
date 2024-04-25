package com.traveller.service.Imp;

import com.traveller.entity.OperationLog;
import com.traveller.mapper.OperationLogMapper;
import com.traveller.service.OperationLogService;
import com.traveller.utils.IpAddressUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @author traveller
 * @Description: 操作日志业务层实现
 * @date 2024/04/23
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {
	@Autowired
	OperationLogMapper operationLogMapper;


	@Override
	public List<OperationLog> getOperationLogListByDate(String startDate, String endDate) {
		return operationLogMapper.getOperationLogListByDate(startDate, endDate);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveOperationLog(OperationLog log) {
		log.setIpSource("");
		log.setOs("");
		log.setBrowser("");
		if (operationLogMapper.saveOperationLog(log) != 1) {
			throw new PersistenceException("日志添加失败");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteOperationLogById(Long id) {
		if (operationLogMapper.deleteOperationLogById(id) != 1) {
			throw new PersistenceException("删除日志失败");
		}
	}
}
