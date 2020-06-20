package com.bijay.redis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class People {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String firstName;
private String lastName;
}
