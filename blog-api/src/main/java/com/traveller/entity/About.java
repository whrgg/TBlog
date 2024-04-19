package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class About {

	/**
	 * 主键id
	 */
	private Long id;

	private String nameEn;

	private String nameZh;

	private String value;


}
