package org.example.origin.easyJavaEx;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MultilangPrg {
    public static String formatCurrencyByLocale(double value, Locale locale) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(value);
    }

    public static String formatDateByLocale(LocalDate date, Locale locale) {
        DateTimeFormatter f;
        if (locale.equals(Locale.ENGLISH)) {
            f = DateTimeFormatter.ofPattern("MMMM dd, yyyy", locale);
            return f.format(date);
        } else {
            f = DateTimeFormatter.ofPattern("dd 'tháng' MM 'năm' yyyy", locale);
            return f.format(date);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        Locale eng = Locale.ENGLISH;
        Locale vie = new Locale("vi", "VN");
        Locale chosenLocale = eng;
        ResourceBundle res = ResourceBundle.getBundle("messages", chosenLocale);

        do {
            System.out.println(res.getString("askLang") + " : ");
            System.out.println("[1] - English");
            System.out.println("[2] - Vietnamese");
            System.out.print("Your choice = ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice < 0 || choice > 2) throw new IllegalArgumentException("Invalid choice !");
                switch (choice) {
                    case 0 -> {
                        System.out.println(res.getString("exitProgram"));
                        sc.close();
                        return;
                    }
                    case 1 -> chosenLocale = eng;
                    case 2 -> chosenLocale = vie;

                }

                res = ResourceBundle.getBundle("messages", chosenLocale);
                System.out.println(res.getString("welcome"));

                LocalDate date = LocalDate.of(2024, 7, 12);
                double cost = 18000;

                System.out.println(res.getString("askName"));
                String name = sc.nextLine();

                System.out.println(res.getString("response").replace("{0}", name));
                System.out.println(res.getString("date").replace("{date}", formatDateByLocale(date, chosenLocale)));
                System.out.println(res.getString("cost").replace("{cost}", formatCurrencyByLocale(cost, chosenLocale)));
                System.out.println("-----------------------------------");

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        } while (choice != 0);
    }
}
