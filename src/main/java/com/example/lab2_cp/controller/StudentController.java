package com.example.lab2_cp.controller;

import com.example.lab2_cp.model.Student;
import com.example.lab2_cp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public String processAddStudentForm(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Validation has been failed!");
            if (student.getId() != 0)
                return "edit_student";
            return "add_student";
        }
        service.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Student> list = service.getAllStudents();
        model.addAttribute("students", list);
        return "index";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", service.getById(id));
        return "edit_student";
    }

    @GetMapping("/{id}/remove")
    public String removeStudent(@PathVariable("id") int id) {
        service.removeById(id);
        return "redirect:/";
    }
}
