package com.vd.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Customer")
@Data
public class CustomerBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CustomerID")
	private Integer cid;
	@Column(name="CustomerName",length = 20)
	private String name;
	@Column(name="Address",length = 30)
	private String address;
	@Column(name="ContactNo")
	private Long contactNo;
}
