package com.s2e.app.model;

import java.util.Scanner;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "MAIL")
	private String mail;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	
	@JsonBackReference
	private Set<Course> courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Student() {

	}

	public Student(int id, String name, String surname, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}

//	public Student(int id, String name, String surname, String mail, Set<Course> courses) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.surname = surname;
//		this.mail = mail;
//		this.courses = courses;
//	}

	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void setAttributes(Student student) {
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("Insert new name: ");
//		this.name = s.nextLine();
//		System.out.println("Insert new surname: ");
//		this.surname = s.nextLine();
//		System.out.println("Insert new mail: ");
//		this.mail = s.nextLine();
//		student = new Student();
		this.name = student.name;
		this.surname = student.surname;
		this.mail = student.mail;
		//s.close();
		

	}

}
