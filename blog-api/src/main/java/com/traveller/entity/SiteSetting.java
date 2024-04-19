package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteSetting {

	/**
	 * 主键id
	 */
	private Long id;

	private String nameEn;

	private String nameZh;

	private String value;

	/**
	 * 1基础设置，2页脚徽标，3资料卡，4友链信息
	 */
	private Integer type;


}
