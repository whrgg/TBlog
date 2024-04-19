package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleJobLog {

	/**
	 * 任务日志id
	 */
	private Long logId;

	/**
	 * 任务id
	 */
	private Long jobId;

	/**
	 * spring bean名称
	 */
	private String beanName;

	/**
	 * 方法名
	 */
	private String methodName;

	/**
	 * 参数
	 */
	private String params;

	/**
	 * 任务执行结果
	 */
	private Integer status;

	/**
	 * 异常信息
	 */
	private String error;

	/**
	 * 耗时（单位：毫秒）
	 */
	private Integer times;

	/**
	 * 创建时间
	 */
	private java.util.Date createTime;


}
