package org.example.library;

public class BorrowingRecord {
    private Book book;
    private Member member;
    private int borrowedDays;

    public BorrowingRecord(Book book, Member member, int borrowedDays) {
        this.book = book;
        this.member = member;
        this.borrowedDays = borrowedDays;
    }

    public String toString() {
        return "Book Title : " + book.title() + "\nBorrowedDays : " + borrowedDays + "\nMember : " + member.name();
    }

    public Book book() {
        return book;
    }

    public BorrowingRecord setBook(Book book) {
        this.book = book;
        return this;
    }

    public Member member() {
        return member;
    }

    public BorrowingRecord setMember(Member member) {
        this.member = member;
        return this;
    }

    public int borrowedDays() {
        return borrowedDays;
    }

    public BorrowingRecord setBorrowedDays(int borrowedDays) {
        this.borrowedDays = borrowedDays;
        return this;
    }
}
