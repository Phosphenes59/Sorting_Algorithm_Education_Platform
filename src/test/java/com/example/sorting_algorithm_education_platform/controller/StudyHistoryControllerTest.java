package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.controller.StudyHistoryController;
import com.example.sorting_algorithm_education_platform.entity.StudyHistory;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.mapper.InsertSortMapper;
import com.example.sorting_algorithm_education_platform.mapper.SelectSortMapper;
import com.example.sorting_algorithm_education_platform.mapper.StudyHistoryMapper;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.Res;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Mock
    BubbleSortMapper bubbleSortMapper;

    @Mock
    InsertSortMapper insertSortMapper;

    @Mock
    SelectSortMapper selectSortMapper;

    @InjectMocks
    private StudyHistoryController studyHistoryController;

    @Test
    void testUpdateHistoryByEnterStudy_Success() {
        // 准备测试数据
        String token = "validToken";
        LocalDateTime currTime = LocalDateTime.now();
        int userId = 1;
        int sortMethod = 1;
        int problemId = 1;

        // 模拟 userService.userIdExists 返回 true
        when(userService.userIdExists(userId)).thenReturn(true);

        // 模拟 bubbleSortMapper.countByPracticeId 返回大于0的值
        when(bubbleSortMapper.countByPracticeId(problemId)).thenReturn(1);

        // 调用 updateHistoryByEnterStudy 方法
        ResponseEntity<Res<String>> response = studyHistoryController.updateHistoryByEnterStudy(
                token, currTime, userId, sortMethod, problemId);

        // 验证返回的 HTTP 状态码和响应体
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("添加进入学习历史成功", response.getBody().getMsg());

        // 验证 insertHistory 方法被调用了一次
        Mockito.verify(studyHistoryMapper, Mockito.times(1)).insertHistory(any(StudyHistory.class));
    }

    @Test
    void testUpdateHistoryByExitStudy_Success() {
        // 准备测试数据
        String token = "validToken";
        LocalDateTime currTime = LocalDateTime.now();
        int userId = 1;
        int sortMethod = 1;
        int problemId = 1;
        int lastStep = 10;

        // 准备测试数据
        StudyHistory latestEnterHistory = new StudyHistory();
        latestEnterHistory.setId(1);
        latestEnterHistory.setUserId(userId);
        latestEnterHistory.setSortMethod(sortMethod);
        latestEnterHistory.setProblemId(problemId);
        latestEnterHistory.setStatus(0);

        // 模拟 userService.userIdExists 返回 true
        when(userService.userIdExists(userId)).thenReturn(true);

// 模拟 studyHistoryMapper.getLatestEnterHistory 返回准备好的数据
        when(studyHistoryMapper.getLatestEnterHistory(userId, sortMethod, problemId)).thenReturn(latestEnterHistory);

// 模拟 studyHistoryMapper.getCorrespondingExitHistory 返回 null,表示没有对应的退出记录
        when(studyHistoryMapper.getCorrespondingExitHistory(latestEnterHistory.getId())).thenReturn(null);

// 调用 updateHistoryByExitStudy 方法
        ResponseEntity<Res<String>> response = studyHistoryController.updateHistoryByExitStudy(
                token, currTime, userId, sortMethod, problemId, lastStep);

        // 验证返回的 HTTP 状态码和响应体
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCode());
        assertEquals("添加退出学习历史成功", response.getBody().getMsg());

        // 验证 insertHistory 方法被调用了一次
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