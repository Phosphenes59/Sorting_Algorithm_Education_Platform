package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.service.Impl.BubbleSortServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BubbleSortServiceTest {
    @Mock
    private BubbleSortMapper bubbleSortMapper;

    @InjectMocks
    private BubbleSortServiceImpl bubbleSortService;

    @Test
    void findById(){
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

        when(bubbleSortMapper.selectById(1)).thenReturn(mockBubbleSort);

        BubbleSort bubbleSort = bubbleSortService.getByBubbleId(bubbleId);
        assertEquals(1, bubbleSort.getPracticeId());
        assertEquals("1, 6, 5, 3", bubbleSort.getCurrList());
    }

    @Test
    void findNextStep(){
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

        when(bubbleSortMapper.findNextStep(1, 0)).thenReturn(mockBubbleSort2);

        BubbleSort bubbleSort = bubbleSortService.getNextStep(practiceId, processNum);
        assertEquals(1, bubbleSort.getProcessNum());
        assertEquals(1, bubbleSort.getTurn());
    }

    @Test
    void findCurrList(){
        int userId = 1;
        int practiceId = 1;
        int processNum = 0;
        String currList = "1, 6, 5, 3";
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

        when(bubbleSortMapper.findCurrList(1, 1, 0)).thenReturn(currList);

        String res = bubbleSortService.getCurrList(userId, practiceId, processNum);
        assertEquals(currList, res);
    }

}