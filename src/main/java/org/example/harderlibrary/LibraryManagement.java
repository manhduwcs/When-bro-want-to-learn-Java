package org.example.harderlibrary;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryManagement {
    private List<BorrowingRecord> list;

    public LibraryManagement() {
        list = new ArrayList<>();
    }

    public void updateAvailability(List<BorrowingRecord> list) {
        list.forEach(record -> {
            Book book = record.book();
            if (book != null) {
                int copies = book.availableCopies();
                book.setAvailableCopies(record.isReturned() ? copies + 1 : copies - 1);
                System.out.println(book);
            }
        });
    }

    public List<Book> getTopBorrowedBooks(List<BorrowingRecord> list) {
        return list.stream()
                .collect(Collectors.groupingBy(BorrowingRecord::book, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public double calculateTotalFines(List<BorrowingRecord> list) {
        return getOverdueRecords(list).stream().mapToDouble(BorrowingRecord::finePerDay).sum();
    }

    public Member getMemberWithMostBooks(List<BorrowingRecord> list) {
        return list.stream().max(Comparator.comparingInt(record -> record.member().activeBorrowings())).get().member();
    }

    public List<BorrowingRecord> getOverdueRecords(List<BorrowingRecord> list) {
        return list.stream().filter(item -> item.borrowedDays() > item.returnDays()).toList();
    }

    public ArrayList<BorrowingRecord> initializeRecords() {
        Book b1 = new Book("To Kill a Mockingbird", 281, "Author Lee", 5);
        Book b2 = new Book("1984", 328, "George Orwell", 3);
        Book b3 = new Book("The Great Gastby", 180, "F.Scott Fitzgerald", 4);
        Book b4 = new Book("Pride and Prejudice", 279, "Jane Austen", 6);
        Book b5 = new Book("Moby Dick", 635, "Herman Meville", 2);
        Member m1 = new Member("Alice", "M001", 1);
        Member m2 = new Member("Bob", "M002", 3);
        Member m3 = new Member("Charlie", "M003", 2);
        Member m4 = new Member("David", "M004", 0);
        Member m5 = new Member("Emma", "M005", 4);

        BorrowingRecord br1 = new BorrowingRecord(b1, m1, 14, false, 2.0, 0);
        BorrowingRecord br2 = new BorrowingRecord(b2, m2, 7, true, 1.5, 7);
        BorrowingRecord br3 = new BorrowingRecord(b3, m3, 21, false, 2.5, 0);
        BorrowingRecord br4 = new BorrowingRecord(b4, m4, 3, true, 1.0, 3);
        BorrowingRecord br5 = new BorrowingRecord(b5, m5, 10, true, 3.0, 10);
        BorrowingRecord br6 = new BorrowingRecord(b2, m5, 9, false, 1.5, 0);
        BorrowingRecord br7 = new BorrowingRecord(b4, m2, 5, true, 1.0, 5);
        BorrowingRecord br8 = new BorrowingRecord(b5, m3, 15, false, 3.0, 0);
        BorrowingRecord br9 = new BorrowingRecord(b3, m1, 18, false, 2.5, 0);
        BorrowingRecord br10 = new BorrowingRecord(b1, m4, 12, true, 2.0, 12);

        return new ArrayList<>(Arrays.asList(br1, br2, br3, br4, br5, br6, br7, br8, br9, br10));
    }
}
