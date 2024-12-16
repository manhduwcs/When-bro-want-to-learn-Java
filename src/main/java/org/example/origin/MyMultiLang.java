package org.example.origin;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MyMultiLang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale locale = Locale.ENGLISH; // default
        while (true) {
            try {
                System.out.println("Choose language : ");
                System.out.print("[1]-English | [2]-Vietnamese | [0]-Exit : ");
                int choose = sc.nextInt();
                switch (choose) {
                    case 0 -> {
                        System.out.println("Exit program.");
                        return;
                    }
                    case 1 -> locale = Locale.ENGLISH;
                    case 2 -> locale = new Locale("vi", "VN");
                    default -> throw new IllegalArgumentException("Invalid chosen language. Try again !");
                }
                ResourceBundle messages = ResourceBundle.getBundle("messages", locale);
                DateTimeFormatter dateFormatter = (locale.equals(Locale.ENGLISH)) ?
                        DateTimeFormatter.ofPattern("MMMM d,yyyy", locale) : DateTimeFormatter.ofPattern("d 'tháng' M 'năm' yyyy", locale);
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

                LocalDate date = LocalDate.of(2024, 3, 10);
                int cost = 12000;

                System.out.println(messages.getString("title"));
                System.out.println(messages.getString("date").replace("{date}", dateFormatter.format(date)));
                System.out.println(messages.getString("cost").replace("{cost}", numberFormat.format(cost)));

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
