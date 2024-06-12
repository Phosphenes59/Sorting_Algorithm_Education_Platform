package com.example.sorting_algorithm_education_platform.service.Impl;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.service.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BubbleSortServiceImpl implements BubbleSortService {
    @Autowired
    private BubbleSortMapper bubbleSortMapper;

    @Override
    public BubbleSort getByBubbleId(Integer bubbleId){
        BubbleSort bubbleSort = bubbleSortMapper.selectById(bubbleId);
        return bubbleSort;
    }

    @Override
    public BubbleSort getNextStep(Integer practiceId, Integer processNum){
        BubbleSort bubbleSort = bubbleSortMapper.findNextStep(practiceId, processNum);
        return bubbleSort;
    }

    @Override
    public String getCurrList(Integer practiceId, Integer processNum) {
        String solution = bubbleSortMapper.findCurrList(practiceId, processNum);
        return solution;
    }

    @Override
    public List<BubbleSort> getSolution(Integer practiceId) {
        List<BubbleSort> solution = bubbleSortMapper.findSolution(practiceId);
        return solution;
    }

    @Override
    public void insertSort(BubbleSort bubbleSort) {
        bubbleSortMapper.insertSort(bubbleSort);
    }

    @Override
    public void deleteSort(Integer practiceId, Integer userId) {
        bubbleSortMapper.deleteSort(practiceId, userId);
    }

    @Override
    public int countByPracticeIdAndUserId(Integer practiceId, Integer userId) {
        return bubbleSortMapper.countByPracticeIdAndUserId(practiceId, userId);
    }

    @Override
    public int countByPracticeId(Integer practiceId) {
        return bubbleSortMapper.countByPracticeId(practiceId);
    }

}
