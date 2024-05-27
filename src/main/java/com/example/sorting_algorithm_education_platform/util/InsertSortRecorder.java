package com.example.sorting_algorithm_education_platform.util;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertSortRecorder {
    public void recordInsertSortSteps(List<Integer> inputList, int practiceId, int userId) {

        int n = inputList.size();
        int processNum = 0;
        int turn = 0;
        int exchange = 0;
        int orderPost = 0;
        String sorted = inputList.get(0).toString();
        String unsorted = inputList.subList(1, n).toString();
        for (int i = 1; i < n; i++) {
            InsertSort insertSort = new InsertSort();
            turn++;
            processNum++;
            int key = inputList.get(i);
            System.out.println("key:" + key);
            int j;

            for (j = i - 1; j >= 0 && inputList.get(j) > key; j--) {
                inputList.set(j + 1, inputList.get(j));
            }
            inputList.set(j + 1, key);
            orderPost = j + 1;
            sorted = inputList.subList(0, i + 1).toString();
            unsorted = inputList.subList(i + 1, n).toString();
            insertSort.setInsertId(0);
            insertSort.setPracticeId(1);
            insertSort.setKey(key);
            insertSort.setOrderPos(orderPost);
            insertSort.setSortedList(sorted);
            insertSort.setUnsortedList(unsorted);
            insertSort.setCurrList(inputList.toString());
            insertSort.setProcessNum(processNum);
            insertSort.setTurn(turn);
            insertSort.setUserId(1);
            System.out.println(insertSort);
        }
    }

    public static void main(String[] args) {
        InsertSortRecorder recorder = new InsertSortRecorder();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(5);
        inputList.add(2);
        inputList.add(8);
        inputList.add(1);
        inputList.add(4);
        recorder.recordInsertSortSteps(inputList,0,0);
    }
}
