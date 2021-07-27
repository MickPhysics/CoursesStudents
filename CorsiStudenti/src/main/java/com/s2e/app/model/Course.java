package com.s2e.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "COURSENAME")
	private String courseName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CFU")
	private int cfu;

	// fetch lazy caricamento più fluido
	// fetch = recupero dati
	// EAGER: OneToOne e ManyToOne. per ogni studente carichi anche i corsi di ogni
	// studente
	// con una sola query
	// LAZY: ManyToMany e OneToMany. Il lazy è più efficiente, carica prima tutti
	// gli student e poi usa getCourses (model)
	@ManyToMany(fetch = FetchType.LAZY) // ,
	// mappedBy = "courses")
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
	@JsonIgnore
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Course() {

	}

	public Course(int id, String courseName, String description, int cfu) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.cfu = cfu;
	}

	public void setAttributes(Course course) {
		this.courseName = course.courseName;
		this.description = course.description;
		this.cfu = course.cfu;

	}

	public void subscribeStudent(Student student) {
		students.add(student);
	}

	public void deleteStudent(Student student) {
		students.remove(student);
	}

//	public Course(int id, String courseName, String description, int cfu, Set<Student> students) {
//		super();
//		this.id = id;
//		this.courseName = courseName;
//		this.description = description;
//		this.cfu = cfu;
//		this.students = students;
//	}

}
