package com.vd.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="USERS_LOGIN")
@Data

public class UserBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer uid;
	@Column(name="NAME",length = 20)
	private String name;
	@Column(name="ADDRESS",length = 30)
	private String address;
	@Column(name="CONTACTNO")
	private Long contactNo;
	@Column(name="USER_NAME", length=20,unique = true,nullable = false)
	@Type(type = "string")
	private String username;
	@Column(name="PASSWORD", length=20)
	@Type(type = "string")
	private String password;
}
