package com.onpier.libraryservice.repository;

import com.onpier.libraryservice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * Fetches distinct members who have borrowed at least one book.
     *
     * @return List of {@link Member} with active borrowings.
     */
    @Query("SELECT DISTINCT m FROM Member m JOIN Borrowed b ON CONCAT(m.name, ',', m.firstName) = b.borrower")
    List<Member> findMembersWithBorrowedBooks();


    /**
     * Finds active members who currently have no borrowed books.
     *
     * @return List of active {@link Member} without borrowings.
     */
    @Query("SELECT m FROM Member m WHERE m.memberTill IS NULL AND m.name NOT IN (SELECT b.borrower FROM Borrowed b)")
    List<Member> findActiveMembersWithoutBorrowedBooks();
}
