package com.vd.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

public class StudentDTO implements Serializable {
	private int sid;
	private String sname;
	private String address;
	private String course;
	private float fee;
	@Override
	public String toString() {
		return "StudentDTO [sid=" + sid + ", sname=" + sname + ", address=" + address + ", course=" + course + ", fee="
				+ fee + "]";
	}
}
