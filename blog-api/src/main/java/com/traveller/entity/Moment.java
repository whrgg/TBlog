package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moment {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 动态内容
	 */
	private String content;

	/**
	 * 创建时间
	 */
	private java.util.Date createTime;

	/**
	 * 点赞数量
	 */
	private Integer likes;

	/**
	 * 是否公开
	 */
	private String isPublished;


}
