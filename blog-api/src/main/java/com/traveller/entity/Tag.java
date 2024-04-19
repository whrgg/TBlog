package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

	/**
	 * 主键id
	 */
	private Long id;

	private String tagName;

	/**
	 * 标签颜色(可选)
	 */
	private String color;


}
