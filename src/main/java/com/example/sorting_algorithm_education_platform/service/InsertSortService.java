package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;

import java.util.List;

public interface InsertSortService {
    InsertSort getByInsertId(Integer InsertId);
    InsertSort getNextStep(Integer practiceId, Integer processNum);
    String getCurrList(Integer practiceId, Integer processNum);
    List<InsertSort> getSolution(Integer userId, Integer practiceId);
    void insertSort(InsertSort insertSort);
    void deleteSort(Integer practiceId, Integer userId);
}
