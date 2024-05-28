package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.SelectSort;

public interface SelectSortService {
    SelectSort getByInsertId(Integer SelectId);
    SelectSort getNextStep(Integer practiceId, Integer processNum);
    String getCurrList(Integer practiceId, Integer processNum);
    String getSolution(Integer practiceId);
    void insertSort(SelectSort selectSort);
    void deleteSort(Integer practiceId, Integer userId);
}
