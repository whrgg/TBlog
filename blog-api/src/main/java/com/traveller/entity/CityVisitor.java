package com.traveller.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityVisitor {

	/**
	 * 城市名称
	 */
	private String city;

	/**
	 * 独立访客数量
	 */
	private Integer uv;


}
