package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import com.example.sorting_algorithm_education_platform.service.SelectSortService;
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
@WebMvcTest(SelectSortController.class)
class SelectSortControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SelectSortService selectSortService;

    @Test
    public void testFindSortById() throws Exception{
        int selectId = 1;
        SelectSort mockSelectSort = new SelectSort();
        mockSelectSort.setSelectId(1);
        mockSelectSort.setExchange(0);
        mockSelectSort.setMinPos(0);
        mockSelectSort.setCurPos(0);
        mockSelectSort.setCurrList("1, 6, 5, 3");
        mockSelectSort.setPracticeId(1);
        mockSelectSort.setProcessNum(0);
        mockSelectSort.setUserId(1);
        mockSelectSort.setTurn(0);
        when(selectSortService.getBySelectId(1)).thenReturn(mockSelectSort);
        ResultActions perform=mockMvc.perform(post("/select-sort/find").param("selectId", "1").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(selectSortService).getBySelectId(selectId);
    }

    @Test
    public void testFindNextStep() throws Exception{
        int practiceId = 1;
        int processNum = 0;
        SelectSort mockSelectSort = new SelectSort();
        mockSelectSort.setSelectId(1);
        mockSelectSort.setExchange(0);
        mockSelectSort.setMinPos(0);
        mockSelectSort.setCurPos(0);
        mockSelectSort.setCurrList("1, 6, 5, 3");
        mockSelectSort.setPracticeId(1);
        mockSelectSort.setProcessNum(0);
        mockSelectSort.setUserId(1);
        mockSelectSort.setTurn(0);

        SelectSort mockSelectSort2 = new SelectSort();
        mockSelectSort2.setSelectId(2);
        mockSelectSort2.setExchange(0);
        mockSelectSort2.setMinPos(0);
        mockSelectSort2.setCurPos(0);
        mockSelectSort2.setCurrList("1, 6, 5, 3");
        mockSelectSort2.setPracticeId(1);
        mockSelectSort2.setProcessNum(1);
        mockSelectSort2.setUserId(1);
        mockSelectSort2.setTurn(1);

        when(selectSortService.getNextStep(1, 0)).thenReturn(mockSelectSort2);
        ResultActions perform=mockMvc.perform(post("/select-sort/nextStep").param("practiceId", "1").param("processNum", "0").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(selectSortService).getNextStep(practiceId, processNum);
    }

    @Test
    public void testFindCurrList() throws Exception{
        int userId = 1;
        int practiceId = 1;
        int processNum = 0;
        SelectSort mockSelectSort = new SelectSort();
        mockSelectSort.setSelectId(1);
        mockSelectSort.setExchange(0);
        mockSelectSort.setMinPos(0);
        mockSelectSort.setCurPos(0);
        mockSelectSort.setCurrList("1, 6, 5, 3");
        mockSelectSort.setPracticeId(1);
        mockSelectSort.setProcessNum(0);
        mockSelectSort.setUserId(1);
        mockSelectSort.setTurn(0);

        when(selectSortService.getCurrList( practiceId, processNum)).thenReturn(mockSelectSort.getCurrList());
        ResultActions perform=mockMvc.perform(post("/select-sort/currList").param("userId", "1").param("practiceId", "1").param("processNum", "0").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(selectSortService).getCurrList(practiceId, processNum);
    }

    @Test
    public void testFindSolution() throws Exception{
        int userId = 2;
        int practiceId = 3;
        SelectSort mockSelectSort1 = new SelectSort();
        mockSelectSort1.setSelectId(1);
        mockSelectSort1.setExchange(0);
        mockSelectSort1.setMinPos(0);
        mockSelectSort1.setCurPos(0);
        mockSelectSort1.setCurrList("1, 6, 5, 3");
        mockSelectSort1.setPracticeId(1);
        mockSelectSort1.setProcessNum(0);
        mockSelectSort1.setUserId(1);
        mockSelectSort1.setTurn(0);

        SelectSort mockSelectSort2 = new SelectSort();
        mockSelectSort2.setSelectId(2);
        mockSelectSort2.setExchange(0);
        mockSelectSort2.setMinPos(0);
        mockSelectSort2.setCurPos(0);
        mockSelectSort2.setCurrList("1, 6, 5, 3");
        mockSelectSort2.setPracticeId(1);
        mockSelectSort2.setProcessNum(1);
        mockSelectSort2.setUserId(1);
        mockSelectSort2.setTurn(1);

        List<SelectSort> mockSelectSortList = new ArrayList<>();
        mockSelectSortList.add(mockSelectSort1);
        mockSelectSortList.add(mockSelectSort2);

        when(selectSortService.getSolution(practiceId)).thenReturn(mockSelectSortList);
        ResultActions perform=mockMvc.perform(post("/select-sort/solution").param("userId", "2").param("practiceId", "3").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(selectSortService).getSolution(practiceId);
    }

}
