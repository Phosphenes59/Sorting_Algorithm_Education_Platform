package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.StudyHistory;
import com.example.sorting_algorithm_education_platform.mapper.StudyHistoryMapper;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.sorting_algorithm_education_platform.util.Const.*;

@RestController
@RequestMapping("/study-history")
public class StudyHistoryController {
    @Autowired
    StudyHistoryMapper studyHistoryMapper;

    @Autowired
    private UserService userService;

    // 进入某题学习时记录进入时间
    @GetMapping("/enter")
    public ResponseEntity<Res<String>> updateHistoryByEnterStudy(
            @RequestHeader("token") String token,
            @RequestParam("currTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currTime,
            @RequestParam("userId") Integer userId,
            @RequestParam("sortMethod") Integer sortMethod,
            @RequestParam("problemId") Integer problemId) {
        if (!userService.userIdExists(userId)) {
            System.out.println("user id not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }
        if (!sortMethodExists(sortMethod)) {
            System.out.println("sort method not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "排序类型不存在", null));
        }
        /* Todo: 检查题号是否存在
        if (!problemExistsForUser(sortMethod, problemId, userId)) {
            System.out.println("problem not exist for user");
            return ResponseEntity.badRequest().body(new Res<>(0, "题号不存在", null));
        }*/
        try {
            // 创建 StudyHistory 对象
            StudyHistory studyHistory = new StudyHistory();
            studyHistory.setSortMethod(sortMethod);
            studyHistory.setProblemId(problemId);
            studyHistory.setLastStep(0); // 进入时 lastStep 为 0
            studyHistory.setCurrTime(currTime);
            studyHistory.setStatus(0); // 进入题目时 status 为 0
            studyHistory.setUserId(userId);
            studyHistoryMapper.insertHistory(studyHistory);
            return ResponseEntity.ok(new Res<>(1, "添加进入学习历史成功",null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0, "添加进入学习历史失败: " , e.getMessage()));
        }
    }

    // 是否是三种排序算法中的一个
    private boolean sortMethodExists(int sortMethod) {
        return sortMethod == bubbleSort || sortMethod == insertSort || sortMethod == selectSort;
    }

    /*private boolean problemExistsForUser(int sortMethod, int problemId, int userId){
        int count = bubbleSortMapper.countByPracticeIdAndUserId(practiceId,userId);
    }*/


    // 退出某题学习时记录当前学习状态与退出时间
    @GetMapping("/exit")
    public ResponseEntity<Res<String>> updateHistoryByExitStudy(
            @RequestHeader("token") String token,
            @RequestParam("currTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currTime,
            @RequestParam("userId") Integer userId,
            @RequestParam("sortMethod") Integer sortMethod,
            @RequestParam("problemId") Integer problemId,
            @RequestParam("lastStep") Integer lastStep) {
        if (!userService.userIdExists(userId)) {
            System.out.println("user id not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }
        if (!sortMethodExists(sortMethod)) {
            System.out.println("sort method not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "排序类型不存在", null));
        }
        if (!enterHistoryExists(userId, sortMethod, problemId)) {
            System.out.println("corresponding enter history not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "对应的进入记录不存在", null));
        }
        try {
            // 创建 StudyHistory 对象
            StudyHistory studyHistory = new StudyHistory();
            studyHistory.setSortMethod(sortMethod);
            studyHistory.setProblemId(problemId);
            studyHistory.setLastStep(lastStep);
            studyHistory.setCurrTime(currTime);
            studyHistory.setStatus(1); // 退出题目时 status 为 1
            studyHistory.setUserId(userId);
            studyHistoryMapper.insertHistory(studyHistory);
            return ResponseEntity.ok(new Res<>(1, "添加退出学习历史成功", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0, "添加退出学习历史失败: ", e.getMessage()));
        }
    }
    public boolean enterHistoryExists(Integer userId, Integer sortMethod, Integer problemId) {
        StudyHistory latestEnterHistory = studyHistoryMapper.getLatestEnterHistory(userId, sortMethod, problemId);
        if (latestEnterHistory == null) {
            return false;
        }
        StudyHistory correspondingExitHistory = studyHistoryMapper.getCorrespondingExitHistory(latestEnterHistory.getId());
        return correspondingExitHistory == null;
    }

    // 按倒序输出学习历史，同一题只输出最后一次记录
    @PostMapping("/history")
    public ResponseEntity<Res<List<StudyHistory>>> getStudyHistory(
            @RequestHeader("token") String token,
            @RequestParam("userId") Integer userId){
        if (!userService.userIdExists(userId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }

        List<StudyHistory> studyHistoryList = studyHistoryMapper.getStudyHistoryByUserId(userId);
        return ResponseEntity.ok(new Res<>(1, "获取学习记录成功", studyHistoryList));
    }

    // 获取用户对应方法的完成题数
    @PostMapping ("/progress")
    public ResponseEntity<Res<Integer>> getProgressByMethod(
            @RequestHeader("token") String token,
            @RequestParam("userId") Integer userId,
            @RequestParam("sortMethod") Integer sortMethod
    ){
        if (!userService.userIdExists(userId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }

        if (!sortMethodExists(sortMethod)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "排序类型不存在", null));
        }

        int progress = studyHistoryMapper.countBySortMethod(sortMethod, userId);
        return ResponseEntity.ok(new Res<>(1, "获取学习进度成功", progress));
    }

    // 获取过去七天的学习时间和总和
    @PostMapping ("/studytime")
    public ResponseEntity<Res<List<Duration>>> getLast7DayStudyTimeAndSum(
            @RequestHeader("token") String token,
            @RequestParam("userId") Integer userId,
            @RequestParam("currTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currTime
    ){
        if (!userService.userIdExists(userId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }

        List<Duration> result = new ArrayList<>();
        long totalStudySeconds = 0;

        for (int i = 0; i < 7; i++) {
            LocalDateTime date = currTime.minusDays(i);
            long studySeconds = studyHistoryMapper.getIntervalByDateAndUserId(date, userId);
            result.add(Duration.ofSeconds(studySeconds));
            totalStudySeconds += studySeconds;
        }

        result.add(Duration.ofSeconds(totalStudySeconds));

        return ResponseEntity.ok(new Res<>(1, "获取最近7天学习时长成功", result));
    }
}
