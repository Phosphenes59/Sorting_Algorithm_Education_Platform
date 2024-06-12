package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.Problems;

import java.util.List;

public interface ProblemsService {
    List<Problems> findAll(Integer userId);
    List<Problems> findMy(Integer userId);
    void insertProblems(Problems problems);
    void deleteProblems(Integer practiceId, Integer userId);
}
