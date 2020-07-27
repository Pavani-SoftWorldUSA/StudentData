package com.lwl.course.service;


import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.lwl.course.domain.Status;
import com.lwl.course.domain.Student;
import com.lwl.course.dto.PlacementCountDTO;
import com.lwl.course.dto.StudentDTO;
import com.lwl.course.util.CsvReaderUtil;


public class StudentServiceImpl implements StudentService {

	private List<Student> studentList;

	private String fileName;
	
	private static Scanner x;
	String filepath ="coursedata.csv";
	String search ="Name,Batch,Qualification,Score";

	private PlacementCountDTO placementCountDTO;

	public StudentServiceImpl(String fileName) {
		studentList = CsvReaderUtil.getStudents(fileName);
	}

	@Override
	public List<Student> getStudentByQualification(String qualification) {
		return studentList.stream().filter(s -> s.getQualification().equalsIgnoreCase(qualification))
				.collect(Collectors.toList());
	}

	@Override
	public int getCountBy(Predicate<Student> predicate) {
		return (int) studentList.stream().filter(predicate).count();
	}
	

	@Override
	public PlacementCountDTO getPlacedAndNotPlacedCount() {
		Predicate<Student> placed = (p) -> p.getPlacementStatus().equals(Status.Y);
		Predicate<Student> notplaced = (p) -> p.getPlacementStatus().equals(Status.N);
		PlacementCountDTO placementCountDTO = new PlacementCountDTO();
		placementCountDTO.setPlacedCount(getCountBy(placed));
		placementCountDTO.setNotPlacedCount(getCountBy(notplaced));
		return placementCountDTO;


	}

	@Override
	public List<Student> search(String str) {
		return studentList.stream().filter(e->e.getName().toLowerCase().contains(str.toLowerCase())).collect(Collectors.toList());

	}


	@Override
	public List<Student> maxScoreStudents() {
		double maxScore = getMaxScore(studentList);
		
		  return studentList.stream()
				  .filter(e -> e.getScore() == maxScore)
				  .collect(Collectors.toList());
		
	}

	@Override
	public List<String> getAllNames() {
		return studentList.stream().map(Student::getName).collect(Collectors.toList());
	}


	@Override
	
		
	public List<StudentDTO> getAllStudentDetails() {
		 
		return studentList.stream().map(s -> new StudentDTO(s.getName(),
				s.getQualification(),s.getScore())).collect(Collectors.toList());
		
		}
 
		


	

	private double getMaxScore(List<Student> studentList) {
		return studentList.stream().mapToDouble(s -> s.getScore()).boxed().max(Double::compareTo).get();
	}

	@Override
	public float successRateOfGivenBatch(String batchName) {
		
		List<Student> Batch = studentList.stream().filter(b->b.getBatch().
				equalsIgnoreCase(batchName)).collect(Collectors.toList());
		
		int success = (int) Batch.stream().filter(s->s.getCourseStatus().equals(Status.Y)).count();
		
		int total = studentList.size();
		
		return (float)(success*100/total);
	}
	
	
	
}
