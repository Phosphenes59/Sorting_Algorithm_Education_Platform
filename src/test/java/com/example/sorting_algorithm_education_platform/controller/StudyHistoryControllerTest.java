package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.controller.StudyHistoryController;
import com.example.sorting_algorithm_education_platform.entity.StudyHistory;
import com.example.sorting_algorithm_education_platform.mapper.StudyHistoryMapper;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.Res;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudyHistoryControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private StudyHistoryMapper studyHistoryMapper;

    @InjectMocks
    private StudyHistoryController studyHistoryController;

    @Test
    void testUpdateHistoryByEnterStudy_Success() {
        when(userService.userIdExists(anyInt())).thenReturn(true);
        Mockito.doNothing().when(studyHistoryMapper).insertHistory(any(StudyHistory.class));

        ResponseEntity<Res<String>> response = studyHistoryController.updateHistoryByEnterStudy(
                "token", LocalDateTime.now(), 2, 1, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("添加进入学习历史成功", response.getBody().getMsg());

        Mockito.verify(studyHistoryMapper, Mockito.times(1)).insertHistory(any(StudyHistory.class));
    }

    @Test
    void testUpdateHistoryByExitStudy_Success() {
        when(userService.userIdExists(anyInt())).thenReturn(true);
        when(studyHistoryController.enterHistoryExists(anyInt(), anyInt(), anyInt())).thenReturn(true);
        Mockito.doNothing().when(studyHistoryMapper).insertHistory(any(StudyHistory.class));

        ResponseEntity<Res<String>> response = studyHistoryController.updateHistoryByExitStudy(
                "token", LocalDateTime.now(), 1, 1, 1, 10);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("添加退出学习历史成功", response.getBody().getMsg());

        Mockito.verify(studyHistoryMapper, Mockito.times(1)).insertHistory(any(StudyHistory.class));
    }


    @Test
    void testGetStudyHistory_Success() {
        when(userService.userIdExists(anyInt())).thenReturn(true);
        when(studyHistoryMapper.getStudyHistoryByUserId(anyInt())).thenReturn(new ArrayList<>());

        ResponseEntity<Res<List<StudyHistory>>> response = studyHistoryController.getStudyHistory("token", 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("获取学习记录成功", response.getBody().getMsg());
    }

    @Test
    void testGetProgressByMethod_Success() {
        when(userService.userIdExists(anyInt())).thenReturn(true);
        when(studyHistoryMapper.countBySortMethod(anyInt(), anyInt())).thenReturn(5);

        ResponseEntity<Res<Integer>> response = studyHistoryController.getProgressByMethod("token", 1, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("获取学习进度成功", response.getBody().getMsg());
        assertEquals(5, response.getBody().getData());
    }

    @Test
    void testGetAllProgressByMethod_Success() {
        when(userService.userIdExists(anyInt())).thenReturn(true);
        when(studyHistoryMapper.countBySortMethod(anyInt(), anyInt())).thenReturn(5);

        ResponseEntity<Res<List<Integer>>> response = studyHistoryController.getAllProgressByMethod("token", 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("获取学习进度成功", response.getBody().getMsg());
        assertEquals(3, response.getBody().getData().size());
    }

    @Test
    void testGetLast7DayStudyTimeAndSum_Success() {
        when(userService.userIdExists(anyInt())).thenReturn(true);
        when(studyHistoryMapper.getIntervalByDateAndUserId(any(LocalDateTime.class), anyInt())).thenReturn(3600L);

        ResponseEntity<Res<List<Duration>>> response = studyHistoryController.getLast7DayStudyTimeAndSum(
                "token", 1, LocalDateTime.now());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("获取最近7天学习时长成功", response.getBody().getMsg());
        assertEquals(8, response.getBody().getData().size());
    }
}