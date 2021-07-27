package com.s2e.app.controller;

import java.util.Collection;

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
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseRepository courseRepo;

	@Autowired
	StudentRepository studentRepo;

	// Read
	@GetMapping
	public Collection<Course> getAllCourse() {
		return courseRepo.findAll();
	}

	// Upload
	@PostMapping
	public void saveCourse(@RequestBody Course course) {
		courseRepo.save(course);
	}

	// Read
	@GetMapping("/{course_id}")
	public Collection<Course> getCourseById(@PathVariable("course_id") int id) {
		return courseRepo.findById(id);
	}

	// Delete
	@DeleteMapping("/{course_id}")
	public void deleteCourse(@PathVariable("course_id") int id) {
		courseRepo.deleteById(id);
	}

	// Update

	@PutMapping("/{course_id}")
	public void updateCourse(@PathVariable("course_id") int id, @RequestBody Course course) {

		Course oldCourse = courseRepo.getById(id);
		oldCourse.setAttributes(course);
		courseRepo.save(oldCourse);

	}

	@PostMapping("{course_id}/students/{student_id}")
	public void subscribeStudentToCourse(@PathVariable("course_id") int courseId,
			@PathVariable("student_id") int studentId) {
		Course course = courseRepo.getById(courseId);
		Student student = studentRepo.getById(studentId);
		course.subscribeStudent(student);
		courseRepo.save(course);

	}

	@DeleteMapping("{course_id}/students/{student_id}")
	public void deleteStudentFromCourse(@PathVariable("course_id") int courseId,
			@PathVariable("student_id") int studentId) {
		Course course = courseRepo.getById(courseId);
		Student student = studentRepo.getById(studentId);
		course.deleteStudent(student);
		courseRepo.save(course);
	}

	@GetMapping("/students/{student_id}")
	public Collection<Course> getCourseByStudentId(@PathVariable("student_id") int studentId) {
		Student student = studentRepo.getById(studentId);
		return student.getCourses();
	}
	
	
	
}
