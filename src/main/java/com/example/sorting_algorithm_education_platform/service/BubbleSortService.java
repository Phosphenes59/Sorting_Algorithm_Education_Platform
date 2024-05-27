package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;

import java.util.List;

public interface BubbleSortService {
    BubbleSort getByBubbleId(int bubbleId);
    BubbleSort getNextStep(int practiceId, int processNum);
    String getCurrList(int practiceId, int processNum);
    String getSolution(int practiceId);
}
