package com.lwl.course.dto;

import java.util.stream.DoubleStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

		private String name;
		private String qualification;
		private double score;
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		
		
		
		
		
		
}
