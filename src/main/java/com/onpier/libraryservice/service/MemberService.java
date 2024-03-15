package com.onpier.libraryservice.service;

import com.onpier.libraryservice.model.Member;
import com.onpier.libraryservice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository userRepository
    ) {
        this.memberRepository = userRepository;
    }


    /**
     * Retrieves a list of all {@link Member} entities who have currently borrowed at least one book.
     * This method queries the underlying {@code MemberRepository} to find members based on their borrowing activity,
     *
     * @return A {@link List} of {@link Member} entities representing all members who have borrowed at least one book.
     * The list will be empty if no such members are found.
     */
    public List<Member> findMembersWithBorrowedBooks() {
        return memberRepository.findMembersWithBorrowedBooks();
    }

    /**
     * Retrieves a list of all active {@link Member} entities who have not currently borrowed any books.
     *
     * @return A {@link List} of {@link Member} entities representing active members without any current borrowings.
     * The list will be empty if no such members are found.
     */
    public List<Member> findActiveMembersWithoutBorrowedBooks() {
        return memberRepository.findActiveMembersWithoutBorrowedBooks();
    }

}
