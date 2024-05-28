package com.example.sorting_algorithm_education_platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectSortMapper extends BaseMapper<SelectSort> {
    SelectSort findNextStep(Integer practiceId, Integer processNum);
    String findCurrList(Integer practiceId, Integer processNum);
    String findSolution(Integer practiceId);
    void deleteSort(Integer practiceId, Integer userId);
    void insertSort(SelectSort selectSort);
}
