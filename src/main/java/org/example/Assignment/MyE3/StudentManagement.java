package org.example.Assignment.MyE3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class StudentManagement {
    protected Map<String, Student> managerMap;
    Random ran = new Random();

    public StudentManagement() {
        managerMap = new HashMap<>();
    }

    // Tất cả validate được xử lí ở Main
    protected String createRollNumber() {
        String rollNumber = "";
        do {
            rollNumber = "Student" + ran.nextInt(111111, 777777);
        } while (managerMap.containsKey(rollNumber));
        return rollNumber;
    }

    public void showAllStudents() {
        for (Student s : managerMap.values()) {
            System.out.printf("Student %s | RollNumber = %s | Age : %d | Mark = %.1f%n", s.name(), s.rollNumber(), s.age(), s.mark());
        }
    }

    public void addStudent(Student student) {
        student.setRollNumber(createRollNumber());
        managerMap.put(student.rollNumber(), student);
    }

    public void updateStudent(String rollNumber, String name, int age, double mark) {
        searchStudentByRollNumber(rollNumber).setName(name).setAge(age).setMark(mark);
    }

    public void deleteStudent(Student s) {
        managerMap.remove(s.rollNumber());
    }

    // If return null : throw exception (in main)
    // Must be cast before Add or Delete student. If rollNumber found, continue
    // If rollnumber == null, throw Exception (in main)
    public Student searchStudentByRollNumber(String rollNumber) {
        return managerMap.get(rollNumber);
    }
}
