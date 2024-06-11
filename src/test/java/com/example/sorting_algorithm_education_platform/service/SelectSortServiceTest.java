package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import com.example.sorting_algorithm_education_platform.mapper.SelectSortMapper;
import com.example.sorting_algorithm_education_platform.service.Impl.SelectSortServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SelectSortServiceTest {

    @Mock
    private SelectSortMapper selectSortMapper;

    @InjectMocks
    private SelectSortServiceImpl selectSortService;

    @Test
    void getBySelectId() {
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

        when(selectSortMapper.selectById(1)).thenReturn(mockSelectSort);

        SelectSort insertSort = selectSortService.getBySelectId(selectId);
        assertEquals(1, insertSort.getPracticeId());
        assertEquals("1, 6, 5, 3", insertSort.getCurrList());
    }

    @Test
    void getNextStep() {
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

        when(selectSortMapper.findNextStep(1, 0)).thenReturn(mockSelectSort2);

        SelectSort selectSort = selectSortService.getNextStep(practiceId, processNum);
        assertEquals(1, selectSort.getProcessNum());
        assertEquals(1, selectSort.getTurn());
    }

    @Test
    void getCurrList() {
        int userId = 1;
        int practiceId = 1;
        int processNum = 0;
        String currList = "1, 6, 5, 3";
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

        when(selectSortMapper.findCurrList(1, 1, 0)).thenReturn(currList);

        String res = selectSortService.getCurrList(userId, practiceId, processNum);
        assertEquals(currList, res);
    }

    @Test
    void getSolution() {
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

        when(selectSortMapper.findSolution(2, 3)).thenReturn(mockSelectSortList);

        List<SelectSort> res = selectSortService.getSolution(userId, practiceId);
        assertEquals(2, res.size());
    }

    @Test
    void insertSort() {
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

        when(selectSortMapper.selectById(1)).thenReturn(mockSelectSort);

        selectSortService.insertSort(mockSelectSort);
        SelectSort selectSort = selectSortService.getBySelectId(selectId);
        verify(selectSortMapper).insertSort(selectSort);
    }

    @Test
    void deleteSort() {
        selectSortService.deleteSort(1, 1);
        verify(selectSortMapper).deleteSort(1, 1);
    }
}