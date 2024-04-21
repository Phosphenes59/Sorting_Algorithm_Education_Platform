package com.example.sorting_algorithm_education_platform.entity;

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
    private int bubbleID;
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
    // 出题人
    private int userID;
    // 冒泡轮数
    private int turn;
}
