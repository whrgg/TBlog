package com.traveller.entity;


import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 头像地址
	 */
	private String avatar;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 创建时间
	 */
	private java.util.Date createTime;

	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;

	/**
	 * 角色访问权限
	 */
	private String role;


}
