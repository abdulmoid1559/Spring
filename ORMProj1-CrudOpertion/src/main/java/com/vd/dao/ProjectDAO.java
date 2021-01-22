package com.vd.dao;

import java.util.List;

import com.vd.entity.Project;

public interface ProjectDAO {
	public Integer insertProject(Project proj);
	public Project getProjectById(Integer id);
	public Boolean updateProject(Integer id,Double cost, Integer teamSize);
	public Boolean deleteProjectById(Integer id);
	public List<Project> getProjectByCostRange(double start,double end);
}
