package com.traveller.mapper;

import com.traveller.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author traveller
 * @Description: 登录日志持久层接口
 * @date 2024/04/23
 */
@Mapper
@Repository
public interface LoginLogMapper {

	List<LoginLog> getLoginLogListByDate(String startDate, String endDate);

	int saveLoginLog(LoginLog log);

	int deleteLoginLogById(Long id);
}
