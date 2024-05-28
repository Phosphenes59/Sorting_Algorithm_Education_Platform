package com.example.sorting_algorithm_education_platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sorting_algorithm_education_platform.entity.StudyHistory;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudyHistoryMapper extends BaseMapper<StudyHistory> {
    // 根据用户id和排序方式数出学习完成情况
    int countBySortMethod(Integer sortMethod, Integer userId);
    // 根据当前时间计算当天的学习时间
    long getIntervalByDateAndUserId(LocalDateTime currTime, Integer userId);
    void insertHistory(StudyHistory studyHistory);
    StudyHistory getLatestEnterHistory(Integer userId,Integer sortMethod, Integer problemId);
    StudyHistory getCorrespondingExitHistory(Integer enterId);
    List<StudyHistory> getStudyHistoryByUserId(Integer userId);
}