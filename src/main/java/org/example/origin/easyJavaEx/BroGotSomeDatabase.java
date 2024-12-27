package org.example.origin.easyJavaEx;

import java.sql.*;
import java.util.Scanner;

public class BroGotSomeDatabase {
    private final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private final String DB_USER = "bro";
    private final String DB_PASSWORD = "";

    Connection con;

    public BroGotSomeDatabase() {
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BroGotSomeDatabase bro = new BroGotSomeDatabase();
        System.out.println("All students in my database : ");
        bro.readStudent();

//        System.out.println("Create student : ");
//        try {
//            System.out.println("Enter Student's Name : ");
//            String name = sc.nextLine();
//            System.out.println("Age = ");
//            int age = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Mark = ");
//            double mark = sc.nextDouble();
//            sc.nextLine();
//
//            bro.createStudent(name, age, mark);
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//
//        System.out.println("After creating : ");
//        System.out.println("All students : ");
//        bro.readStudent();

//        System.out.println("Update a Student : ");
//        try {
//            System.out.println("Enter Student ID to edit : ");
//            int id = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Enter Student's Name : ");
//            String name = sc.nextLine();
//            System.out.println("Age = ");
//            int age = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Mark = ");
//            double mark = sc.nextDouble();
//            sc.nextLine();
//            bro.updateStudent(id, name, age, mark);
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//
//        System.out.println("After updating : ");
//        System.out.println("All students : ");
//        bro.readStudent();

        System.out.println("Delete Student : ");
        System.out.println("Enter Student's ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        bro.deleteStudent(id);


        System.out.println("After updating : ");
        System.out.println("All students : ");
        bro.readStudent();
    }

    public void updateStudent(int id, String name, int age, double mark) {
        String query = "UPDATE students SET name=?, age=?, mark=? WHERE id=?";
        try {
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, name);
            pre.setInt(2, age);
            pre.setDouble(3, mark);
            pre.setInt(4, id);
            pre.executeUpdate();
            System.out.println("Student with id = " + id + " has been updated succesfully !");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";
        try {
            PreparedStatement pre = con.prepareStatement(query);
            pre.setInt(1, id);
            int rowsAf = pre.executeUpdate();
            System.out.println("Student " + id + " has been Deleted ! Rows affected : " + rowsAf);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void createStudent(String name, int age, double mark) {
        try {
            String query = "INSERT INTO students(name,age,mark) VALUE(?,?,?)";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, name);
            pre.setInt(2, age);
            pre.setDouble(3, mark);
            int rowsAffected = pre.executeUpdate();
            System.out.println("Student " + name + " has been created ! " + rowsAffected + " rows affected.");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void readStudent() {
        String query = "SELECT * FROM students";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("Student Name : " + rs.getString(2) + " ; age = " + rs.getInt(3) + " ; mark = " + rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
