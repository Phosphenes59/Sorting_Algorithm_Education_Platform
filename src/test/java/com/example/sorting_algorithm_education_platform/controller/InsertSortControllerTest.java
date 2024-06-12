package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.service.InsertSortService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InsertSortController.class)
class InsertSortControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InsertSortService insertSortService;

    @Test
    public void testFindSortById() throws Exception{
        int insertId = 1;
        InsertSort mockInsertSort = new InsertSort();
        mockInsertSort.setInsertId(1);
        mockInsertSort.setOrderPos(0);
        mockInsertSort.setPivot(1);
        mockInsertSort.setSortedList("");
        mockInsertSort.setUnsortedList("1, 6, 5, 3");
        mockInsertSort.setCurrList("1, 6, 5, 3");
        mockInsertSort.setPracticeId(1);
        mockInsertSort.setProcessNum(0);
        mockInsertSort.setUserId(1);
        mockInsertSort.setTurn(0);
        when(insertSortService.getByInsertId(1)).thenReturn(mockInsertSort);
        ResultActions perform=mockMvc.perform(post("/insert-sort/find").param("insertId", "1").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(insertSortService).getByInsertId(insertId);
    }

    @Test
    public void testFindNextStep() throws Exception{
        int practiceId = 1;
        int processNum = 0;
        InsertSort mockInsertSort = new InsertSort();
        mockInsertSort.setInsertId(1);
        mockInsertSort.setOrderPos(0);
        mockInsertSort.setPivot(1);
        mockInsertSort.setSortedList("");
        mockInsertSort.setUnsortedList("1, 6, 5, 3");
        mockInsertSort.setCurrList("1, 6, 5, 3");
        mockInsertSort.setPracticeId(1);
        mockInsertSort.setProcessNum(0);
        mockInsertSort.setUserId(1);
        mockInsertSort.setTurn(0);

        InsertSort mockInsertSort2 = new InsertSort();
        mockInsertSort2.setInsertId(2);
        mockInsertSort2.setOrderPos(0);
        mockInsertSort2.setPivot(6);
        mockInsertSort2.setSortedList("1");
        mockInsertSort2.setUnsortedList("6, 5, 3");
        mockInsertSort2.setCurrList("1, 6, 5, 3");
        mockInsertSort2.setPracticeId(1);
        mockInsertSort2.setProcessNum(1);
        mockInsertSort2.setUserId(1);
        mockInsertSort2.setTurn(1);

        when(insertSortService.getNextStep(1, 0)).thenReturn(mockInsertSort2);
        ResultActions perform=mockMvc.perform(post("/insert-sort/nextStep").param("practiceId", "1").param("processNum", "0").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(insertSortService).getNextStep(practiceId, processNum);
    }

    @Test
    public void testFindCurrList() throws Exception{
        int userId = 1;
        int practiceId = 1;
        int processNum = 0;
        InsertSort mockInsertSort = new InsertSort();
        mockInsertSort.setInsertId(1);
        mockInsertSort.setOrderPos(0);
        mockInsertSort.setPivot(1);
        mockInsertSort.setSortedList("");
        mockInsertSort.setUnsortedList("1, 6, 5, 3");
        mockInsertSort.setCurrList("1, 6, 5, 3");
        mockInsertSort.setPracticeId(1);
        mockInsertSort.setProcessNum(0);
        mockInsertSort.setUserId(1);
        mockInsertSort.setTurn(0);

        when(insertSortService.getCurrList(practiceId, processNum)).thenReturn(mockInsertSort.getCurrList());
        ResultActions perform=mockMvc.perform(post("/insert-sort/currList").param("userId", "1").param("practiceId", "1").param("processNum", "0").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(insertSortService).getCurrList(practiceId, processNum);
    }

    @Test
    public void testFindSolution() throws Exception{
        int userId = 2;
        int practiceId = 3;
        InsertSort mockInsertSort1 = new InsertSort();
        mockInsertSort1.setInsertId(1);
        mockInsertSort1.setOrderPos(0);
        mockInsertSort1.setPivot(1);
        mockInsertSort1.setSortedList("");
        mockInsertSort1.setUnsortedList("1, 6, 5, 3");
        mockInsertSort1.setCurrList("1, 6, 5, 3");
        mockInsertSort1.setPracticeId(1);
        mockInsertSort1.setProcessNum(0);
        mockInsertSort1.setUserId(1);
        mockInsertSort1.setTurn(0);

        InsertSort mockInsertSort2 = new InsertSort();
        mockInsertSort2.setInsertId(2);
        mockInsertSort2.setOrderPos(0);
        mockInsertSort2.setPivot(6);
        mockInsertSort2.setSortedList("1");
        mockInsertSort2.setUnsortedList("6, 5, 3");
        mockInsertSort2.setCurrList("1, 6, 5, 3");
        mockInsertSort2.setPracticeId(1);
        mockInsertSort2.setProcessNum(1);
        mockInsertSort2.setUserId(1);
        mockInsertSort2.setTurn(1);

        List<InsertSort> mockInsertSortList = new ArrayList<>();
        mockInsertSortList.add(mockInsertSort1);
        mockInsertSortList.add(mockInsertSort2);

        when(insertSortService.getSolution(practiceId)).thenReturn(mockInsertSortList);
        ResultActions perform=mockMvc.perform(post("/insert-sort/solution").param("userId", "2").param("practiceId", "3").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(insertSortService).getSolution(practiceId);
    }

}
