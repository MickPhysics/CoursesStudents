package com.s2e.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s2e.app.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Collection<Course> findById(int id);

}
