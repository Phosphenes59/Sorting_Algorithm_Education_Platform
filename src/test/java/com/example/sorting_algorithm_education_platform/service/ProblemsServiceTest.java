package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.Problems;
import com.example.sorting_algorithm_education_platform.mapper.ProblemsMapper;
import com.example.sorting_algorithm_education_platform.service.Impl.ProblemsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProblemsServiceTest {

    @Mock
    private ProblemsMapper problemsMapper;

    @InjectMocks
    private ProblemsServiceImpl problemsService;

    @Test
    void findAll() {
        int userId = 2;
        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setProblemId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        Problems problems1 = new Problems();
        problems.setUserId(2);
        problems.setProblemId(2);
        problems.setPracticeId(2);
        problems.setCurrList("5, 8, 6, 2");

        List<Problems> problemsList = new ArrayList<>();
        problemsList.add(problems);
        problemsList.add(problems1);

        when(problemsMapper.findAll()).thenReturn(problemsList);

        List<Problems> res = problemsService.findAll(userId);
        assertEquals(2, res.size());
    }

    @Test
    void findMy() {
        int userId = 2;
        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setProblemId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        Problems problems1 = new Problems();
        problems.setUserId(2);
        problems.setProblemId(2);
        problems.setPracticeId(2);
        problems.setCurrList("5, 8, 6, 2");

        List<Problems> problemsList = new ArrayList<>();
        problemsList.add(problems1);

        when(problemsMapper.findMy(2)).thenReturn(problemsList);

        List<Problems> res = problemsService.findMy(userId);
        assertEquals(1, res.size());
    }

    @Test
    void insertProblems() {
        Problems problems = new Problems();
        problems.setUserId(1);
        problems.setProblemId(1);
        problems.setPracticeId(1);
        problems.setCurrList("1, 6, 5, 3");

        problemsService.insertProblems(problems);
        verify(problemsMapper).insertProblems(problems);
    }

    @Test
    void deleteProblems() {
        problemsService.deleteProblems(1, 1);
        verify(problemsMapper).deleteProblems(1, 1);
    }
}