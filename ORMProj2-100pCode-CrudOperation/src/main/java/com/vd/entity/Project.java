package com.vd.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Project implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projectId;
	@Column(length = 20,nullable = false)
	@Type(type="string")
	private String projName;
	private Double cost;
	private Integer teamSize;
	@Column(length = 20,nullable = true)
	private String company;
	@Column(length = 20,nullable = true)
	private String location;
}
