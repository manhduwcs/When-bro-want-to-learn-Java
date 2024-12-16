package org.example.assignment.MyE3;

public class Student {
    private String rollNumber;
    private String name;
    private int age;
    private double mark;

    // regex name : ^(\p{L}{2,})( \p{L}{2,})+$
    // age : 5 - 100
    // mark : 0.0 - 10.0

    public Student(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student "+name+" | Rollnumber : "+rollNumber+" | Age = "+age+" | Mark = "+mark;
    }

    protected String name() {
        return name;
    }

    protected String rollNumber() {
        return this.rollNumber;
    }

    protected Student setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    protected Student setName(String name) {
        this.name = name;
        return this;
    }

    protected int age() {
        return age;
    }

    protected Student setAge(int age) {
        this.age = age;
        return this;
    }

    protected double mark() {
        return mark;
    }

    protected Student setMark(double mark) {
        this.mark = mark;
        return this;
    }
}
