package com.traveller.entity.dto;

import lombok.*;

/**
 * @author traveller
 * @Description: UserAgent解析DTO
 * @date 2024/04/23
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAgentDTO {
	private String os;
	private String browser;
}
