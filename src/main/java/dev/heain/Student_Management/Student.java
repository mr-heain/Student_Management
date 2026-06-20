package dev.heain.Student_Management;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
Long id;
String name;
String course;
String dept;

/*
public Student() {
		this.id = id;
		this.name = name;
		this.course = course;
		this.dept = dept;
	} */
}

//these are getter and setter but i used @Data and add lambok to dependencies so i can remove them and use @Data to generate getter and setter automatically
/* 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}

*/	

