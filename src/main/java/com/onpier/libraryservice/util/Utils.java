package com.onpier.libraryservice.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
public class Utils {

    /**
     * Converts a date string to a {@link LocalDate} object.
     *
     * @param dateString The date string in "yyyy-MM-dd" format.
     * @return The corresponding {@link LocalDate}, or {@code null} if parsing fails.
     */


    //todo change method type because of null pointer risk
    public LocalDate StringToDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}