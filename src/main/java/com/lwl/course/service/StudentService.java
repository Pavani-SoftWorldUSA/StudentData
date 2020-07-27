package com.lwl.course.service;

import java.util.List;
import java.util.function.Predicate;

import com.lwl.course.domain.Student;
import com.lwl.course.dto.PlacementCountDTO;
import com.lwl.course.dto.StudentDTO;

public interface StudentService {

	List<Student> getStudentByQualification(String qualification);

	int getCountBy(Predicate<Student> predicate);
	
	PlacementCountDTO getPlacedAndNotPlacedCount();

	List<Student> search(String str);

	float successRateOfGivenBatch(String batchName);

	List<Student> maxScoreStudents();

	List<String> getAllNames();

	List<StudentDTO> getAllStudentDetails();


}
