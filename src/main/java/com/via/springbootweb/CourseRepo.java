package com.via.springbootweb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
	
	public Course findByTitle(String title);

}
