package com.example.sorting_algorithm_education_platform.service.Impl;

import com.example.sorting_algorithm_education_platform.entity.Problems;
import com.example.sorting_algorithm_education_platform.mapper.ProblemsMapper;
import com.example.sorting_algorithm_education_platform.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemsServiceImpl implements ProblemsService {
    @Autowired
    ProblemsMapper problemsMapper;

    @Override
    public List<Problems> findAll() {
        return problemsMapper.findAll();
    }

    @Override
    public List<Problems> findMy(Integer userId) {
        return problemsMapper.findMy(userId);
    }

    @Override
    public void insertProblems(Problems problems) {
        problemsMapper.insertProblems(problems);
    }

    @Override
    public void deleteProblems(Integer practiceId, Integer userId) {
        problemsMapper.deleteProblems(practiceId, userId);
    }
}
