package com.example.sorting_algorithm_education_platform.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res<T> {
    private Integer code;
    private String msg;
    private T data;
}
