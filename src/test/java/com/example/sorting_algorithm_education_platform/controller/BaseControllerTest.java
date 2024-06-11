package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.service.BubbleSortService;
import com.example.sorting_algorithm_education_platform.service.InsertSortService;
import com.example.sorting_algorithm_education_platform.service.SelectSortService;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.BubbleSortRecorder;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BaseController.class)
class BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BubbleSortService bubbleSortService;

    @MockBean
    private InsertSortService insertSortService;

    @MockBean
    private SelectSortService selectSortService;

    @MockBean
    private UserService userService;

//    @Test
//    void addSort_Success() {
//        when(userService.userIdExists(anyInt())).thenReturn(true);
//
//        when(bubbleSortMapper.countByPracticeIdAndUserId(anyInt(), anyInt())).thenReturn(0);
//
//        doNothing().when(bubbleSortMapper).insertSort(any());
//        doNothing().when(bubbleSortRecorder).recordBubbleSortSteps(anyList(), anyInt(), anyInt());
//
//        // Execute the test
//        ResponseEntity<Res<String>> response = baseController.addSort("mockToken", "1, 7, 5, 3", 5, 2);
//
//        // Assertions
//        assertNotNull(response);
//        assertEquals(1, response.getBody().getCode());
//        assertEquals("添加成功", response.getBody().getMsg());
//        assertNull(response.getBody().getData());
//
//        // Verify if insertSort method was called 5 times
//        verify(bubbleSortMapper, times(5)).insertSort(any());
//    }
//
//    @Test
//    void addSort_FailNoUser() {
//        when(userService.userIdExists(anyInt())).thenReturn(false);
//        doNothing().when(bubbleSortMapper).insertSort(any());
//        doNothing().when(bubbleSortRecorder).recordBubbleSortSteps(anyList(), anyInt(), anyInt());
//
//        ResponseEntity<Res<String>> response = baseController.addSort("mockToken", "1, 7, 5, 3", 3, 4);
//
//        // Assertions
//        assertNotNull(response);
//        assertEquals(0, response.getBody().getCode());
//        assertEquals("用户ID不存在", response.getBody().getMsg());
//        assertNull(response.getBody().getData());
//
//        // Verify if insertSort method was called zero times
//        verify(bubbleSortMapper, times(0)).insertSort(any());
//    }
//
//    @Test
//    void addSort_FailExist() {
//        when(userService.userIdExists(anyInt())).thenReturn(true);
//
//        when(bubbleSortMapper.countByPracticeIdAndUserId(anyInt(), anyInt())).thenReturn(1);
//
//        doNothing().when(bubbleSortMapper).insertSort(any());
//        doNothing().when(bubbleSortRecorder).recordBubbleSortSteps(anyList(), anyInt(), anyInt());
//
//        // Execute the test
//        ResponseEntity<Res<String>> response = baseController.addSort("mockToken", "1, 7, 5, 3", 3, 2);
//
//        // Assertions
//        assertNotNull(response);
//        assertEquals(0, response.getBody().getCode());
//        assertEquals("题号存在", response.getBody().getMsg());
//        assertNull(response.getBody().getData());
//
//        // Verify if insertSort method was called 5 times
//        verify(bubbleSortMapper, times(0)).insertSort(any());
//    }
//
//    @Test
//    void addSort_InvalidSequence() {
//        when(userService.userIdExists(anyInt())).thenReturn(true);
//
//        when(bubbleSortMapper.countByPracticeIdAndUserId(anyInt(), anyInt())).thenReturn(0);
//
//        doNothing().when(bubbleSortMapper).insertSort(any());
//        doNothing().when(bubbleSortRecorder).recordBubbleSortSteps(anyList(), anyInt(), anyInt());
//
//
//        // Execute the test
//        ResponseEntity<Res<String>> response = baseController.addSort("mockToken", "1, -, 5, 3", 6, 2);
//
//        // Assertions
//        assertNotNull(response);
//        assertEquals(0, response.getBody().getCode());
//        assertEquals("序列无效", response.getBody().getMsg());
//        assertNull(response.getBody().getData());
//
//        // Verify if insertSort method was called 5 times
//        verify(bubbleSortMapper, times(0)).insertSort(any());
//    }
//
//    @Test
//    void deleteSort_Success() {
//        doNothing().when(bubbleSortMapper).deleteSort(anyInt(), anyInt());
//        ResponseEntity<Res<String>> response = baseController.deleteSort("mockToken", 3, 2);
//
//        // Assertions
//        assertNotNull(response);
//        assertEquals(1, response.getBody().getCode());
//        assertEquals("删除成功", response.getBody().getMsg());
//        assertNull(response.getBody().getData());
//
//        // Verify if deleteSort method was called once with the given parameters
//        verify(bubbleSortMapper, times(1)).deleteSort(3, 2);
//    }
//
//    @Test
//    void modifySort_Success() {
//        // Mocking the behavior of deleteSort and insertSort in bubbleSortMapper
//        doNothing().when(bubbleSortMapper).deleteSort(anyInt(), anyInt());
//        doNothing().when(bubbleSortMapper).insertSort(any());
//
//        // Mocking the behavior of recordBubbleSortSteps in bubbleSortRecorder
//        doNothing().when(bubbleSortRecorder).recordBubbleSortSteps(anyList(), anyInt(), anyInt());
//
//        // Call the method to be tested
//        ResponseEntity<Res<String>> response = baseController.modifySort("mockToken",
//                "1, 6, 5, 3", 3, 2);
//
//        // Assertions
//        assertNotNull(response);
//        assertEquals(1, response.getBody().getCode());
//        assertEquals("添加成功", response.getBody().getMsg());
//        assertNull(response.getBody().getData());
//
//        // Verify if deleteSort and insertSort methods were called once with the given parameters
//        verify(bubbleSortMapper, times(1)).deleteSort(3, 2);
//        verify(bubbleSortMapper, times(5)).insertSort(any());
//    }
}