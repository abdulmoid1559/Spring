package com.vd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vd.entity.Project;
@Repository("dao")
public class ProjectDAOImpl implements ProjectDAO {
	private static final String GET_PROJECT_COST_RANGE="FROM com.vd.entity.Project where cost>=:min and cost<=:max";
	@Autowired
	HibernateTemplate template;
	@Override
	public Integer insertProject(Project proj) {
		Integer id=0;
		id=(Integer) template.save(proj);
		return id;
	}
	@Override
	public Project getProjectById(Integer id) {
		Project proj=null;
		
		proj=template.get(Project.class, id);
		return proj;
	}
	@Override
	public Boolean updateProject(Integer id, Double cost, Integer teamSize) {
		Boolean flag=false;
		Project proj=null;
		
		proj=template.get(Project.class, id);
		if(proj!=null) {
			proj.setCost(cost);
			proj.setTeamSize(teamSize);
			template.update(proj);
			flag=true;
		}
		return flag;
	}
	@Override
	public Boolean deleteProjectById(Integer id) {
		Boolean flag=false;
		Project proj=null;
		
		proj=template.get(Project.class, id);
		if(proj!=null) {
			template.delete(proj);
			flag=true;
		}
		return flag;
	}
	@Override
	public List<Project> getProjectByCostRange(double start, double end) {
		List<Project> listProj=null;
		
		listProj=(List<Project>) template.findByNamedParam(GET_PROJECT_COST_RANGE, new String[] {"min", "max"},new Object[]{start,end});
		return listProj;
	}

}
