package com.example.sorting_algorithm_education_platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectSortMapper extends BaseMapper<SelectSort> {
    SelectSort findNextStep(Integer practiceId, Integer processNum);
    String findCurrList(Integer practiceId, Integer processNum);
    List<SelectSort> findSolution(Integer userId, Integer practiceId);
    void deleteSort(Integer practiceId, Integer userId);
    void insertSort(SelectSort selectSort);
}
