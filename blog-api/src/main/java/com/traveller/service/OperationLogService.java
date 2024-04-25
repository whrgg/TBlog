package com.traveller.service;

import com.traveller.entity.OperationLog;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @author traveller
 * @date 2024/04/23
 */
public interface OperationLogService {
	List<OperationLog> getOperationLogListByDate(String startDate, String endDate);

	@Async
	void saveOperationLog(OperationLog log);

	void deleteOperationLogById(Long id);
}
