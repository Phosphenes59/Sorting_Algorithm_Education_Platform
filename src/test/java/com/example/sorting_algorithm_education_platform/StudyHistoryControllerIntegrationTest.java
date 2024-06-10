package com.example.sorting_algorithm_education_platform;

import com.example.sorting_algorithm_education_platform.entity.StudyHistory;
import com.example.sorting_algorithm_education_platform.mapper.StudyHistoryMapper;
import com.example.sorting_algorithm_education_platform.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class StudyHistoryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudyHistoryMapper studyHistoryMapper;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup() {
        studyHistoryMapper.deleteAll();
    }

    @Test
    void shouldGetStudyHistoryByUserId() throws Exception {
        // 插入一些测试数据
        StudyHistory history1 = new StudyHistory();
        history1.setUserId(1);
        history1.setSortMethod(1);
        history1.setProblemId(1);
        history1.setLastStep(5);
        history1.setStatus(1);
        history1.setCurrTime(LocalDateTime.now());
        studyHistoryMapper.insertHistory(history1);

        StudyHistory history2 = new StudyHistory();
        history2.setUserId(1);
        history2.setSortMethod(2);
        history2.setProblemId(1);
        history2.setLastStep(3);
        history2.setStatus(1);
        history2.setCurrTime(LocalDateTime.now().plusMinutes(1));
        studyHistoryMapper.insertHistory(history2);


        mockMvc.perform(post("/study-history/history")
                        .header("token", "validToken")
                        .param( "userId", "1", "currTime",LocalDateTime.now().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].userId").value(1))
                .andExpect(jsonPath("$.data[0].sortMethod").value(2))
                .andExpect(jsonPath("$.data[0].problemId").value(1))
                .andExpect(jsonPath("$.data[0].lastStep").value(3))
                .andExpect(jsonPath("$.data[0].status").value(1))
                .andExpect(jsonPath("$.data[1].userId").value(1))
                .andExpect(jsonPath("$.data[1].sortMethod").value(1))
                .andExpect(jsonPath("$.data[1].problemId").value(1))
                .andExpect(jsonPath("$.data[1].lastStep").value(5))
                .andExpect(jsonPath("$.data[1].status").value(1));
    }

    @Test
    void shouldGetProgressByMethod() throws Exception {
        // 插入一些测试数据
        StudyHistory history1 = new StudyHistory();
        history1.setUserId(1);
        history1.setSortMethod(1);
        history1.setProblemId(1);
        history1.setStatus(1);
        history1.setCurrTime(LocalDateTime.now());
        studyHistoryMapper.insertHistory(history1);

        StudyHistory history2 = new StudyHistory();
        history2.setUserId(1);
        history2.setSortMethod(1);
        history2.setProblemId(2);
        history2.setStatus(1);
        history2.setCurrTime(LocalDateTime.now().plusMinutes(1));
        studyHistoryMapper.insertHistory(history2);

        mockMvc.perform(post("/study-history/progress")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data").value(2));
    }

    @Test
    void shouldGetAllProgressByMethod() throws Exception {
        // 插入一些测试数据
        StudyHistory history1 = new StudyHistory();
        history1.setUserId(1);
        history1.setSortMethod(1);
        history1.setProblemId(1);
        history1.setStatus(1);
        history1.setCurrTime(LocalDateTime.now());
        studyHistoryMapper.insertHistory(history1);

        StudyHistory history2 = new StudyHistory();
        history2.setUserId(1);
        history2.setSortMethod(2);
        history2.setProblemId(1);
        history2.setStatus(1);
        history2.setCurrTime(LocalDateTime.now().plusMinutes(1));
        studyHistoryMapper.insertHistory(history2);

        mockMvc.perform(post("/study-history/allprogress")
                        .header("token", "validToken")
                        .param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.data[0]").value(0))
                .andExpect(jsonPath("$.data[1]").value(1))
                .andExpect(jsonPath("$.data[2]").value(1));
    }

    @Test
    void shouldGetStudyHistoryByUserIdWithNoHistory() throws Exception {
        mockMvc.perform(post("/study-history/history")
                        .header("token", "validToken")
                        .param("userId", "999")
                        .param("currTime", LocalDateTime.now().toString()))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void shouldUpdateStudyHistoryWhenEnterLearning() throws Exception {
        mockMvc.perform(get("/study-history/enter")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "1")
                        .param("problemId", "1")
                        .param("currTime", LocalDateTime.now().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void shouldUpdateStudyHistoryWhenExitLearningNormally() throws Exception {
        // 先插入一条进入学习的记录
        StudyHistory enterHistory = new StudyHistory();
        enterHistory.setUserId(1);
        enterHistory.setSortMethod(1);
        enterHistory.setProblemId(1);
        enterHistory.setLastStep(5);
        enterHistory.setStatus(0);
        enterHistory.setCurrTime(LocalDateTime.now());
        studyHistoryMapper.insertHistory(enterHistory);

        mockMvc.perform(get("/study-history/exit")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "1")
                        .param("problemId", "1")
                        .param("lastStep", "10")
                        .param("currTime", LocalDateTime.now().plusMinutes(10).toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void shouldUpdateStudyHistoryWhenExitLearningAbnormally() throws Exception {
        // 先插入一条进入学习的记录
        StudyHistory enterHistory = new StudyHistory();
        enterHistory.setUserId(1);
        enterHistory.setSortMethod(1);
        enterHistory.setProblemId(1);
        enterHistory.setLastStep(5);
        enterHistory.setStatus(0);
        enterHistory.setCurrTime(LocalDateTime.now());
        studyHistoryMapper.insertHistory(enterHistory);

        mockMvc.perform(get("/study-history/exit")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "1")
                        .param("problemId", "1")
                        .param("lastStep", "8")
                        .param("currTime", LocalDateTime.now().plusMinutes(5).toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void shouldReturnErrorWhenUpdateWithInvalidParams() throws Exception {
        mockMvc.perform(post("/study-history/enter")
                        .header("token", "validToken")
                        .param("userId", "-1")
                        .param("sortMethod", "-1")
                        .param("problemId", "-1")
                        .param("lastStep", "-1")
                        .param("currTime", LocalDateTime.now().toString()))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void shouldGetProgressByMethodWithMultipleMethods() throws Exception {
        // 插入多个排序方法的学习记录
        StudyHistory history1 = new StudyHistory();
        history1.setUserId(1);
        history1.setSortMethod(1);
        history1.setProblemId(1);
        history1.setStatus(1);
        history1.setCurrTime(LocalDateTime.now());
        studyHistoryMapper.insertHistory(history1);

        StudyHistory history2 = new StudyHistory();
        history2.setUserId(1);
        history2.setSortMethod(2);
        history2.setProblemId(1);
        history2.setStatus(1);
        history2.setCurrTime(LocalDateTime.now().plusMinutes(1));
        studyHistoryMapper.insertHistory(history2);

        mockMvc.perform(post("/study-history/progress")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data").value(1));

        mockMvc.perform(post("/study-history/progress")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data").value(1));
    }

    @Test
    void shouldGetZeroProgressWithNoRecord() throws Exception {
        mockMvc.perform(post("/study-history/progress")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("sortMethod", "999"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void shouldGetLearningDurationWithRecord() throws Exception {
        // 插入一些学习记录
        StudyHistory history1 = new StudyHistory();
        history1.setUserId(1);
        history1.setSortMethod(1);
        history1.setProblemId(1);
        history1.setStatus(0);
        history1.setCurrTime(LocalDateTime.now().minusDays(2).minusMinutes(1));
        studyHistoryMapper.insertHistory(history1);

        StudyHistory history2 = new StudyHistory();
        history2.setUserId(1);
        history2.setSortMethod(2);
        history2.setProblemId(1);
        history2.setStatus(1);
        history2.setCurrTime(LocalDateTime.now().minusDays(2));
        studyHistoryMapper.insertHistory(history2);

        mockMvc.perform(post("/study-history/studytime")
                        .header("token", "validToken")
                        .param("userId", "1")
                        .param("currTime", LocalDateTime.now().plusMinutes(5).toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.data", hasSize(8)))
                .andExpect(jsonPath("$.data[2]").value(60));
    }

    @Test
    void shouldGetZeroDurationWithNoRecord() throws Exception {
        mockMvc.perform(post("/study-history/studytime")
                        .header("token", "validToken")
                        .param("userId", "999")
                        .param("currTime", LocalDateTime.now().plusMinutes(5).toString()))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.data").doesNotExist());
    }
}

