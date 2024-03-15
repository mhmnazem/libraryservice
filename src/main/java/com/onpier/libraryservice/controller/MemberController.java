package com.onpier.libraryservice.controller;

import com.onpier.libraryservice.model.Member;
import com.onpier.libraryservice.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService userService) {
        this.memberService = userService;
    }

    /**
     * Handles the GET request to retrieve all members who have currently borrowed at least one book.
     *
     * @return A {@link ResponseEntity} containing a list of {@link Member} entities. Returns a 404 Not Found status
     * if no members with borrowed books are found, otherwise returns a 200 OK status with the list of members.
     */
    @GetMapping("/borrowed-Books")
    public ResponseEntity<List<Member>> membersWithBorrowedBooks() {
        ResponseEntity<List<Member>> responseEntity;
        List<Member> memberList = memberService.findMembersWithBorrowedBooks();
        responseEntity = memberList.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(memberList);
        return responseEntity;
    }

    /**
     * Handles the GET request to retrieve all active members who have not currently borrowed any books.
     * "Active" members are defined as those whose membership has not been terminated.
     *
     * @return A {@link ResponseEntity} containing a list of active {@link Member} entities without current borrowings.
     * If no such members are found, returns a 404 Not Found status. Otherwise, returns a 200 OK status with the list of members.
     */
    @GetMapping("/non-terminated")
    public ResponseEntity<List<Member>> activeMembersWithoutBorrowedBook() {
        ResponseEntity<List<Member>> responseEntity;
        List<Member> memberList = memberService.findActiveMembersWithoutBorrowedBooks();
        responseEntity = memberList.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(memberList);
        return responseEntity;
    }


}

