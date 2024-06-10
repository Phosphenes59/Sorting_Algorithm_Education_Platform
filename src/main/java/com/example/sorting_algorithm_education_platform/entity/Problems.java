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
@Table(name="`problems`")
public class Problems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Integer problemId;
    // 出题人
    private int userId;
    // 题目
    private String currList;
    // 题目序号
    private int practiceId;
}
