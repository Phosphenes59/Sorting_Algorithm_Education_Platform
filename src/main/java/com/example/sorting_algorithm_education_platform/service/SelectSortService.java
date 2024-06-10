package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.entity.SelectSort;

import java.util.List;

public interface SelectSortService {
    SelectSort getBySelectId(Integer SelectId);
    SelectSort getNextStep(Integer practiceId, Integer processNum);
    String getCurrList(Integer userId, Integer practiceId, Integer processNum);
    List<SelectSort> getSolution(Integer userId, Integer practiceId);
    void insertSort(SelectSort selectSort);
    void deleteSort(Integer practiceId, Integer userId);
}
