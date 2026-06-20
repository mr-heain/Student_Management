package dev.heain.Student_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

//import dev.heain.Student_Management.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
        @GetMapping("/")
        public String viewHomePage(Model model) {
            model.addAttribute("students", service.getAllStudents());
            return "student_list";
          
        }
        @GetMapping("/addStudent")
        public String showAddForm(Model model) {
            model.addAttribute("student", new Student());
            return "add_student";
        }

        @PostMapping("/saveStudent")
        public String saveStudent(@ModelAttribute Student student) {
            service.saveStudent(student);
            return "redirect:/";
        }
        @GetMapping("/updateStudent/{id}")
        public String showUpdateForm(@PathVariable Long id, Model model) {
            Student student = service.getStudentById(id);
            model.addAttribute("student", student);
            return "update_student";
        }

        @GetMapping("/view/{id}")
        public String viewStudent(@PathVariable Long id, Model model) {
            Student student = service.getStudentById(id);
            model.addAttribute("student", student);
            return "view_student";
        }

        @GetMapping("/deleteStudent/{id}")
        public String deleteStudent(@PathVariable Long id) {
            service.deleteStudent(id);
            return "redirect:/";
            
        }
        @GetMapping("/search")
        public String search(@RequestParam("keyword") String keyword, Model model) {
            model.addAttribute("students", service.searchStudents(keyword));
            return "student_list";
        
        }
    }


