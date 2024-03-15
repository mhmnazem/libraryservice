package com.onpier.libraryservice.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
public class Utils {


    /**
     * Converts a string representation of a date to a {@link LocalDate}.
     *
     * @param dateString The date string in "yyyy-MM-dd" format.
     * @return An {@link Optional} containing the parsed {@link LocalDate} if successful, or an empty {@link Optional} if the input is null or cannot be parsed.
     */
    public Optional<LocalDate> stringToDate(String dateString) {
        if (dateString == null) {
            return Optional.empty();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            return Optional.of(date);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return Optional.empty();
        }
    }
}