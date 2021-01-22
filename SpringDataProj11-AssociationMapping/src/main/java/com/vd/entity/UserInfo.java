package com.vd.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USER_TAB")
@Data
public class UserInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(length=20)
	private String userName;
	@Column(length=20)
	private String address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_UID")
	private Set<PhoneNumber> number;
}
