package com.example.sorting_algorithm_education_platform.util;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.entity.SelectSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectSortRecorder {
    public void recordSelectSortSteps(List<Integer> inputList, int practiceId, int userId) {
        int n = inputList.size();
        int processNum = 0;
        int turn = 0;
        int key = 0;
        int curPos = 0;
        int minPos = 0;
        int exchange = 0;

        SelectSort selectSort = new SelectSort();
        selectSort.setPracticeId(practiceId);
        selectSort.setUserId(userId);
        selectSort.setExchange(exchange);
        selectSort.setCurPos(curPos);
        selectSort.setMinPos(minPos);
        selectSort.setCurrList(inputList.toString().replace("[", "").replace("]", ""));
        selectSort.setProcessNum(processNum);
        selectSort.setTurn(turn);
        System.out.println(selectSort);

        for (int i = 0; i < n - 1; i++) {
            turn++;
            processNum++;
            exchange = 0;
            curPos = i;
            minPos = i;
            selectSort.setCurPos(curPos);
            selectSort.setProcessNum(processNum);
            selectSort.setTurn(turn);
            for (int j = i + 1; j < n; j++) {
                if (inputList.get(j) < inputList.get(minPos)){
                    minPos = j;
                }
            }
            if (minPos != i){
                exchange = 1;
                Collections.swap(inputList, i, minPos);
            }
            selectSort.setExchange(exchange);
            selectSort.setMinPos(minPos);
            selectSort.setCurrList(inputList.toString().replace("[", "").replace("]", ""));
            System.out.println(selectSort);
        }
    }

    public static void main(String[] args) {
        SelectSortRecorder recorder = new SelectSortRecorder();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(5);
        inputList.add(2);
        inputList.add(8);
        inputList.add(1);
        inputList.add(4);
        recorder.recordSelectSortSteps(inputList,0,0);
    }
}
