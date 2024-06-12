package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BubbleSortService {
    BubbleSort getByBubbleId(Integer bubbleId);
    BubbleSort getNextStep(Integer practiceId, Integer processNum);
    String getCurrList(Integer practiceId, Integer processNum);
    List<BubbleSort> getSolution(Integer practiceId);
    void insertSort(BubbleSort bubbleSort);
    void deleteSort(Integer practiceId, Integer userId);
    int countByPracticeIdAndUserId(Integer practiceId, Integer userId);
    int countByPracticeId(Integer practiceId);
}
