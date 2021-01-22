package com.vd.dto;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProjectDTO implements Serializable {
	private Integer projectId;
	private String projName;
	private Double cost;
	private Integer teamSize;
	private String company;
	private String location;
	@Override
	public String toString() {
		return "ProjectDTO [projectId=" + projectId + ", projName=" + projName + ", cost=" + cost + ", teamSize="
				+ teamSize + ", company=" + company + ", location=" + location + "]";
	}
	
}
