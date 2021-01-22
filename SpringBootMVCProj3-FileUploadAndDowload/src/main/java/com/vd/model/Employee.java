package com.vd.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Employee implements Serializable {
	
	private MultipartFile cv;
	
}
