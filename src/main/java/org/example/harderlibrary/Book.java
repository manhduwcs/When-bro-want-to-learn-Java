package org.example.harderlibrary;

public class Book {
    private String title;
    private int pages;
    private String author;
    private int availableCopies;

    public Book(String title, int pages, String author, int availableCopies) {
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return title + " : copies = " + availableCopies;
    }

    public String title() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int pages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public String author() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int availableCopies() {
        return availableCopies;
    }

    public Book setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
        return this;
    }
}
