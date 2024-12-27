package org.example.origin.studentManagementProject.model;

import java.time.LocalDate;

public class Student {
    private String rollNumber;
    private String name;
    private int age;
    private LocalDate dateOfBirth;
    private String email;
    private int phoneNumber;
    private double mark;

    public Student(String rollNumber, String name, int age, LocalDate dateOfBirth, String email, int phoneNumber, double mark) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mark = mark;
    }

    public String rollNumber() {
        return rollNumber;
    }

    public Student setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    protected String email() {
        return email;
    }

    protected Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String name() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int age() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public LocalDate dateOfBirth() {
        return dateOfBirth;
    }

    public Student setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public int phoneNumber() {
        return phoneNumber;
    }

    public Student setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public double mark() {
        return mark;
    }

    public Student setMark(double mark) {
        this.mark = mark;
        return this;
    }
}
