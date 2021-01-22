package com.vd.service;

import java.io.IOException;
import java.util.List;

import com.vd.model.Employee;

public interface FileUploadService {
	public String upload(Employee model) throws IOException;
	public List<String> getAllFile();
}
