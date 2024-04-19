package com.traveller.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 文章标题
	 */
	private String title;

	/**
	 * 文章展示图，用于随机文章展示
	 */
	private String firstPicture;

	/**
	 * 文章正文
	 */
	private String content;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 公开或私密
	 */
	private String isPublished;

	/**
	 * 推荐开关
	 */
	private String isRecommend;

	/**
	 * 赞赏开关
	 */
	private String isAppreciation;

	/**
	 * 评论开关
	 */
	private String isCommentEnabled;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private java.util.Date createTime;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private java.util.Date updateTime;

	/**
	 * 浏览次数
	 */
	private Integer views;

	/**
	 * 文章字数
	 */
	private Integer words;

	/**
	 * 阅读时长(分钟)
	 */
	private Integer readTime;

	/**
	 * 文章分类
	 */
	private Long categoryId;

	/**
	 * 是否置顶
	 */
	private String isTop;

	/**
	 * 密码保护
	 */
	private String password;

	/**
	 * 文章作者
	 */
	private Long userId;


}
