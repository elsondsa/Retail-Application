package com.via.springbootweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class CourseController {
	
	@Autowired
	CourseRepo courseRepo;
	
	
	@RequestMapping(path="/courses" , method=RequestMethod.GET)
	public List<Course> findAllCourses(){
		List<Course> courses = courseRepo.findAll();
		return courses;
	}
	
//	@RequestMapping(path="/courses/{id}" , method=RequestMethod.GET)
	public Course findCourseById(@PathVariable("id") int id){
//		List<Course> courses = courseRepo.findAllCourses();
//		return courseRepo.findCourse(id);
//		return courseRepo.find
		return null;
	}
	
	
	@RequestMapping(path="/courses/{title}" , method=RequestMethod.GET)
	public ResponseEntity<Course> findCourseByTitle(@PathVariable("title") String title){
		Course course = courseRepo.findByTitle(title);
		System.out.println(course);
		ResponseEntity<Course> re = null;
		if(course == null){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return re;
		}
		re = new ResponseEntity<>(course, HttpStatus.OK);
		return re;
	}
	
	@RequestMapping(path="/courses/{id}" , method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") int id){
		courseRepo.deleteById(id);
	}
	@RequestMapping(path="/courses" , method=RequestMethod.POST)
	public ResponseEntity<Void> addCourse(@RequestBody Course course){
		System.out.println(course);
		courseRepo.save(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
