package com.example.sorting_algorithm_education_platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsertSortMapper extends BaseMapper<InsertSort> {
    InsertSort findNextStep(Integer practiceId, Integer processNum);
    String findCurrList(Integer practiceId, Integer processNum);
    List<InsertSort> findSolution(Integer userId, Integer practiceId);
    void deleteSort(Integer practiceId, Integer userId);
    void insertSort(InsertSort insertSort);
}
