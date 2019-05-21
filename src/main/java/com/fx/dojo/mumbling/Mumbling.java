package com.fx.dojo.mumbling;

import java.util.concurrent.atomic.AtomicInteger;

public class Mumbling {
    public static String accum(String givenParameter) {
        if (givenParameter == null || givenParameter.isEmpty()) {
            return "";
        }
        final int lastIndex = givenParameter.length() -1;
        final AtomicInteger index = new AtomicInteger(0);
        return givenParameter.chars()
                .mapToObj(letter -> (char) letter)
                .map(letter -> letter.toString())
                .map(letter -> letter.toUpperCase())
                .map(letter -> repeat(letter, index.get()))
                .map(letter -> appendHyphen(letter, lastIndex, index.getAndIncrement()))
                .reduce((s1, s2) -> s1 + s2)
                .get();
    }

    static String repeat(String letter, int repetitions) {
        if (letter == null || letter.isEmpty()) {
            return "";
        }
        StringBuilder letterRepeated = new StringBuilder(letter.toUpperCase());
        String letterLowercase = letter.toLowerCase();
        while(repetitions > 0){
            letterRepeated.append(letterLowercase);
            repetitions--;
        }
        return letterRepeated.toString();
    }

    static String appendHyphen(String word, int lastIndex, int index) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        boolean isLastWord = isLastIndex(lastIndex, index);
        return word + (isLastWord ? "" : "-");
    }

    static boolean isLastIndex(int lastIndex, int indexInGivenParameter){
        return lastIndex == indexInGivenParameter;
    }
}
