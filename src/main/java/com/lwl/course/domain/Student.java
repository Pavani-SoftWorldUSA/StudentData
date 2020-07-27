package com.lwl.course.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {

	private String name;
	private String batch;
	private String qualification;
	private double score;
	private Status courseStatus;
	private Status placementStatus;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Status getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(Status courseStatus) {
		this.courseStatus = courseStatus;
	}
	public Status getPlacementStatus() {
		return placementStatus;
	}
	public void setPlacementStatus(Status placementStatus) {
		this.placementStatus = placementStatus;
	}
	
	

}
