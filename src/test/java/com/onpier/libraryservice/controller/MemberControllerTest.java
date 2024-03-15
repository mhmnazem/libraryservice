package com.onpier.libraryservice.controller;

import com.onpier.libraryservice.model.Member;
import com.onpier.libraryservice.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
@WebMvcTest(MemberController.class)
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("Members with borrowed books is exist")
    public void whenMembersWithBorrowedBooksExist_thenReturnsStatus200() throws Exception {
        Member member = new Member();
        List<Member> members = Collections.singletonList(member);

        given(memberService.findMembersWithBorrowedBooks()).willReturn(members);

        mockMvc.perform(get("/api/v1/member/borrowed-Books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    @DisplayName("Members with borrowed books is not exist")
    public void whenNoMembersWithBorrowedBooks_thenReturnsStatus404() throws Exception {
        given(memberService.findMembersWithBorrowedBooks()).willReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/member/borrowed-Books"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Active members without borrowed books exist")
    public void whenActiveMembersWithoutBorrowedBooksExist_thenReturnsStatus200() throws Exception {
        Member member = new Member();
        List<Member> members = Collections.singletonList(member);

        given(memberService.findActiveMembersWithoutBorrowedBooks()).willReturn(members);

        mockMvc.perform(get("/api/v1/member/non-terminated"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    @DisplayName("Active members without borrowed books is not exist")
    public void whenNoActiveMembersWithoutBorrowedBooks_thenReturnsStatus404() throws Exception {
        given(memberService.findActiveMembersWithoutBorrowedBooks()).willReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/member/non-terminated"))
                .andExpect(status().isNotFound());
    }
}
