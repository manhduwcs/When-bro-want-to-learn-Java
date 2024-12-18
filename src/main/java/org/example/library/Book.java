package org.example.library;

public class Book {
    private String title;
    private int pages;
    private String author;

    public Book(String title, int pages, String author) {
        this.title = title;
        this.pages = pages;
        this.author = author;
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
}
