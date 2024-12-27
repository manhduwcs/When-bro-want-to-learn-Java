package org.example.origin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Origin {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        Image img = new ImageIcon("src/main/resources/avtCat.jpg").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
        ImageIcon avt = new ImageIcon(img);
        Border border = BorderFactory.createLineBorder(Color.black, 4);

        label.setText("What the fuck");
        label.setIcon(avt);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);

        label.setForeground(Color.gray);
        label.setFont(new Font("MV Boli", Font.PLAIN, 25));
        label.setIconTextGap(10);
//        label.setBackground(new Color(245, 158, 145));
//        label.setOpaque(true);
        label.setBorder(border);

        frame.setLayout(null);

        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(100, 100, 200, 200);

        frame.setTitle("New Swing, nice bro !");
        frame.add(label);
        frame.setIconImage(avt.getImage());

        frame.setSize(680, 680);
        frame.setVisible(true);
        frame.setResizable(true);
//        frame.pack();
//        frame.getContentPane().setBackground(new Color(0x123456));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close, exit application
    }

    public static List<Student> initializeList() {
        Student John = new Student(1, "John", "Doe", 22, 9.0);
        Student Alice = new Student(2, "Alice", "Smith", 20, 9.0);
        Student Bob = new Student(3, "Bob", "Johnson", 25, 7.5);
        Student Eve = new Student(4, "Eve", "Brown", 30, 6.0);
        Student Charlie = new Student(5, "Charlie", "Davis", 24, 7.5);
        Student Grace = new Student(6, "Grace", "Miller", 18, 7.5);
        Student David = new Student(7, "David", "Wilson", 28, 9.5);

        return new ArrayList<>(List.of(John, Alice, Bob, Eve, Charlie, Grace, David));
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
