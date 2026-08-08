package com.student.application.serviceimpl;

import org.springframework.stereotype.Service;

import com.student.application.entity.Student;
import com.student.application.globalexception.entity.StudentNotFoundException;
import com.student.application.repository.StudentRepo;
import com.student.application.service.StudentInterface;

@Service
public class StudentImpl implements StudentInterface {

	private final StudentRepo studentRepo;

	public StudentImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public String createStudent(Student student) {
		studentRepo.save(student);
		return "student created sucessfully...";
	}

	@Override
	public Student getStudent(Long id) {
		return studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
	}

}
