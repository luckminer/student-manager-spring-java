package com.example.demo.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/")
public class HomeController {

	  @RequestMapping("/students")  
	   public List<Student> getStudents() {  
	      List<Student> stus = Arrays.asList(  
	         new Student(1, "Treehouse of Horror V", "Hanoi"),  
	         new Student(2, "The Town", "HaiPhong"),  
	         new Student(3, "The Last Traction Hero", "TP.HCM"));  
	      return stus;  
	   }  
}
