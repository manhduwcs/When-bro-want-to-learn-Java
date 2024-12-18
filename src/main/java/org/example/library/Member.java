package org.example.library;

public class Member {
    private String name;
    private String id;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
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
}
