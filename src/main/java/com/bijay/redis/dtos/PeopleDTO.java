package com.bijay.redis.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO implements Serializable {
	private Long id;
	private String firstName;
	private String lastName;

}
