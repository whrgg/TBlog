package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 操作者用户名
	 */
	private String username;

	/**
	 * 请求接口
	 */
	private String uri;

	/**
	 * 请求方式
	 */
	private String method;

	/**
	 * 请求参数
	 */
	private String param;

	/**
	 * 操作描述
	 */
	private String description;

	/**
	 * ip
	 */
	private String ip;

	/**
	 * ip来源
	 */
	private String ipSource;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 浏览器
	 */
	private String browser;

	/**
	 * 请求耗时（毫秒）
	 */
	private Integer times;

	/**
	 * 操作时间
	 */
	private java.util.Date createTime;

	/**
	 * user-agent用户代理
	 */
	private String userAgent;


}
