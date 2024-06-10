package com.example.sorting_algorithm_education_platform.mapper;

import com.example.sorting_algorithm_education_platform.entity.StudyHistory;
import com.example.sorting_algorithm_education_platform.mapper.StudyHistoryMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudyHistoryMapperTest {

    @Mock
    private StudyHistoryMapper studyHistoryMapper;

    @Test
    void testCountBySortMethod() {
        int sortMethod = 1;
        int userId = 1;
        int expectedCount = 3;

        when(studyHistoryMapper.countBySortMethod(sortMethod, userId)).thenReturn(expectedCount);

        int result = studyHistoryMapper.countBySortMethod(sortMethod, userId);
        Assertions.assertEquals(expectedCount, result);
    }

    @Test
    void testGetIntervalByDateAndUserId() {
        LocalDateTime currTime = LocalDateTime.now();
        int userId = 1;
        long expectedInterval = 3600;

        when(studyHistoryMapper.getIntervalByDateAndUserId(currTime, userId)).thenReturn(expectedInterval);

        long result = studyHistoryMapper.getIntervalByDateAndUserId(currTime, userId);
        Assertions.assertEquals(expectedInterval, result);
    }

    @Test
    void testInsertHistory() {
        StudyHistory studyHistory = new StudyHistory();
        studyHistory.setSortMethod(1);
        studyHistory.setProblemId(1);
        studyHistory.setLastStep(10);
        studyHistory.setCurrTime(LocalDateTime.now());
        studyHistory.setStatus(0);
        studyHistory.setUserId(1);

        studyHistoryMapper.insertHistory(studyHistory);
        verify(studyHistoryMapper).insertHistory(studyHistory);
    }

    @Test
    void testGetLatestEnterHistory() {
        int userId = 1;
        int sortMethod = 1;
        int problemId = 1;
        StudyHistory expectedHistory = new StudyHistory();
        expectedHistory.setId(1);
        expectedHistory.setUserId(userId);
        expectedHistory.setSortMethod(sortMethod);
        expectedHistory.setProblemId(problemId);
        expectedHistory.setStatus(0);

        when(studyHistoryMapper.getLatestEnterHistory(userId, sortMethod, problemId)).thenReturn(expectedHistory);

        StudyHistory result = studyHistoryMapper.getLatestEnterHistory(userId, sortMethod, problemId);
        Assertions.assertEquals(expectedHistory, result);
    }

    @Test
    void testGetCorrespondingExitHistory() {
        int enterId = 1;
        StudyHistory expectedHistory = new StudyHistory();
        expectedHistory.setId(2);
        expectedHistory.setUserId(1);
        expectedHistory.setSortMethod(1);
        expectedHistory.setProblemId(1);
        expectedHistory.setStatus(1);

        when(studyHistoryMapper.getCorrespondingExitHistory(enterId)).thenReturn(expectedHistory);

        StudyHistory result = studyHistoryMapper.getCorrespondingExitHistory(enterId);
        Assertions.assertEquals(expectedHistory, result);
    }

    @Test
    void testGetStudyHistoryByUserId() {
        int userId = 1;
        List<StudyHistory> expectedHistories = new ArrayList<>();
        expectedHistories.add(new StudyHistory(1, 1, 1, 10, LocalDateTime.now(), 1, userId));
        expectedHistories.add(new StudyHistory(2, 2, 2, 5, LocalDateTime.now().minusHours(1), 1, userId));

        when(studyHistoryMapper.getStudyHistoryByUserId(userId)).thenReturn(expectedHistories);

        List<StudyHistory> result = studyHistoryMapper.getStudyHistoryByUserId(userId);
        Assertions.assertEquals(expectedHistories, result);
    }

    @Test
    void testInsertHistory_NullHistory() {
        StudyHistory nullHistory = null;
        studyHistoryMapper.insertHistory(nullHistory);
        verify(studyHistoryMapper).insertHistory(nullHistory);
    }

    @Test
    void testInsertHistory_InvalidHistory() {
        StudyHistory invalidHistory = new StudyHistory();
        invalidHistory.setSortMethod(-1);
        invalidHistory.setProblemId(-1);
        invalidHistory.setLastStep(-1);
        invalidHistory.setCurrTime(null);
        invalidHistory.setStatus(-1);
        invalidHistory.setUserId(-1);

        studyHistoryMapper.insertHistory(invalidHistory);
        verify(studyHistoryMapper).insertHistory(invalidHistory);
    }

    @Test
    void testGetStudyHistoryByUserId_NoHistory() {
        int userIdWithNoHistory = 999;
        List<StudyHistory> expectedEmptyList = new ArrayList<>();

        when(studyHistoryMapper.getStudyHistoryByUserId(userIdWithNoHistory)).thenReturn(expectedEmptyList);

        List<StudyHistory> result = studyHistoryMapper.getStudyHistoryByUserId(userIdWithNoHistory);
        Assertions.assertEquals(expectedEmptyList, result);
    }

    @Test
    void testCountBySortMethod_NonExistentMethod() {
        int nonExistentSortMethod = 999;
        int userId = 1;
        int expectedCount = 0;

        when(studyHistoryMapper.countBySortMethod(nonExistentSortMethod, userId)).thenReturn(expectedCount);

        int result = studyHistoryMapper.countBySortMethod(nonExistentSortMethod, userId);
        Assertions.assertEquals(expectedCount, result);
    }
}