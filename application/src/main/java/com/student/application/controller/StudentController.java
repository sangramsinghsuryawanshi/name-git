package com.student.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.application.entity.Student;
import com.student.application.service.StudentInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private final StudentInterface studentInterface;

	public StudentController(StudentInterface studentInterface) {
		this.studentInterface = studentInterface;
	}

	@PostMapping("/create")
	public String studentPostMapping(@Valid @RequestBody Student student) {
		String message = studentInterface.createStudent(student);
		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudentController(@PathVariable Long id) {
		Student student = studentInterface.getStudent(id);
		return ResponseEntity.status(HttpStatus.FOUND.value()).body(student);
	}
}
