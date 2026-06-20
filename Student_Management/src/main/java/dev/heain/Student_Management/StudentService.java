package dev.heain.Student_Management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepoistary repo;
	//get all student
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	//save student 
	public void saveStudent(Student student) {
		repo.save(student);
	}
	// get student by id 
	public Student getStudentById(Long id) {
		return repo.findById(id).orElse(null);
	}
	//delete student 
	public void deleteStudent(Long id) {
		repo.deleteById(id);
	}
	/* search operation*/
	public List<Student> searchStudents(String keyword){
		 List<Student> result = new ArrayList<>();

	        if (keyword == null || keyword.trim().isEmpty()) {
	            return getAllStudents();
	        }
	        //  Search by ID
	        try {
	            Long id = Long.parseLong(keyword);
	            repo.findById(id).ifPresent(result::add);
	        } catch (NumberFormatException e) {
	            // not a number → ignore
	        }
	        //  Search by Name
	        List<Student> byName = repo.findByNameContainingIgnoreCase(keyword);
	        for (Student s : byName) {
	            if (!result.contains(s)) {
	                result.add(s);
	            }
	        }
	        //  Search by Course		 
	        List<Student> byCourse = repo.findByCourseContainingIgnoreCase(keyword);
	        for (Student s : byCourse) {
	            if (!result.contains(s)) {
	                result.add(s);
	            }
	        }

	        //  Search by Dept
	        List<Student> byDept = repo.findByDeptContainingIgnoreCase(keyword);
	        for (Student s : byDept) {
	            if (!result.contains(s)) {
	                result.add(s);
	            }
	        }

	        return result;
	    }
	        
	        
		
	}