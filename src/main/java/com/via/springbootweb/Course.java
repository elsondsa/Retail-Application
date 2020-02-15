package com.via.springbootweb;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findAllCourses", query="from Course e")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	
	String title;	
	String category;
	String type;
	Date date;
	public Course(){}
	public Course(int id, String title, String category, String type, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.type = type;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setD(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", category=" + category + ", type=" + type + ", date=" + date + "]";
	}
	
}
