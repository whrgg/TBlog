package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 用户名称
	 */
	private String username;

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
	 * 登录状态
	 */
	private String status;

	/**
	 * 操作描述
	 */
	private String description;

	/**
	 * 登录时间
	 */
	private java.util.Date createTime;

	/**
	 * user-agent用户代理
	 */
	private String userAgent;


}
