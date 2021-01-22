package com.vd.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
	@Id
	@NonNull
	private Integer cno;
	private String cName;
	private String address;
	private Double billAmt;
}
