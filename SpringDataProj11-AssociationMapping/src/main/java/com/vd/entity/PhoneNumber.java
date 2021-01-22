package com.vd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PHONE_TAB")
public class PhoneNumber implements Serializable {
	@Id
	private Long mobileNo;
	@Column(length=10)
	private String serviceProvider;
	@Column(length=10)
	private String type;
}
