package com.s2e.app.controller;

import java.util.Collection;


//import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.Course;
import com.s2e.app.model.Student;
import com.s2e.app.repository.CourseRepository;
import com.s2e.app.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CourseRepository courseRepo;

	@GetMapping
	public Collection<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	// Upload
	// Si incarta per colpa di JSonReference :(
	@PostMapping
	public void saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
	}

	// Read
	@GetMapping("/{student_id}")
	public Collection<Student> getStudentById(@PathVariable("student_id") int id) {
		return studentRepo.findById(id);
	}

	// Delete
	@DeleteMapping("/{student_id}")
	public void deleteStudent(@PathVariable("student_id") int id) {
		studentRepo.deleteById(id);
	}

	// Update
	@PutMapping("/{student_id}")
	public void updateStudent(@PathVariable("student_id") int id, @RequestBody Student student) {
		// Prova

		Student oldStudent = studentRepo.getById(id);
		oldStudent.setAttributes(student);
		studentRepo.save(oldStudent);

	}

	@GetMapping("/{student_id}/courses")
	public Collection<Course> getCourseByStudentId(@PathVariable("student_id") int studentId) {
		Student student = studentRepo.getById(studentId);
		return student.getCourses();

	}
	
	@GetMapping("/courses/{course_id}")
	public Collection<Student> getStudentsSubscribed(@PathVariable("course_id") int courseId) {
		Course course = courseRepo.getById(courseId);
		return course.getStudents();	
	}
	
}
