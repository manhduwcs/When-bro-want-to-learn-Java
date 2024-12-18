package org.example.assignment.MyE3;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    // regex name : ^(\p{L}{2,})( \p{L}{2,})+$
    // age : 5 - 100
    // mark : 0.0 - 10.0

    protected static String nameRegex = "^(\\p{L}{2,})( \\p{L}{2,})+$";

    // Nếu T là kiểu String : () -> sc.nextLine() / sc::nextLine
    // Nếu T là kiểu số (int, double, v.v) bắt buộc supplier là : (vd : Integer)
    // () -> Integer.parse(sc.nextLine());
    public static <T> T inputInfor(String prompt, Supplier<T> supplier, Predicate<T> validator, String errorMessage) {
        while (true) {
            try {
                System.out.print(prompt + " : ");
                T input = supplier.get();
                if (input.equals("x")) return null;
                if (input.equals(-1) || input.equals(-1.0))
                    return null; // Kiểu truyền vào buộc phải là các wrapper classz
                if (!validator.test(input)) throw new IllegalArgumentException(errorMessage);
                return input;
            } catch (Exception e) {
                System.out.println("Error : " + errorMessage + "\n");
            }
        }
    }

    public static Student findStudent(String prompt, Scanner sc, StudentManagement stm) {
        while (true) {
            try {
                System.out.print(prompt + " : ");
                String str = sc.nextLine();
                if (str.equals("x")) return null;
                Student s = stm.searchStudentByRollNumber(str);
                if (s == null) throw new IllegalArgumentException("Cannot find student with RollNumber = " + str);
                return s;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + "\n");
            }
        }
    }

    public static Integer getEditChoice(Scanner sc, Student s) {
        if (s == null) return null;
        while (true) {
            try {
                System.out.printf("Student %s | RollNumber = %s | Age = %d | Mark = %.1f%n", s.name(), s.rollNumber(), s.age(), s.mark());
                System.out.println("[1]-Edit name | [2]-Edit age | [3]-Edit mark");
                System.out.print("Enter a field you want to edit : ");
                String str = sc.nextLine();
                if (str.equals("x")) return null;
                int choice = Integer.parseInt(str);
                if (choice < 1 || choice > 3)
                    throw new IllegalArgumentException("Invalid choice ! Choice must be 1,2 or 3.");
                return choice;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.addStudent(new Student("Jack Sparrow", 23, 7.78));
        studentManagement.addStudent(new Student("Johnny Sins", 78, 9.89));
        studentManagement.addStudent(new Student("Mint Olivia", 18, 8.89));

        // Predicate : name, age, mark
        Predicate<String> nameValidator = n -> n.matches(nameRegex);
        Predicate<Integer> ageValidator = a -> a >= 5 && a <= 80;
        Predicate<Double> markValidator = m -> m >= 0.0 && m <= 10.0;

        // Supplier : Scanner input
        Supplier<String> nameSupplier = sc::nextLine;
        Supplier<Integer> ageSupplier = () -> {
            String str = sc.nextLine().trim();
            return str.equals("x") ? -1 : str.equals("-1") ? -9 : Integer.parseInt(str);
        };
        Supplier<Double> markSupplier = () -> {
            String str = sc.nextLine().trim();
            return str.equals("x") ? -1.0 : str.equals("-1") ? -9 : Double.parseDouble(str);
        };


        while (true) {
            try {
                System.out.println("=============================================================");
                System.out.println("-- Student Management System --");
                System.out.println();
                System.out.println("[1]-Add new student. [2]-Update student. [3]-Delete a Student.");
                System.out.println("[4]-Search Student by Roll Number. [5]-Display all Students. [6]-Exit.");
                System.out.println();
                System.out.print("Your choice = ");
                option = sc.nextInt();
                sc.nextLine();
                System.out.println("=============================================================");

                switch (option) {
                    case 1 -> {
                        System.out.println("=============================================================");
                        System.out.println("[1] - Add new Student.");
                        System.out.println("Reminder : Enter [x] in any field to exit Add Student.");
                        String name = inputInfor("Student's Name", nameSupplier, nameValidator, "Invalid name ! Please try again.");
                        Integer age = inputInfor("Age", ageSupplier, ageValidator, "Invalid age ! Age must be between 5 and 80.");
                        Double mark = inputInfor("Student's Mark", markSupplier, markValidator, "Invalid mark ! Mark must be between 0.0 - 10.0 !");
                        if (name == null || age == null || mark == null) throw new Exception("You've chosen to exit.");

                        Student s = new Student(name, age, mark);
                        studentManagement.addStudent(s);
                        System.out.println("Student " + name + " with RollNumber = " + s.rollNumber() + " has been added succesfully !");
                        System.out.println("=============================================================");
                    }
                    case 2 -> {
                        Student s;
                        Integer choice;
                        while (true) {
                            System.out.println("=============================================================");
                            System.out.println("[2] - Update student.");
                            System.out.println("Reminder : Enter [x] in any field to exit Update Student");
                            s = findStudent("Enter Student's rollNumber you want to edit", sc, studentManagement);
                            if (s == null) throw new Exception("You've chosen to exit.");
                            while (true) {
                                try {
                                    choice = getEditChoice(sc, s);
                                    if (choice == null) break;
                                    switch (choice) {
                                        case 1 -> {
                                            String name = inputInfor("Enter new name", nameSupplier, nameValidator, "Invalid new name ! Try again.");
                                            if (name == null) break;
                                            s.setName(name);
                                            System.out.println("New name has been set successfully !");
                                        }
                                        case 2 -> {
                                            Integer age = inputInfor("New age", ageSupplier, ageValidator, "Invalid age ! Age must be between 5 and 80.");
                                            if (age == null) break;
                                            s.setAge(age);
                                            System.out.println("New age has been set successfully !");
                                        }
                                        case 3 -> {
                                            Double mark = inputInfor("New Mark", markSupplier, markValidator, "Invalid mark ! Mark must be between 0.0 - 10.0 !");
                                            if (mark == null) break;
                                            s.setMark(mark);
                                            System.out.println("New mark has been set successfully !");
                                        }
                                        default ->
                                                System.out.println("Error : Unknown error. Please find it by yourself hehe");
                                    }
                                    System.out.println("=============================================================");
                                } catch (Exception e) {
                                    System.out.println("Error : ");
                                }
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("=============================================================");
                        System.out.println("[3] - Delete a Student");
                        // Xóa student dựa trên rollNumber (không phải dựa trên object Student)
                        Student s = findStudent("Enter Student's Roll Number you want to delete", sc, studentManagement);
                        if (s == null) throw new Exception("You've chosen to exit Delete Student.");
                        String name = s.name();
                        studentManagement.deleteStudent(s);
                        System.out.println("Student " + name + " has been deleted successfully !");
                        System.out.println("=============================================================");
                    }
                    case 4 -> {
                        System.out.println("=============================================================");
                        System.out.println("[4] - Search Student by Roll Number.");
                        Student s = findStudent("Enter Student's Rollnumber you want to find", sc, studentManagement);
                        if (s == null) throw new Exception("You've chosen to exit Find Student by Roll Number.");
                        System.out.println(s);
                        System.out.println("=============================================================");
                    }
                    case 5 -> {
                        System.out.println("=============================================================");
                        System.out.println("[5] - Display all Students.");
                        System.out.println();
                        studentManagement.showAllStudents();
                        System.out.println();
                        System.out.println("=============================================================");
                    }
                    case 6 -> {
                        System.out.println("=============================================================");
                        System.out.println("Exit program...");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() == null ? "Error : Invalid input. Try again !" : "Error : " + e.getMessage());
            }
        }
    }
}
