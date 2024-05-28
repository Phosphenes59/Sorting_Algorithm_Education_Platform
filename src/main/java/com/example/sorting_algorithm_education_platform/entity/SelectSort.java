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
@Table(name="`select_sort`")
public class SelectSort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Integer selectId;
    // 本次操作是否是交换
    private int exchange;
    // 最小元素位置
    private int minPos;
    // 当前位置
    private int curPos;
    // 当前的排序列表(指交换后)
    private String currList;
    // 题目序号
    private int practiceId;
    // 步骤序号(为0时代表原题)
    private int processNum;
    // 出题人
    private int userId;
    // 冒泡轮数
    private int turn;

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public int getMinPos() {
        return minPos;
    }

    public void setMinPos(int minPos) {
        this.minPos = minPos;
    }

    public int getCurPos() {
        return curPos;
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
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

    public int getProcessNum() {
        return processNum;
    }

    public void setProcessNum(int processNum) {
        this.processNum = processNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
