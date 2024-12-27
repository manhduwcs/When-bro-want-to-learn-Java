package org.example.harderlibrary;

public class BorrowingRecord {
    private Book book;
    private Member member;
    private int borrowedDays;
    private boolean isReturned;
    private double finePerDay;
    private int returnDays;

    public BorrowingRecord(Book book, Member member, int borrowedDays, boolean isReturned, double finePerDay, int returnDays) {
        this.book = book;
        this.member = member;
        this.borrowedDays = borrowedDays;
        this.isReturned = isReturned;
        this.finePerDay = finePerDay;
        this.returnDays = returnDays;
    }

    @Override
    public String toString() {
        return "Book : " + book.title() + "Borrowed By member : " + member.name() + " ; Borrowed Days : " + borrowedDays + " ; Returned Days : " + returnDays;
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

    public boolean isReturned() {
        return isReturned;
    }

    public BorrowingRecord setReturned(boolean returned) {
        isReturned = returned;
        return this;
    }

    public double finePerDay() {
        return finePerDay;
    }

    public BorrowingRecord setFinePerDay(double finePerDay) {
        this.finePerDay = finePerDay;
        return this;
    }

    public int returnDays() {
        return returnDays;
    }

    public BorrowingRecord setReturnDays(int returnDays) {
        this.returnDays = returnDays;
        return this;
    }
}
