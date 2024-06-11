package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.mapper.InsertSortMapper;
import com.example.sorting_algorithm_education_platform.service.Impl.InsertSortServiceImpl;
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
class InsertSortServiceTest {

    @Mock
    private InsertSortMapper insertSortMapper;

    @InjectMocks
    private InsertSortServiceImpl insertSortService;

    @Test
    void getByInsertId() {
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

        when(insertSortMapper.selectById(1)).thenReturn(mockInsertSort);

        InsertSort insertSort = insertSortService.getByInsertId(insertId);
        assertEquals(1, insertSort.getPracticeId());
        assertEquals("1, 6, 5, 3", insertSort.getCurrList());
    }

    @Test
    void getNextStep() {
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

        when(insertSortMapper.findNextStep(1, 0)).thenReturn(mockInsertSort2);

        InsertSort insertSort = insertSortService.getNextStep(practiceId, processNum);
        assertEquals(1, insertSort.getProcessNum());
        assertEquals(1, insertSort.getTurn());
    }

    @Test
    void getCurrList() {
        int userId = 1;
        int practiceId = 1;
        int processNum = 0;
        String currList = "1, 6, 5, 3";
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

//        when(insertSortMapper.findCurrList(1, 1, 0)).thenReturn(currList);

        String res = insertSortService.getCurrList(practiceId, processNum);
        assertEquals(currList, res);
    }

    @Test
    void getSolution() {
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

        when(insertSortMapper.findSolution(2, 3)).thenReturn(mockInsertSortList);

        List<InsertSort> res = insertSortService.getSolution(userId, practiceId);
        assertEquals(2, res.size());
    }

    @Test
    void insertSort() {
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

        when(insertSortMapper.selectById(1)).thenReturn(mockInsertSort);

        insertSortService.insertSort(mockInsertSort);
        InsertSort insertSort = insertSortService.getByInsertId(1);
        verify(insertSortMapper).insertSort(insertSort);
    }

    @Test
    void deleteSort() {
        insertSortService.deleteSort(1, 1);
        verify(insertSortMapper).deleteSort(1, 1);
    }
}
