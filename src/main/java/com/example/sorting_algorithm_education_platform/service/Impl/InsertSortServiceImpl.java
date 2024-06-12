package com.example.sorting_algorithm_education_platform.service.Impl;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.mapper.InsertSortMapper;
import com.example.sorting_algorithm_education_platform.service.InsertSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertSortServiceImpl implements InsertSortService {
    @Autowired
    private InsertSortMapper insertSortMapper;

    @Override
    public InsertSort getByInsertId(Integer InsertId) {
        return insertSortMapper.selectById(InsertId);
    }

    @Override
    public InsertSort getNextStep(Integer practiceId, Integer processNum) {
        return insertSortMapper.findNextStep(practiceId, processNum);
    }

    @Override
    public String getCurrList(Integer practiceId, Integer processNum) {
        String solution = insertSortMapper.findCurrList( practiceId, processNum);
        return solution;
    }

    @Override
    public List<InsertSort> getSolution(Integer practiceId) {
        List<InsertSort> solution = insertSortMapper.findSolution(practiceId);
        return solution;
    }

    @Override
    public void insertSort(InsertSort insertSort) {
        insertSortMapper.insertSort(insertSort);
    }

    @Override
    public void deleteSort(Integer practiceId, Integer userId) {
        insertSortMapper.deleteSort(practiceId, userId);
    }
}
