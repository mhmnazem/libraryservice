package com.onpier.libraryservice.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
class UtilsTest {
    Utils utils = new Utils();

    @Test
    @DisplayName("Test with Valid Date")
    public void testStringToDateWithValidDate() {
        String validDateString = "2024-03-14";
        assertFalse(utils.stringToDate(validDateString).isEmpty(),
                "The method should not return an empty Optional for a valid date string.");
    }

    @Test
    @DisplayName("Test with Invalid Date")
    public void testStringToDateWithInvalidDate() {
        String invalidDateString = "test";
        assertTrue(utils.stringToDate(invalidDateString).isEmpty(),
                "The method should return an empty Optional for an invalid date string.");
    }

    @Test
    @DisplayName("Test when input is null")
    public void testStringToDateWithNull() {
        assertTrue(utils.stringToDate(null).isEmpty(),
                "The method should return an empty Optional when the input is null.");
    }

}