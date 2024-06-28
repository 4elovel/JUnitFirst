package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtil.isPalindrome("oko"));
        assertTrue(StringUtil.isPalindrome("A man a plan a canal Panama"));
        assertFalse(StringUtil.isPalindrome("Hello World"));
    }

    @Test
    public void testCountVowels() {
        assertEquals(3, StringUtil.countVowels("Hello World"));
    }

    @Test
    public void testCountConsonants() {
        assertEquals(7, StringUtil.countConsonants("Hello World"));
    }

    @Test
    public void testCountWordOccurrences() {
        assertEquals(3, StringUtil.countWordOccurrences("Hello World Hello hello helo", "Hello"));
    }
}
