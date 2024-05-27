package com.example.sorting_algorithm_education_platform.mapper;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertSortMapper {
    InsertSort findNextStep(Integer practiceId, Integer processNum);
    String findCurrList(Integer practiceId, Integer processNum);
    String findSolution(Integer practiceId);
}
