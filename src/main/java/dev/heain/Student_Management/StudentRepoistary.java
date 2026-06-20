package dev.heain.Student_Management;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepoistary extends JpaRepository<Student,Long>{
	List<Student> findByNameContainingIgnoreCase(String name);
	List<Student> findByCourseContainingIgnoreCase(String course);
	List<Student> findByDeptContainingIgnoreCase(String dept);
	
	

}
