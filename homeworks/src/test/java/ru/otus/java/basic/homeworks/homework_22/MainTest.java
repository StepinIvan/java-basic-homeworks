package ru.otus.java.basic.homeworks.homework_22;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

class MainTest {
    static int[] twoArray;
    static int[] oneArray;
    @BeforeAll
    public static void setUp() {
        twoArray = new int[] {2, 2, 2, 2};
        oneArray = new int[] {1, 1, 1, 1};
    }
    @ParameterizedTest
    @MethodSource("testData")
    public void arrayAfterLastOne(String inArray, String resultArray) {
        Assertions.assertEquals(inArray, resultArray);
    }

    @MethodSource
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.toString(new int[]{2, 2, 3}), Arrays.toString(Main.arrayAfterLastOne(new int[]{1, 2, 3, 4, 5, 1, 2, 2, 3}))),
                Arguments.of(Arrays.toString(new int[]{4, 5, 2, 2, 2, 3}), Arrays.toString(Main.arrayAfterLastOne(new int[]{1, 2, 1, 4, 5, 2, 2, 2, 3}))),
                Arguments.of(Arrays.toString(new int[]{2, 5, 4, 5, 2, 2, 2, 3}), Arrays.toString(Main.arrayAfterLastOne(new int[]{1, 2, 5, 4, 5, 2, 2, 2, 3})))
        );
    }
    @org.junit.jupiter.api.Test
    void arrayAfterLastOneFalse() {
        int[] result = Main.arrayAfterLastOne(new int[]{1, 2, 3, 4, 5, 1, 2, 2, 3});
        Assertions.assertFalse( Arrays.toString(result) == Arrays.toString(new int[]{1, 2, 2, 3}));
    }
    @org.junit.jupiter.api.Test
    void arrayAfterLastThrows() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.arrayAfterLastOne(twoArray);
        }, "Должно выброситься исключение RuntimeException при отсутствии единиц или двоек");
    }


    @org.junit.jupiter.api.Test
    void checkArrayFilling() {
        boolean result = Main.checkArrayFilling(new int[] {1,2,2,1});
        Assertions.assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    public void checkArrayFillingFalseOnes() {
        boolean result = Main.checkArrayFilling(oneArray);
        Assertions.assertFalse(result);
    }
    @org.junit.jupiter.api.Test
    public void checkArrayFillingFalseTwos() {
        boolean result = Main.checkArrayFilling(twoArray);
        Assertions.assertFalse(result);
    }
}