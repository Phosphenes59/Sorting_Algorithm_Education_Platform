package com.example.sorting_algorithm_education_platform.service.Impl;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.service.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BubbleSortServiceImpl implements BubbleSortService {
    @Autowired
    private BubbleSortMapper bubbleSortMapper;

    @Override
    public BubbleSort getByBubbleId(int bubbleId){
        BubbleSort bubbleSort = bubbleSortMapper.selectById(bubbleId);
        return bubbleSort;
    }

    @Override
    public BubbleSort getNextStep(int practiceId, int processNum){
        BubbleSort bubbleSort = bubbleSortMapper.findNextStep(practiceId, processNum);
        return bubbleSort;
    }

    @Override
    public String getCurrList(int practiceId, int processNum){
        String currList = bubbleSortMapper.findCurrList(practiceId, processNum);
        return currList;
    }

    @Override
    public String getSolution(int practiceId) {
        String solution = bubbleSortMapper.findSolution(practiceId);
        return solution;
    }

}
