package org.example.origin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Parent {
    public Parent() {
    }


    protected void display() {
        System.out.println("From Parent ;");
    }
}

class Children extends Parent {
    public void display() {
        System.out.println("From Children !");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent p2 = new Children();

    }
//    protected static String nameRegex = "^(\\p{L}{2,})( \\p{L}{2,})+$";
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        Predicate<String> nameValidator = s -> s.matches(nameRegex);
//        Supplier<String> nameSupplier = sc::nextLine;
//        System.out.println(inputInfor("Enter your name",nameSupplier, nameValidator, "Invalid name ! Try again."));
//    }

    // Nếu T là kiểu String : () -> sc.nextLine() / sc::nextLine
    // Nếu T là kiểu số (int, double, v.v) bắt buộc supplier là : (vd : Integer)
    // () -> Integer.parse(sc.nextLine());
    public static <T> T inputInfor(String prompt, Supplier<T> supplier, Predicate<T> validator, String errorMessage) {
        while (true) {
            try {
                System.out.print(prompt + " : ");
                T input = supplier.get();
                if (!validator.test(input)) throw new IllegalArgumentException(errorMessage);
                return input;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + "\n");
            }
        }
    }

    public static <T, U> Map<T, U> toMap(List<Pair<T, U>> list) {
        Map<T, U> map = new HashMap<>();
        for (Pair<T, U> p : list) {
            map.putIfAbsent(p.getLeft(), p.getRight());
        }
        return map;
    }

    public static <T> List<T> toList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newlist = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) newlist.add(t);
        }
        return newlist; // Predicate là lọc phần tử, không tác động vào thay đổi phần tử
        // Thay đổi phần tử thì là mapper ( Function<T,R> )
//        List<T> newlist = new ArrayList<>(list);
//        newlist = newlist.stream().filter(predicate).toList();
//        return newlist;
    }

    public static <T> List<T> map(List<T> list, Function<T, T> mapper) {
        List<T> newlist = new ArrayList<>(list);
        newlist = newlist.stream().map(mapper).toList();
        return newlist;
//        for(int i=0; i<newlist.size(); i++){
//            newlist.set(i,mapper.apply(newlist.get(i)));
//        }
//        return newlist;
    }

    public static <T> boolean areListsEquivalent(List<T> firstlist, List<T> secondlist) {
        return new HashSet<T>(firstlist).equals(new HashSet<T>(secondlist));
//        for(T t : firstlist){
//            if(!secondlist.contains(t)) return false;
//        }
//        return true;
    }

    public static <T> T findMostFrequent(List<T> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("Error : list is empty!");
        Map<T, Integer> map = new HashMap<>();
        list.forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        Integer max = 0;
        T mostFrequent = null;
        for (Map.Entry<T, Integer> m : map.entrySet()) {
            if (max < m.getValue()) {
                max = m.getValue();
                mostFrequent = m.getKey();
            }
        }
        return mostFrequent;
    }

    public static <T> List<T> mergeListAndRemoveDuplicates(List<T> firstList, List<T> secondList) {
        if (firstList.isEmpty() || secondList.isEmpty()) throw new IllegalArgumentException("Error : list is empty!");
        Set<T> set = new LinkedHashSet<>(firstList);
        set.addAll(secondList);
        return new ArrayList<>(set);
    }


    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) return null;
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max.compareTo(arr[i]) < 0) max = arr[i];
        }
        return max;
    }

    public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        List<T> newList = new ArrayList<>(list1);
        newList.addAll(list2);
        return newList;
    }

    public static <T> boolean containsValue(List<T> list, T t) {
        return list.contains(t);
    }

    public static <T> void printElements(List<T> list) {
        for (T t : list) {
            System.out.print(t + " ");
        }
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String mostFrequentWord(String str) {
        Map<String, Integer> map = wordFrequency(str);
        int max = 0;
        String mostFrequency = "";
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
                mostFrequency = pair.getKey();
            }
        }
        return mostFrequency;
    }

    public static Map<String, Integer> wordFrequency(String str) {
        str = str.toLowerCase(Locale.ROOT);
        Map<String, Integer> map = new HashMap<>();
        String[] arr = str.split(" ");
        for (String s : arr) {
            if (s.isBlank()) continue;
            map.compute(s, (k, v) -> (v == null ? 0 : v) + 1);
        }
        return map;
    }

    public static long calculateDateBetween(String start, String end) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateStart = LocalDate.parse(correctDate(start), dateFormatter);
        LocalDate dateEnd = LocalDate.parse(correctDate(end), dateFormatter);
        return ChronoUnit.DAYS.between(dateStart, dateEnd);
    }

    public static String correctDate(String str) {
        return str.substring(0, 2) + "-" + str.substring(2, 4) + "-" + str.substring(4);
    }

    public static HashSet<Integer> findUnique(int[] arr) {
        HashSet<Integer> flags = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : arr) {
            flags.add(i);
        }
        for (Integer i : arr) {
            if (!set.add(i)) flags.remove(i);
        }
        return flags;
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static String longestSubstring(String s) {
        char[] charstr = s.toCharArray();
        char[] result = new char[s.length()];
        int from = 0, fcheck = 0;
        int to = 0;
        int max = 0, maxcheck = 0;

        for (int i = 0; i < charstr.length; i++) {
            if (i == charstr.length - 1) {
                to = i - 1;
                maxcheck = to - fcheck;
                if (max < maxcheck) {
                    from = fcheck;
                    max = maxcheck;
                }
            }
            if (checkDuplicate(result, charstr[i])) {
                to = i - 1;
                maxcheck = to - fcheck;
                if (max < maxcheck) {
                    from = fcheck;
                    max = maxcheck;
                }
                fcheck = i;
            }
            result[i] = charstr[i];
        }
        return new String(result, from, max + 1);
    }

    public static boolean checkDuplicate(char[] chars, char check) {
        for (char c : chars) {
            if (check == c) return true;
        }
        return false;
    }

    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        return str.equals(reverseString(str));
    }

    public static String reverseString(String str) {
        if (str == null || str.isBlank()) return "";
        int i = str.length() - 1;
        char[] result = new char[i + 1];
        for (char c : str.toCharArray()) {
            result[i--] = c;
            if (i == -1) break;
        }
        return new String(result);
    }
}
