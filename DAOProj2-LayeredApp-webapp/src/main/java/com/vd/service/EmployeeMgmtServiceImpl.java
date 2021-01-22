package com.vd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.dao.EmployeeDAO;

@Service("empservice")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	EmployeeDAO dao=null;
	
	@Override
	public List<Map<String, Object>> getEmployeebyDesg(String[] desg) {
		List<Map<String,Object>> listMap=null;
		StringBuffer job=null;
		//read designation and store in job
		job=new StringBuffer("('");
		for(int i=0;i<desg.length;++i) {
			if(i==desg.length-1) {
				job.append(desg[i]+"')");
			}
			else {
				job.append(desg[i]+",");
			}
		}
		//use dao
		listMap=dao.GetEmployeeByJob(job.toString());
		return listMap;
	}

}
