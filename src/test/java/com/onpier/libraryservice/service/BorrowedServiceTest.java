package com.onpier.libraryservice.service;

import com.onpier.libraryservice.model.Borrowed;
import com.onpier.libraryservice.repository.BorrowedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
class BorrowedServiceTest {

    @Mock
    private BorrowedRepository borrowedRepository;

    @InjectMocks
    private BorrowedService borrowedService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find borrowings by date method")
    void findBorrowingsByDateTest() {
        // Arrange
        LocalDate testDate = LocalDate.of(2024, 3, 15);


        List<Borrowed> expectedBorrowings = mockBorrowedData();

        when(borrowedRepository.findBorrowingsByDate(testDate)).thenReturn(expectedBorrowings);

        // Act
        List<Borrowed> actualBorrowings = borrowedService.findBorrowingsByDate(testDate);

        // Assert
        verify(borrowedRepository).findBorrowingsByDate(testDate);
        assertEquals(expectedBorrowings, actualBorrowings, "The returned borrowings should match the expected ones");
    }

    @Test
    @DisplayName("No record found")
    void findBorrowingsByDateTest_NoRecordsFound() {
        // Arrange
        LocalDate testDate = LocalDate.of(2024, 3, 16); // A date for which no records exist
        when(borrowedRepository.findBorrowingsByDate(testDate)).thenReturn(Collections.emptyList());

        // Act
        List<Borrowed> actualBorrowings = borrowedService.findBorrowingsByDate(testDate);

        // Assert
        verify(borrowedRepository).findBorrowingsByDate(testDate);
        assertTrue(actualBorrowings.isEmpty(), "The returned borrowings list should be empty");
    }

    @Test
    @DisplayName("Database error")
    void findBorrowingsByDateTest_ThrowsException() {
        // Arrange
        LocalDate testDate = LocalDate.of(2024, 3, 15);
        RuntimeException repositoryException = new RuntimeException("Database error");

        when(borrowedRepository.findBorrowingsByDate(testDate)).thenThrow(repositoryException);

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            borrowedService.findBorrowingsByDate(testDate);
        }, "Expected findBorrowingsByDate to , but it didn't");

        assertTrue(exception.getMessage().contains("Database error"), "message should contain 'Database error'");
    }

    private static List<Borrowed> mockBorrowedData() {
        Borrowed borrowed1 = new Borrowed();
        borrowed1.setBook("test");
        borrowed1.setBorrower("nameTest");
        borrowed1.setBorrowed_to(new Date());
        borrowed1.setBorrowed_from(new Date());
        Borrowed borrowed2 = new Borrowed();
        borrowed2.setBook("Book test2");
        borrowed2.setBorrower("nameTest2");
        borrowed2.setBorrowed_to(new Date());
        borrowed1.setBorrowed_from(new Date());
        List<Borrowed> expectedBorrowings = Arrays.asList(borrowed1, borrowed2);
        return expectedBorrowings;
    }


}