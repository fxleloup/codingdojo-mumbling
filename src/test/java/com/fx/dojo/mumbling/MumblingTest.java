package com.fx.dojo.mumbling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MumblingTest {

    @ParameterizedTest
    @MethodSource("givenLetterAndGivenRepetitionsAndExpectedResult")
    void givenLetterAndGivenRepetitionsWhenRepeatShouldOutputExpectedResult(String givenLetter, int givenRepetitions, String expectedResult) {
        // When
        String actualResult = Mumbling.repeat(givenLetter, givenRepetitions);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenLetterAndGivenRepetitionsAndExpectedResult() {
        return Stream.of(
                arguments(null, 2, ""),
                arguments("", 2, ""),
                arguments("a", 0, "A"),
                arguments("B", 0, "B"),
                arguments("a", 1, "Aa"),
                arguments("a", 2, "Aaa")
        );
    }

    @ParameterizedTest
    @MethodSource("givenWordAndLastIndexAndIndexAndExpectedResult")
    void givenParameterWhenAccumShouldOutputExpectedResult(
            String givenWord,
            int lastIndex,
            int index,
            String expectedResult) {
        // When
        String actualResult = Mumbling.appendHyphen(givenWord, lastIndex, index);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenWordAndLastIndexAndIndexAndExpectedResult() {
        return Stream.of(
                arguments(null, 0, 0, ""),
                arguments("", 0, 0, ""),
                arguments("coucou", 0, 0, "coucou"),
                arguments("coucou", 1, 0, "coucou-"),
                arguments("coucou", 2, 0, "coucou-"),
                arguments("coucou", 1, 1, "coucou"),
                arguments("coucou", 2, 1, "coucou-")
        );
    }
}
