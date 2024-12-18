package org.example.library;


import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
    private List<Book> books;
    private List<Member> members;
    private List<BorrowingRecord> borrowingRecords;

    public LibraryManagement() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        borrowingRecords = new ArrayList<>();
    }

    public long countTotalBooks(List<BorrowingRecord> list) {
        return list.stream().count();
    }

    public BorrowingRecord getLongestBorrowed(List<BorrowingRecord> list) {
        return list.stream().max((o1, o2) -> o1.borrowedDays() - o2.borrowedDays()).get();
    }

    public BorrowingRecord getShortestBorrowed(List<BorrowingRecord> list) {
        return list.stream().min((o1, o2) -> o1.borrowedDays() - o2.borrowedDays()).get();
    }

    public List<BorrowingRecord> initializeRecords() {
        Book b1 = new Book("To Kill a Mockingbird", 281, "Harper Lee");
        Book b2 = new Book("1984", 328, "George Orwell");
        Book b3 = new Book("The Great Gastby", 180, "F.Scott Fitzgerald");
        Book b4 = new Book("Pride and Prejudice", 279, "Jane Austen");
        Book b5 = new Book("Moby Dick", 635, "Herman Melville");

        Member m1 = new Member("Alice", "M001");
        Member m2 = new Member("Bob", "M002");
        Member m3 = new Member("Charlie", "M003");
        Member m4 = new Member("David", "M004");
        Member m5 = new Member("Emma", "M005");

        BorrowingRecord br1 = new BorrowingRecord(b1, m1, 14);
        BorrowingRecord br2 = new BorrowingRecord(b2, m2, 7);
        BorrowingRecord br3 = new BorrowingRecord(b3, m3, 21);
        BorrowingRecord br4 = new BorrowingRecord(b4, m4, 3);
        BorrowingRecord br5 = new BorrowingRecord(b5, m5, 10);

        borrowingRecords.add(br1);
        borrowingRecords.add(br2);
        borrowingRecords.add(br3);
        borrowingRecords.add(br4);
        borrowingRecords.add(br5);

        return borrowingRecords;
    }
}
