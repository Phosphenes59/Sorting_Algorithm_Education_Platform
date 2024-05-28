package com.example.sorting_algorithm_education_platform.service.Impl;

import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import com.example.sorting_algorithm_education_platform.mapper.SelectSortMapper;
import com.example.sorting_algorithm_education_platform.service.SelectSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectSortServiceImpl implements SelectSortService {
    @Autowired
    private SelectSortMapper selectSortMapper;
    @Override
    public SelectSort getByInsertId(Integer SelectId) {
        return selectSortMapper.selectById(SelectId);
    }

    @Override
    public SelectSort getNextStep(Integer practiceId, Integer processNum) {
        return selectSortMapper.findNextStep(practiceId, processNum);
    }

    @Override
    public String getCurrList(Integer practiceId, Integer processNum) {
        return selectSortMapper.findCurrList(practiceId, processNum);
    }

    @Override
    public String getSolution(Integer practiceId) {
        return selectSortMapper.findSolution(practiceId);
    }

    @Override
    public void insertSort(SelectSort selectSort) {
        selectSortMapper.insertSort(selectSort);
    }

    @Override
    public void deleteSort(Integer practiceId, Integer userId) {
        selectSortMapper.deleteSort(practiceId, userId);
    }
}
