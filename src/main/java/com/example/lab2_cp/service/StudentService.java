package com.example.lab2_cp.service;

import com.example.lab2_cp.model.Student;
import com.example.lab2_cp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getById(int id) {
        return repository.getById(id);
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }
}