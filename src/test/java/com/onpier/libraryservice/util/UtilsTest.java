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
    @DisplayName("Test with valid date")
    public void testStringToDateWithValidDate() {
        String validDateString = "2024-03-14";
        LocalDate expectedDate = LocalDate.of(2024, 3, 14);
        assertEquals(expectedDate, utils.StringToDate(validDateString),
                "The method should correctly parse a valid date string.");
    }

    @Test
    @DisplayName("Test with Invalid Date")
    public void testStringToDateWithInvalidDate() {
        String invalidDateString = "test";
        assertNull(utils.StringToDate(invalidDateString),
                "The method should return null for an invalid date string.");
    }

    @Test
    @DisplayName("Test when input is null")
    public void testStringToDateWithNull() {
        assertNull(utils.StringToDate(null),
                "The method should return null when the input is null.");
    }
}