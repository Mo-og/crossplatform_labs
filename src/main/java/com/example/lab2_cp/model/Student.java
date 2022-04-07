package com.example.lab2_cp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @Size(min = 2, max = 50, message = "First name should be from 2 to 50 characters")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 50, message = "Last name should be from 2 to 50 characters")
    private String lastName;

    @Column(name = "patronymic")
    @Size(min = 2, max = 50, message = "Patronymic should be from 2 to 50 characters")
    private String patronymic;

    @Column(name = "email")
    @Pattern(regexp = "^[\\w.\\-]+@(\\w+\\.)+[\\w\\-]{2,4}$", message = "email format is invalid")
    private String email;

    @Column(name = "phone")
    @Size(min = 8, max = 20, message = "Phone should be from 8 to 20 characters")
    private String phone;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String patronymic, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
    }
}