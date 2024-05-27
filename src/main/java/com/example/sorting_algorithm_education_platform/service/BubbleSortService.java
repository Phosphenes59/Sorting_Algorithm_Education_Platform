package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;

public interface BubbleSortService {
    BubbleSort getByBubbleId(Integer bubbleId);
    BubbleSort getNextStep(Integer practiceId, Integer processNum);
    String getCurrList(Integer practiceId, Integer processNum);
    String getSolution(Integer practiceId);
    void insertSort(BubbleSort bubbleSort);
    void deleteSort(Integer practiceId, Integer userId);
    int countByPracticeIdAndUserId(Integer practiceId, Integer userId);
}
