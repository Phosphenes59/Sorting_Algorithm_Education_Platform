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
@Table(name="`bubble_sort`")
public class BubbleSort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Integer bubbleId;
    // 本次操作是否是交换
    private int exchange;
    // 交换的位置1
    private int prePos;
    // 交换的位置2
    private int postPos;
    // 当前的排序列表(指交换后)
    private String currList;
    // 题目序号
    private int practiceId;
    // 步骤序号(为0时代表原题)
    private int processNum;

    public void setPrePos(int prePos) {
        this.prePos = prePos;
    }

    public void setPostPos(int postPos) {
        this.postPos = postPos;
    }

    public int getProcessStep() {
        return processStep;
    }

    public void setProcessStep(int processStep) {
        this.processStep = processStep;
    }

    // 每一轮的步骤
    private int processStep;
    // 出题人
    private int userId;
    // 冒泡轮数
    private int turn;

    // getters and setters

    public Integer getBubbleId() {
        return bubbleId;
    }

    public void setBubbleId(Integer bubbleId) {
        this.bubbleId = bubbleId;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public Integer getPrePos() {
        return prePos;
    }

    public void setPrePos(Integer prePos) {
        this.prePos = prePos;
    }

    public Integer getPostPos() {
        return postPos;
    }

    public void setPostPos(Integer postPos) {
        this.postPos = postPos;
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
