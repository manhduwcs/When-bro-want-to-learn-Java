package org.example.harderlibrary;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LibraryManagement libm = new LibraryManagement();
        ArrayList<BorrowingRecord> list = libm.initializeRecords();
        libm.getTopBorrowedBooks(list).forEach(System.out::println);
        libm.getOverdueRecords(list).forEach(System.out::println);
        libm.updateAvailability(list);
    }
}
