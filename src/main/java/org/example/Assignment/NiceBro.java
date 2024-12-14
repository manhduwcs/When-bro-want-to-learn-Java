package org.example.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NiceBro {
    public static void main(String[] args) {
        NiceBro mai = new NiceBro();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("String = ");
            String str = sc.nextLine();
            System.out.print("n = ");
            int n = sc.nextInt();
            sc.nextLine();
            if (str.equals("x")) return;
            System.out.print("Last Vowels : ");
            mai.getNLastVowel(str, n).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    // E1. 30 - 25

    // Ex.25
    public List<Character> getNLastVowel(String str, int n) {
        ArrayList<Character> res = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            if (checkVowel(c)) res.add(c);
        }
        return (res.size() > n) ? res.subList(res.size() - n, res.size()) : res;
    }

    // Ex.26
    public boolean checkValidHexCode(String str) {
        String regex = "^(0x[A-Z0-9]{2}|#[A-Z0-9]{6})$";
        return str.matches(regex);
    }

    // Ex.27
    public String addDashAfterAndBeforeVowel(String str) {
        char[] a = str.toCharArray();
        StringBuilder sb = new StringBuilder(str);
        int count = 0;
        int ins = 0;
        for (int i = 0; i < a.length; i++) {
            if (checkVowel(a[i])) {
                if (count == 0) ins = i;
                if (count > 0) ins = i + count;
                sb.insert(ins, "_");
                sb.insert(ins + 2, "_");
                count += 2;
            }
        }
        return sb.toString();
    }

    public boolean checkVowel(char c) {
        int[] vowel = {65, 97, 69, 101, 73, 105, 79, 111, 85, 117};
        for (int v : vowel) {
            if ((int) c == v) return true;
        }
        return false;
    }

    // Ex.28
    public String reverseWord(String str) {
        char[] arr = str.toCharArray();
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length - 1 - i] = arr[i];
        }
        return new String(result);
    }

    // Ex.29
    // regex : ^([0-9xyz +\-*\/=()^]|(sqrt|sin|cos|log)\(\d+\))+$
    public boolean isMathExpression(String str) {
        String regex = "^([0-9xyz +\\-*/=()^]|(sqrt|sin|cos|log)\\(\\d+\\))+$";
        return str.matches(regex);
    }

    // Ex.30
    // upper : 65-90 ; lower : 97-122
    public String insertDashBetweenUppercaseAndLowercase(String str) {
        char[] a = str.toCharArray();
        StringBuilder sb = new StringBuilder(str);
        int count = 0;
        int ins = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) continue;
            int c1 = a[i];
            int c2 = a[i - 1];
            if (c1 >= 65 && c1 <= 90) {
                System.out.println(a[i]);
                if (c2 >= 97 && c2 <= 122) {
                    if (count == 0) ins = i;
                    if (count > 0) ins = i + count;
                    sb.insert(ins, "_");
                    count++;
                }
            }
        }
        return sb.toString();
    }

    // E1. 1 - 5
    public boolean startWithPAndEndWithQ(String str) {
        String regex = "^p.+q$";
        return str.matches(regex);
    }

    public boolean oneUppercaseAndManyLowercaseFollowed(String str) {
        String regex = "^[A-Z][a-z]+$";
        return str.matches(regex);
    }

    public boolean lowercaseLetterJoined(String str) {
        String regex = "^[a-z+_]+";
        return str.matches(regex);
    }

    public boolean pFollowedByZeroOrQ(String str) {
        String regex = "^p(0+|q+)$";
        return str.matches(regex);
    }

    public boolean containsCharactersOnly(String str) {
        String regex = "^[\\p{L}\\p{N} ]+$";
        return str.matches(regex);
    }
}
