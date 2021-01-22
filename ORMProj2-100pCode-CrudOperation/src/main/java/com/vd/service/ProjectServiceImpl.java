package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vd.dao.ProjectDAO;
import com.vd.dto.ProjectDTO;
import com.vd.entity.Project;

@Service("service")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO dao;
	@Override
	@Transactional
	public String registerProject(ProjectDTO dto) {
		Project proj=null;
		Integer id=0;
		
		proj=new Project();
		BeanUtils.copyProperties(dto, proj);
		id=dao.insertProject(proj);
		return id==0?"Registration failed"+id:"project registartion successed"+dto.getProjName();
	}
	@Override
	public Object accessProject(Integer id) {
		ProjectDTO dto=null;
		Project bo=null;
		
		bo=dao.getProjectById(id);
		if(bo!=null) {
		dto=new ProjectDTO();
		BeanUtils.copyProperties(bo, dto);
		}
		return dto==null?"Project not found with Id"+id:dto;
	}
	@Override
	@Transactional
	public String modifyProject(Integer id, Double cost, Integer teamSize) {
		Boolean flag=false;
		
		flag=dao.updateProject(id, cost, teamSize);
		return flag==true?"Project cost and team size modified successfully":"Project not Found";
	}
	@Override
	@Transactional
	public String removeProjectById(Integer id) {
		Boolean flag=false;
		flag=dao.deleteProjectById(id);
		return flag==true?"Project deleted from db":"Project is not available of this id"+id;
	}
	@Override
	public List<ProjectDTO> GetProjectByRange(Double start, Double end) {
		List<ProjectDTO> listdto=new ArrayList<ProjectDTO>();
		List<Project> listbo=null;
		
		
		listbo=dao.getProjectByCostRange(start, end);
		listbo.forEach(bo->{
			ProjectDTO dto=new ProjectDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}
}
