package com.Student.main.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Student.main.entities.Student;

public interface StudentService {
	
	
List<Student> getAllStudent(); 


public Student saveStudent(Student student); 

public Student getStudentById(int id);

public void deleteById(int id);

Page<Student> getStudents(Pageable pageable);
}
