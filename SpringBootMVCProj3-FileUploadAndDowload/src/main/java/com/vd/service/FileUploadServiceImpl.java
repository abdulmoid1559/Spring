package com.vd.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vd.model.Employee;
@Service("service")
public class FileUploadServiceImpl implements FileUploadService {
	@Value("${upload.file.location}")
	private String location;
	
	@Override
	public String upload(Employee model) throws IOException {
		long suc;
		System.out.println(location);
		Path copyLocation=Paths.get(location+File.separator+StringUtils.cleanPath(model.getCv().getOriginalFilename()));
		suc=Files.copy(model.getCv().getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
		System.out.println(suc);
		return "File uploaded "+model.getCv().getOriginalFilename();
	}
	@Override
	public List<String> getAllFile() {
		List<String> nameList=new ArrayList();
		// create File object by passing location 
		File mainFile=new File(location);
		//copy all file in array of file
		File totalFile[]=mainFile.listFiles();
		for(File file:totalFile) {
			if(file.isFile())
				nameList.add(file.getName());
		}
		
		return nameList;
	}
		
}
