package com.student.application.service;

import com.student.application.entity.Student;
public interface StudentInterface {
	public String createStudent(Student student);
	public Student getStudent(Long id);
}
