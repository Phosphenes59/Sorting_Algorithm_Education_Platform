package com.example.sorting_algorithm_education_platform.mapper;

import com.example.sorting_algorithm_education_platform.entity.Problems;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProblemsMapper {
    List<Problems> findAll();
    List<Problems> findMy(Integer userId);
    void insertProblems(Problems problems);
    void deleteProblems(Integer practiceId, Integer userId);
    Integer findMaxPracticeId();
}
