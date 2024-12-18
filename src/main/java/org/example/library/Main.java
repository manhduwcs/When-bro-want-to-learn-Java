package org.example.library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        List<BorrowingRecord> list = libraryManagement.initializeRecords();
        System.out.println("Total number of books borrowed : " + libraryManagement.countTotalBooks(list));
        System.out.println("Record with longest borrowed period : ");
        System.out.println(libraryManagement.getLongestBorrowed(list));
        System.out.println("Record with shortest borrowed period : ");
        System.out.println(libraryManagement.getShortestBorrowed(list));
    }
}
