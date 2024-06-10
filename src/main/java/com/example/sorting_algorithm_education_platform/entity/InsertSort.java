package com.example.sorting_algorithm_education_platform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="`insert_sort`")
public class InsertSort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Integer insertId;
    // 待插入的数
    private int pivot;
    // 插入到有序列表中的位置
    private int orderPos;
    // 当前的有序列表
    private String sortedList;
    // 当前的待排序列表
    private String unsortedList;
    // 当前的完整列表
    private String currList;
    // 题目序号
    private int practiceId;
    // 出题人
    private int userId;
    // 步骤序号(为0时代表原题)
    private int processNum;
    // 每一轮的步骤
    private int processStep;
    // 插入轮数
    private int turn;

    //getters and setters
    public Integer getInsertId() {
        return insertId;
    }

    public void setInsertId(Integer insertId) {
        this.insertId = insertId;
    }

    public int getPivot() {
        return pivot;
    }

    public void setPivot(int pivot) {
        this.pivot = pivot;
    }

    public int getOrderPos() {
        return orderPos;
    }

    public void setOrderPos(int orderPos) {
        this.orderPos = orderPos;
    }

    public String getSortedList() {
        return sortedList;
    }

    public void setSortedList(String sortedList) {
        this.sortedList = sortedList;
    }

    public String getUnsortedList() {
        return unsortedList;
    }

    public void setUnsortedList(String unsortedList) {
        this.unsortedList = unsortedList;
    }

    public String getCurrList() {
        return currList;
    }

    public void setCurrList(String currList) {
        this.currList = currList;
    }

    public int getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(int practiceId) {
        this.practiceId = practiceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProcessNum() {
        return processNum;
    }

    public void setProcessNum(int processNum) {
        this.processNum = processNum;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getProcessStep() {
        return processStep;
    }

    public void setProcessStep(int processStep) {
        this.processStep = processStep;
    }
}
