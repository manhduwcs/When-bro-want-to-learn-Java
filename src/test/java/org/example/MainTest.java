//package org.example;
//
//import org.example.origin.Main;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MainTest {
/// /    private Main maint;
//
//    //    @BeforeEach
/// /    void setup() {
/// /
/// /    }
//    @ParameterizedTest
//    @CsvSource({
//            "'abcabcbb',abc",
//            "'bbbbb',b",
//            "'pwwkew',wke",
//            "'',''", // kí tự trống, kí tự trống (not null)
//
//    })
//    void longestSubstringTest(String str, String expected) {
//        assertEquals(expected, Main.longestSubstring(str));
//    }
//
//
//    @ParameterizedTest
//    @CsvSource({
//            "madam,true",
//            "hello,false",
//            ",false",
//            "'',true",
//            "a,true",
//    })
//    void isPalindromeTest(String str, boolean expected) {
//        assertEquals(expected, Main.isPalindrome(str));
//    }
//
//
//    @ParameterizedTest
//    @CsvSource({
//            "12102024,12-10-2024",
//            "11012005,11-01-2005",
//            "03072003,03-07-2003",
//    })
//    void correctDateTest(String date, String expected) {
//        assertEquals(expected, Main.correctDate(date));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'01012024,05012024',4",
//            "'15082022,15082023',365",
//            "'10102023,10102023',0",
//            "'01012000,01012100',36525"
//    })
//    void calculateDateBetweenTest(String str, long expected) {
//        String[] test = str.split(",");
//        assertEquals(expected, Main.calculateDateBetween(test[0], test[1]));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'2,3,5,4,5,3,2',4",
//            "'1,1,2,2,3,4,4',3",
//            "'0',0",
//            "'7,9,7,3,9',3"
//    })
//    void findUniqueTest(String arr, int expected) {
//        int[] nums = Arrays.stream(arr.split(","))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        HashSet<Integer> set = new HashSet<>();
//        set.add(expected);
//        assertEquals(set, Main.findUnique(nums));
//    }
//}
