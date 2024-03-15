package com.onpier.libraryservice.service;

import com.onpier.libraryservice.model.Member;
import com.onpier.libraryservice.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Find member with borrowed book")
    public void testFindMembersWithBorrowedBooks() {

        List<Member> mockedMemberList = getMockedMemberList();

        when(memberRepository.findMembersWithBorrowedBooks()).thenReturn(mockedMemberList);

        List<Member> result = memberService.findMembersWithBorrowedBooks();

        assertEquals(2, result.size(), "Should return all members who have borrowed books");
        verify(memberRepository, times(1)).findMembersWithBorrowedBooks();
    }


    @Test
    @DisplayName("Find active member without borrowed books")
    public void testFindActiveMembersWithoutBorrowedBooks() {
        Member member1 = new Member();
        List<Member> mockedMemberList = Collections.singletonList(member1);

        when(memberRepository.findActiveMembersWithoutBorrowedBooks()).thenReturn(mockedMemberList);

        List<Member> result = memberService.findActiveMembersWithoutBorrowedBooks();

        assertEquals(1, result.size(), "Should return all active members without borrowed books");
        verify(memberRepository, times(1)).findActiveMembersWithoutBorrowedBooks();
    }

    private static List<Member> getMockedMemberList() {
        Member member1 = new Member();
        member1.setName("MemberName");
        member1.setGender("F");
        member1.setMemberSince(new Date());
        member1.setMemberTill(new Date());
        Member member2 = new Member();
        member2.setName("MemberName_2");
        member2.setGender("M");
        member2.setMemberSince(new Date());
        member2.setMemberTill(new Date());
        List<Member> mockedMemberList = Arrays.asList(member1, member2);
        return mockedMemberList;
    }

}