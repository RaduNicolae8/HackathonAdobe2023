package com.TheDonateCompass.TheDonateCompass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String city;
	private String password;
	private String name;
	private String activity;
	private String address;
	private Boolean isOng;
}
