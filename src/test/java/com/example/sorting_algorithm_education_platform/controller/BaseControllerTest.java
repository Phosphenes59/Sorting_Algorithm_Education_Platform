package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.Problems;
import com.example.sorting_algorithm_education_platform.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BaseController.class)
class BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BubbleSortService bubbleSortService;

    @MockBean
    private InsertSortService insertSortService;

    @MockBean
    private SelectSortService selectSortService;

    @MockBean
    private ProblemsService problemsService;

    @MockBean
    private UserService userService;

    @Test
    void findAll() throws Exception{
        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setProblemId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        Problems problems1 = new Problems();
        problems.setUserId(2);
        problems.setProblemId(2);
        problems.setPracticeId(2);
        problems.setCurrList("5, 8, 6, 2");

        List<Problems> problemsList = new ArrayList<>();
        problemsList.add(problems);
        problemsList.add(problems1);

        when(problemsService.findAll(2)).thenReturn(problemsList);
        ResultActions perform=mockMvc.perform(post("/sort/all").param("userId", "2").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(problemsService).findAll(2);
    }

    @Test
    void findMyPractice() throws Exception{
        int userId = 2;
        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setProblemId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        Problems problems1 = new Problems();
        problems.setUserId(2);
        problems.setProblemId(2);
        problems.setPracticeId(2);
        problems.setCurrList("5, 8, 6, 2");

        List<Problems> problemsList = new ArrayList<>();
        problemsList.add(problems1);

        when(problemsService.findMy(2)).thenReturn(problemsList);
        ResultActions perform=mockMvc.perform(post("/sort/myPractice").param("userId", "2").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(problemsService).findMy(userId);
    }

    @Test
    void add() throws Exception{
        int userId = 1;
        int practiceId = 1;
        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        when(userService.userIdExists(1)).thenReturn(true);
        when(bubbleSortService.countByPracticeId(1)).thenReturn(0);

        ResultActions perform=mockMvc.perform(post("/sort/add")
                .param("sortList", "1, 6, 5, 3")
                .param("practiceId", "1")
                .param("userId", "1")
                .header("token", "token"));
        perform.andExpect(status().isOk());
        verify(userService).userIdExists(userId);
        verify(bubbleSortService).countByPracticeId(practiceId);
        verify(bubbleSortService, times(7)).insertSort(any());
        verify(insertSortService, times(8)).insertSort(any());
        verify(selectSortService, times(10)).insertSort(any());
        verify(problemsService).insertProblems(problems);

    }

    @Test
    void delete() throws Exception{
        int userId = 1;
        int practiceId = 1;

        when(userService.userIdExists(1)).thenReturn(true);
        when(bubbleSortService.countByPracticeId(1)).thenReturn(7);

        ResultActions perform=mockMvc.perform(post("/sort/delete")
                .param("practiceId", "1")
                .param("userId", "1")
                .header("token", "token"));
        perform.andExpect(status().isOk());
        verify(userService).userIdExists(userId);
        verify(bubbleSortService).countByPracticeId(practiceId);
        verify(bubbleSortService).deleteSort(practiceId, userId);
        verify(insertSortService).deleteSort(practiceId, userId);
        verify(selectSortService).deleteSort(practiceId, userId);
        verify(problemsService).deleteProblems(practiceId, userId);
    }

    @Test
    void modify() throws Exception{
        int userId = 1;
        int practiceId = 1;

        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        when(userService.userIdExists(1)).thenReturn(true);
        when(bubbleSortService.countByPracticeId(1)).thenReturn(7);

        ResultActions perform=mockMvc.perform(post("/sort/modify")
                .param("sortList", "1, 6, 5, 3")
                .param("practiceId", "1")
                .param("userId", "1")
                .header("token", "token"));
        perform.andExpect(status().isOk());
        verify(userService).userIdExists(userId);
        verify(bubbleSortService).countByPracticeId(practiceId);
        verify(bubbleSortService).deleteSort(practiceId, userId);
        verify(bubbleSortService, times(7)).insertSort(any());
        verify(insertSortService).deleteSort(practiceId, userId);
        verify(insertSortService, times(8)).insertSort(any());
        verify(selectSortService).deleteSort(practiceId, userId);
        verify(selectSortService, times(10)).insertSort(any());
        verify(problemsService).deleteProblems(practiceId, userId);
        verify(problemsService).insertProblems(problems);
    }
}
