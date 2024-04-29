package com.traveller.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 站点
	 */
	private String website;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 公开或隐藏
	 */
	private String isPublished;

	/**
	 * 点击次数
	 */
	private Integer views;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date createTime;


}
