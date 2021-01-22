package com.vd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
public class PhoneNumberDTO implements Serializable {
	private Long mobileNo;
	private String serviceProvider;
	private String type;
}
