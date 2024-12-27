package org.example.origin.studentManagementProject.model;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int age() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
