package org.example.harderlibrary;

public class Member {
    private String name;
    private String id;
    private int activeBorrowings;

    public Member(String name, String id, int activeBorrowings) {
        this.name = name;
        this.id = id;
        this.activeBorrowings = activeBorrowings;
    }

    public String name() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String id() {
        return id;
    }

    public Member setId(String id) {
        this.id = id;
        return this;
    }

    public int activeBorrowings() {
        return activeBorrowings;
    }

    public Member setActiveBorrowings(int activeBorrowings) {
        this.activeBorrowings = activeBorrowings;
        return this;
    }
}
