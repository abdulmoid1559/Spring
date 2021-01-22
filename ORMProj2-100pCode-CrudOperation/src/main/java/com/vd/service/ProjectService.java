package com.vd.service;

import java.util.List;

import com.vd.dto.ProjectDTO;

public interface ProjectService {
public String registerProject(ProjectDTO dto);
public Object accessProject(Integer id);
public String modifyProject(Integer id,Double cost,Integer teamSize);
public String removeProjectById(Integer id);
public List<ProjectDTO> GetProjectByRange(Double start,Double end);
}
