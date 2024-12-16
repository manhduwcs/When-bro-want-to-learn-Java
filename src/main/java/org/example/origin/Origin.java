package org.example.origin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class Origin {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "bro";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected succesfully !");
            
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Matrix
    // n : dimension (3x3, 4x4, 5x5 v.v)
//    public static int[] fuckMatrix(int[][] matrix, int n) {
//        int[] res = new int[n * n];
//        int min = 0, max = n;
//        int x = 0, y = 0; // matrix index
//        int i = 0; // result index
//        for (; i < res.length; i++) {
//            if (x == min && y < max) {
//                res[i] = matrix[x][y++];
//            }
//            if (y == max && x < max) {
//                res[i] = matrix[x++][y - 1];
//            }
//            if (x == max && y == max - 1 && y > min) {
//                res[i] = matrix[x - 1][y--];
//            }
//            if (y == min && x > min + 1) {
//                res[i] = matrix[x--][y - 1];
//            }

    /// /            if (y==max) {
    /// /
    /// /            }
//        }
//        return res;
//    }

    // Total all numbers in a num
    public static int sumAllNumbersInANum(int num) {
        int result = 0;
        int ts = num;
        while (ts != 0) {
            result += ts % 10;
            ts /= 10;
        }
        return result;
    }

    // Palindrome number
    public static boolean isPalindromeNumber(int num) {
        StringBuilder sb = new StringBuilder();
        int ts = num;
        while (ts != 0) {
            sb.append(ts % 10);
            ts /= 10;
        }
        return Integer.parseInt(sb.toString()) == num;
    }

    // Classify student's mark
    public static String classifyStudentMark(int mark) {
        while (true) {
            try {
                if (mark > 100 || mark < 0) return "Error : mark must be between 0 and 100";
                if (mark >= 90) return "Excellent";
                if (mark >= 75) return "Good";
                if (mark >= 60) return "Average";
                if (mark >= 50) return "Bad";
                if (mark < 50) return "So fucking bad !!!!";
                return "Error : what the fuck is this mark ?";
            } catch (Exception e) {
                System.out.println("What the fuck is " + mark + " ??");
            }
        }
    }

    // Perfect Number
    public static boolean isPerfectNumber(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) arr.add(i);
        }
        return (num == arr.stream().reduce(0, Integer::sum));
    }
}
