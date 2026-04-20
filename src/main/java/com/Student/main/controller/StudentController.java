package com.Student.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Student.main.entities.Student;
import com.Student.main.services.StudentService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.experimental.PackagePrivate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/students")

public class StudentController {
	
	@Autowired
	private StudentService service;
	
    // get all students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
	    return ResponseEntity.ok(service.getAllStudent());
	}
	
	//get student by id
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
	    Student student = service.getStudentById(id);
	    return ResponseEntity.ok(student);
	}
	// CREATE student
	 @PostMapping
	    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		 Student saved = service.saveStudent(student);
		 return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(saved);
	    }
	 
	 
	 // UPDATE student
	 @PutMapping("/{id}")
	 public ResponseEntity<Student> updateStudent(@PathVariable int id,
	                                              @Valid @RequestBody Student student) {
	     Student existing = service.getStudentById(id);
	     existing.setFirstName(student.getFirstName());
	     existing.setLastName(student.getLastName());
	     existing.setEmail(student.getEmail());

	     Student updated = service.saveStudent(existing);
	     return ResponseEntity.ok(updated);
	 }
	 // DELETE student
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteStudent(@PathVariable int id) {
	     service.deleteById(id);
	     return ResponseEntity.ok("Student deleted successfully");
	 }
	    //Page 
	 @GetMapping("/page")
	 public ResponseEntity<Page<Student>> getStudentsWithPagination(Pageable pageable) {
	     return ResponseEntity.ok(service.getStudents(pageable));
	 }
	    
	    // befor modification
	    
//	    @GetMapping("/students")
//		public String getAllStudents(Model model){
//			model.addAttribute("student", service.getAllStudent());
//			return "student";//view page 
//			
//		}
//	 
//	@GetMapping("/student/new")
//	public String createStudentForm(Model model) {
//		Student students = new Student();
//		model.addAttribute("students", students);
//		
//		return "create-student";
//		
//	}
//	@PostMapping("/student")
//	public String saveStudent(@ModelAttribute("students") Student students,
//								RedirectAttributes redirectAttributes) {
//		service.saveStudent(students);
//		redirectAttributes.addFlashAttribute("success", true);
//		return "redirect:/student/new";
//		
//	}
//	@GetMapping("/student/edit/{id}")
//	public String editStudentForm(@PathVariable int id, Model model) {
//		model.addAttribute("students", service.getStudentyId(id));
//		return "edit_student";
//		
//	}
//	@PostMapping("/student/edit/{id}")
//	public String updateStudent(@PathVariable int id ,@ModelAttribute("students") Student students,
//			                    RedirectAttributes redirectAttributes) {
//		Student existingstudent = service.getStudentyId(id);
//		existingstudent.setFirstName(students.getFirstName());
//		existingstudent.setLastName(students.getLastName());
//		existingstudent.setEmail(students.getEmail());
//		
//		service.saveStudent(existingstudent);
//		redirectAttributes.addFlashAttribute("success", true);
//		return "redirect:/student/edit/" + id;
//
//	}
//	@GetMapping("/student/{id}")
//	public String deletById(@PathVariable int id,
//							 RedirectAttributes redirectAttributes) {
//		service.deleteById(id);
//		redirectAttributes.addFlashAttribute("deleteSuccess", true);
//		return "redirect:/student";
//		
//	}
}
