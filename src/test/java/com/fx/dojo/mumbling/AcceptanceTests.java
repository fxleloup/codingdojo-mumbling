package com.fx.dojo.mumbling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AcceptanceTests {

    @ParameterizedTest
    @MethodSource("givenParameterAndExpectedResult")
    void givenParameterWhenAccumShouldOutputExpectedResult(String givenParameter, String expectedResult) {
        // When
        String actualResult = Mumbling.accum(givenParameter);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenParameterAndExpectedResult() {
        return Stream.of(
                arguments(null, ""),
                arguments("", ""),
                arguments("a", "A"),
                arguments("B", "B"),
                arguments("ab", "A-Bb"),
                arguments("abcd", "A-Bb-Ccc-Dddd"),
                arguments("RqaEzty", "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"),
                arguments("cwAt", "C-Ww-Aaa-Tttt")
        );
    }
}
