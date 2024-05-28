package com.example.sorting_algorithm_education_platform.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="`study_history`")
public class StudyHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Integer id;

    @Column(name = "sort_method")
    private int sortMethod;

    @Column(name = "problem_id")
    private int problemId;

    @Column(name = "last_step")
    private int lastStep;

    @Column(name = "curr_time")
    private LocalDateTime currTime;

    @Column(name = "status")
    private int status;

    @Column(name = "user_id")
    private int userId;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(int sortMethod) {
        this.sortMethod = sortMethod;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getLastStep() {
        return lastStep;
    }

    public void setLastStep(int lastStep) {
        this.lastStep = lastStep;
    }

    public LocalDateTime getCurrTime() {
        return currTime;
    }

    public void setCurrTime(LocalDateTime currTime) {
        this.currTime = currTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
