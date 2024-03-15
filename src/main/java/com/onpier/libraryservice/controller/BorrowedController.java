package com.onpier.libraryservice.controller;

import com.onpier.libraryservice.model.Borrowed;
import com.onpier.libraryservice.service.BorrowedService;
import com.onpier.libraryservice.util.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */

@RestController
@RequestMapping("/api/v1/borrowed")
public class BorrowedController {
    private final BorrowedService borrowedService;

    public BorrowedController(BorrowedService borrowedService) {
        this.borrowedService = borrowedService;
    }

    Utils utils = new Utils();

    /**
     * Handles the GET request to retrieve all borrowings that occurred on a specified date.
     *
     * @param date The date of interest as a String in the format "yyyy-MM-dd" for which the borrowings are queried.
     * @return A {@link ResponseEntity} containing a list of {@link Borrowed} entities representing the borrowings on the given date.
     * If no borrowings are found for the specified date, returns a 404 Not Found status. Otherwise, returns a 200 OK status
     * with the list of borrowings.
     */
    @GetMapping("/members-borrowed-on")
    public ResponseEntity<List<Borrowed>> membersWhoBorrowedOn(@RequestParam String date) {
        Optional<LocalDate> optionalDate = utils.stringToDate(date);

        if (optionalDate.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        LocalDate realDate = optionalDate.get();
        List<Borrowed> borrowedList = borrowedService.findBorrowingsByDate(realDate);

        if (borrowedList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(borrowedList);
        }
    }
}
