//package org.example.assignment.E1;
//
//import org.example.assignment.NiceBro;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class NiceBroTest {
//    public NiceBro mai = new NiceBro();
//
/// /    @BeforeEach
/// /    void setup() {
/// /        mai = new NiceBro();
/// /    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'0x2A',true",
//            "'0X2B',false",
//            "'#FFFFFF',true",
//            "'#fF1244',false",
//    })
//    void checkValidHexCodeTest(String str, boolean expected) {
//        assertEquals(expected, mai.checkValidHexCode(str));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'maiden','nediam'",
//            "'ok','ko'",
//            "'reverse','esrever'"
//    })
//    void reverseWordTest(String str, String expected) {
//        assertEquals(expected, mai.reverseWord(str));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'3 + 5 = 8',true",
//            "'2 * (3 + 4) / (5 - 2)',true",
//            "'cos(',false"
//    })
//    void isMathExpressionTest(String str, boolean expected) {
//        assertEquals(expected, mai.isMathExpression(str));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'p3798*(*q',true",
//            "'p34809fdsifjq',true",
//            "'pr09r0ur',false",
//    })
//    void startWithPAndEndWithQTest(String str, boolean expected) {
//        assertEquals(expected, mai.startWithPAndEndWithQ(str));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'Javaisfun',true",
//            "'Nicebrother',true",
//            "'nicebrother',false",
//    })
//    void oneUppercaseAndManyLowercaseFollowedTest(String str, boolean expected) {
//        assertEquals(expected, mai.oneUppercaseAndManyLowercaseFollowed(str));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'java_is_fun',true",
//            "'ok_bro_Ther',false",
//            "'ok_brother',true"
//    })
//    void lowercaseLetterJoinedTest(String str, boolean expected) {
//        assertEquals(expected, mai.lowercaseLetterJoined(str));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "'pqqqqqqq',true",
//            "'p0000000',true",
//            "'p000qqq',false"
//    })
//    void pFollowedByZeroOrQTest(String str, boolean expected) {
//        assertEquals(expected, mai.pFollowedByZeroOrQ(str));
//    }
//
//
//    @ParameterizedTest
//    @CsvSource({
//            "'Nguyen Trong Hoang',true",
//            "'Nguyen Hoang.',false",
//            "'*Long Nguyen%',false"
//    })
//    void containsCharacterOnlyTest(String str, boolean expected) {
//        assertEquals(expected, mai.containsCharactersOnly(str));
//    }
//
//}
