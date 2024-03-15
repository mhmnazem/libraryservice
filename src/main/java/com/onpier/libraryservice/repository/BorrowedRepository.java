package com.onpier.libraryservice.repository;

import com.onpier.libraryservice.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

    /**
     * Retrieves borrowings that occurred on a specific date.
     *
     * @param date The date to search for borrowings.
     * @return List of {@link Borrowed} instances for the specified date.
     */
    @Query("SELECT b FROM Borrowed b WHERE CAST(b.borrowed_from AS DATE) = :date")
    List<Borrowed> findBorrowingsByDate(@Param("date") LocalDate date);
}
