package com.example.sorting_algorithm_education_platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BubbleSortMapper extends BaseMapper<BubbleSort> {
    BubbleSort findNextStep(Integer practiceId, Integer processNum);
    String findCurrList(Integer practiceId, Integer processNum);
    String findSolution(Integer practiceId);
}
