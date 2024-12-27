package org.example.origin.studentManagementProject.model;

import java.util.HashSet;

public class StudentManagement {
    HashSet<Student> students;

    public StudentManagement() {
        students = new HashSet<>();
    }

    public boolean addStudent(Student s) {
        students.add(s);
        return true;
    }

    public HashSet<Student> getAllStudents() {
        return students;
    }

    public boolean updateStudent(Student s) {
        // might be redundant as UpdateStudent will be handled in Controller
        return true;
    }

    public boolean deleteStudent(Student s) {
        // logic
        return true;
    }
}
