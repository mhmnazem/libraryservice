package com.onpier.libraryservice.controller;

import com.onpier.libraryservice.model.Borrowed;
import com.onpier.libraryservice.service.BorrowedService;
import com.onpier.libraryservice.util.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */
@WebMvcTest(BorrowedController.class)
class BorrowedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BorrowedService borrowedService;

    @MockBean
    private Utils utils;

    @Test
    @DisplayName("Members who borrowed on exist")
    public void whenMembersWhoBorrowedOnExist_thenReturnsStatus200() throws Exception {
        LocalDate testDate = LocalDate.of(2008, 5, 14);
        Borrowed borrowed = new Borrowed();
        List<Borrowed> borrowedList = Collections.singletonList(borrowed);

        given(utils.stringToDate(any(String.class))).willReturn(Optional.of(testDate));
        given(borrowedService.findBorrowingsByDate(testDate)).willReturn(borrowedList);

        mockMvc.perform(get("/api/v1/borrowed/members-borrowed-on?date=2008-05-14")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Members who borrowed on not exist")
    public void whenNoMembersWhoBorrowedOnExist_thenReturnsStatus404() throws Exception {
        LocalDate testDate = LocalDate.of(2008, 5, 14);

        given(utils.stringToDate(any(String.class))).willReturn(Optional.of(testDate));
        given(borrowedService.findBorrowingsByDate(testDate)).willReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/borrowed/members-borrowed-on?date=2008-05-14")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}