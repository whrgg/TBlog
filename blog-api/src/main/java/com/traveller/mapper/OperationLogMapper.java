package com.traveller.mapper;

import com.traveller.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author traveller
 * @Description: 操作日志持久层接口
 * @date 2024/04/23
 */
@Mapper
@Repository
public interface OperationLogMapper {
	List<OperationLog> getOperationLogListByDate(String startDate, String endDate);

	int saveOperationLog(OperationLog log);

	int deleteOperationLogById(Long id);
}
