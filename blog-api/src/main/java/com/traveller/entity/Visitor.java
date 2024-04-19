package com.traveller.entity;


import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 访客标识码
	 */
	private String uuid;

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
	 * 首次访问时间
	 */
	private java.util.Date createTime;

	/**
	 * 最后访问时间
	 */
	private java.util.Date lastTime;

	/**
	 * 访问页数统计
	 */
	private Integer pv;

	/**
	 * user-agent用户代理
	 */
	private String userAgent;


}
