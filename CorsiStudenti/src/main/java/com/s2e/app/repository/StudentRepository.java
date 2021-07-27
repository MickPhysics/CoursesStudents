package com.s2e.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s2e.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Collection<Student> findById(int id);
}
