package com.Student.main.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.main.entities.Student;
import com.Student.main.repository.StudentRepository;
import com.Student.main.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudent() {
		List<Student> list =repository.findAll();
		return list;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return repository.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		return repository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		
	}

	@Override
	public void deleteById(int id) {
		 repository.deleteById(id);
		
	}
	// After modification 
	@Override
	public Page<Student> getStudents(Pageable pageable) {
	    return repository.findAll(pageable);
	}

}
