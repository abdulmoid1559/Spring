package com.vd.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties("per.info")
@Data
@Component("per")
public class Person {
	@Autowired
	private Environment envr = null;
	private Integer pid;
	private String pname;
	private String[] nickName;
	private Set address;
	private Map mobileNo;
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", nickName=" + Arrays.toString(nickName) + ", address="
				+ address + ", mobileNo=" + mobileNo + "]";
	}
	public void displayByEnv() {
		System.out.println(envr);
		System.out.println(".........................");
		System.out.println(envr.getProperty("per.info.pname"));
		System.out.println(envr.getProperty("per.info.address[0]"));
	} 

}
