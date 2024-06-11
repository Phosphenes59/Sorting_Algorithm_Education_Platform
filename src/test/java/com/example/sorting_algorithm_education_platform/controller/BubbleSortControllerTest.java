package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.service.BubbleSortService;
import com.example.sorting_algorithm_education_platform.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BubbleSortController.class)
public class BubbleSortControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BubbleSortService bubbleSortService;

    @Test
    public void testFindSortById() throws Exception{
        int bubbleId = 1;
        BubbleSort mockBubbleSort = new BubbleSort();
        mockBubbleSort.setBubbleId(1);
        mockBubbleSort.setExchange(0);
        mockBubbleSort.setPrePos(0);
        mockBubbleSort.setPostPos(0);
        mockBubbleSort.setCurrList("1, 6, 5, 3");
        mockBubbleSort.setPracticeId(1);
        mockBubbleSort.setProcessNum(0);
        mockBubbleSort.setUserId(1);
        mockBubbleSort.setTurn(0);
        when(bubbleSortService.getByBubbleId(1)).thenReturn(mockBubbleSort);
        ResultActions perform=mockMvc.perform(post("/bubble-sort/find").param("bubbleId", "1").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(bubbleSortService).getByBubbleId(bubbleId);
    }

    @Test
    public void testFindNextStep() throws Exception{
        int practiceId = 1;
        int processNum = 0;
        BubbleSort mockBubbleSort1 = new BubbleSort();
        mockBubbleSort1.setBubbleId(1);
        mockBubbleSort1.setExchange(0);
        mockBubbleSort1.setPrePos(0);
        mockBubbleSort1.setPostPos(0);
        mockBubbleSort1.setCurrList("1, 6, 5, 3");
        mockBubbleSort1.setPracticeId(1);
        mockBubbleSort1.setProcessNum(0);
        mockBubbleSort1.setUserId(1);
        mockBubbleSort1.setTurn(0);

        BubbleSort mockBubbleSort2 = new BubbleSort();
        mockBubbleSort2.setBubbleId(2);
        mockBubbleSort2.setExchange(0);
        mockBubbleSort2.setPrePos(0);
        mockBubbleSort2.setPostPos(0);
        mockBubbleSort2.setCurrList("1, 6, 5, 3");
        mockBubbleSort2.setPracticeId(1);
        mockBubbleSort2.setProcessNum(1);
        mockBubbleSort2.setUserId(1);
        mockBubbleSort2.setTurn(1);

        when(bubbleSortService.getNextStep(1, 0)).thenReturn(mockBubbleSort2);
        ResultActions perform=mockMvc.perform(post("/bubble-sort/nextStep").param("practiceId", "1").param("processNum", "0").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(bubbleSortService).getNextStep(practiceId, processNum);
    }

    @Test
    public void testFindCurrList() throws Exception{
        int userId = 1;
        int practiceId = 1;
        int processNum = 0;
        BubbleSort mockBubbleSort = new BubbleSort();
        mockBubbleSort.setBubbleId(1);
        mockBubbleSort.setExchange(0);
        mockBubbleSort.setPrePos(0);
        mockBubbleSort.setPostPos(0);
        mockBubbleSort.setCurrList("1, 6, 5, 3");
        mockBubbleSort.setPracticeId(1);
        mockBubbleSort.setProcessNum(0);
        mockBubbleSort.setUserId(1);
        mockBubbleSort.setTurn(0);

        when(bubbleSortService.getCurrList(practiceId, processNum)).thenReturn(mockBubbleSort.getCurrList());
        ResultActions perform=mockMvc.perform(post("/bubble-sort/currList").param("userId", "1").param("practiceId", "1").param("processNum", "0").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(bubbleSortService).getCurrList(practiceId, processNum);
    }

    @Test
    public void testFindSolution() throws Exception{
        int userId = 2;
        int practiceId = 3;
        BubbleSort mockBubbleSort1 = new BubbleSort();
        mockBubbleSort1.setBubbleId(1);
        mockBubbleSort1.setExchange(0);
        mockBubbleSort1.setPrePos(0);
        mockBubbleSort1.setPostPos(0);
        mockBubbleSort1.setCurrList("5, 1, 3");
        mockBubbleSort1.setPracticeId(3);
        mockBubbleSort1.setProcessNum(0);
        mockBubbleSort1.setUserId(2);
        mockBubbleSort1.setTurn(0);

        BubbleSort mockBubbleSort2 = new BubbleSort();
        mockBubbleSort2.setBubbleId(2);
        mockBubbleSort2.setExchange(1);
        mockBubbleSort2.setPrePos(0);
        mockBubbleSort2.setPostPos(1);
        mockBubbleSort2.setCurrList("1, 5, 3");
        mockBubbleSort2.setPracticeId(3);
        mockBubbleSort2.setProcessNum(1);
        mockBubbleSort2.setUserId(2);
        mockBubbleSort2.setTurn(1);

        BubbleSort mockBubbleSort3 = new BubbleSort();
        mockBubbleSort3.setBubbleId(3);
        mockBubbleSort3.setExchange(1);
        mockBubbleSort3.setPrePos(1);
        mockBubbleSort3.setPostPos(2);
        mockBubbleSort3.setCurrList("1, 3, 5");
        mockBubbleSort3.setPracticeId(3);
        mockBubbleSort3.setProcessNum(2);
        mockBubbleSort3.setUserId(2);
        mockBubbleSort3.setTurn(1);

        BubbleSort mockBubbleSort = new BubbleSort();
        mockBubbleSort.setBubbleId(3);
        mockBubbleSort.setExchange(0);
        mockBubbleSort.setPrePos(0);
        mockBubbleSort.setPostPos(0);
        mockBubbleSort.setCurrList("1, 3, 5");
        mockBubbleSort.setPracticeId(3);
        mockBubbleSort.setProcessNum(3);
        mockBubbleSort.setUserId(2);
        mockBubbleSort.setTurn(2);

        List<BubbleSort> mockBubbleSortList = new ArrayList<>();
        mockBubbleSortList.add(mockBubbleSort1);
        mockBubbleSortList.add(mockBubbleSort2);
        mockBubbleSortList.add(mockBubbleSort3);
        mockBubbleSortList.add(mockBubbleSort);

        when(bubbleSortService.getSolution(userId, practiceId)).thenReturn(mockBubbleSortList);
        ResultActions perform=mockMvc.perform(post("/bubble-sort/solution").param("userId", "2").param("practiceId", "3").header("token", "token"));
        perform.andExpect(status().isOk());
        verify(bubbleSortService).getSolution(userId, practiceId);
    }

}
