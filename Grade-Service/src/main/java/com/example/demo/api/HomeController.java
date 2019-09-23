package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Grade;
import com.example.demo.model.Student;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{id}")
	public Grade getStudentInGrade(@PathVariable int id) {

		Grade grade = new Grade(id, "JS1104");

		
		List<Student> stus = restTemplate.getForObject("http://student-service/students/", List.class);

		grade.setStudents(stus);
		return grade;

	}
}
