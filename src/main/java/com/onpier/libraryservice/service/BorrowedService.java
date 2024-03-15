package com.onpier.libraryservice.service;

import com.onpier.libraryservice.model.Borrowed;
import com.onpier.libraryservice.repository.BorrowedRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
@Service
public class BorrowedService {

    private final BorrowedRepository borrowedRepository;

    public BorrowedService(BorrowedRepository borrowedRepository) {
        this.borrowedRepository = borrowedRepository;
    }

    /**
     * Retrieves a list of {@link Borrowed} entities for a specific date.
     * This method will return all borrowings that occurred on the given date.
     *
     * @param date The date for which to find borrowings.
     * @return A {@link List} of {@link Borrowed} entities that were borrowed on the specified
     * date. This list may be empty if no borrowings match the date criteria.
     */
    public List<Borrowed> findBorrowingsByDate(LocalDate date) {
        return borrowedRepository.findBorrowingsByDate(date);
    }
}
