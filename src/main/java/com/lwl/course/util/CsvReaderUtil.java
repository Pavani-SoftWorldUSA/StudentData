package com.lwl.course.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lwl.course.domain.Completed;
import com.lwl.course.domain.Status;
import com.lwl.course.domain.Student;
import com.lwl.course.dto.StudentDTO;

public final class CsvReaderUtil {

	private CsvReaderUtil() {

	}

	public static List<Student> getStudents(String fileName) {

		List<String> lines;
		List<Student> studentList = new ArrayList<>();
		
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		
		try {
			lines = Files.readAllLines(Paths.get(fileName));
			studentList = lines.stream().skip(1).map(CsvReaderUtil::convert).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studentList;

	}

	private static Student convert(String line) {
		System.out.println(line);
		String[] arr = line.split(",");
		String name = arr[0];
		String batch = arr[1];
		Status courseStatus = Status.valueOf(arr[2].toUpperCase());
		Status placementStatus = Status.valueOf(arr[3].toUpperCase());
		String qualification = arr[4];
		double score = Double.parseDouble(arr[5]);

		return Student.builder().name(name).batch(batch).courseStatus(courseStatus).placementStatus(placementStatus)
				.qualification(qualification).score(score).build();
	}

}
