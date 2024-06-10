package com.example.sorting_algorithm_education_platform.util;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;

import java.util.ArrayList;
import java.util.List;

public class InsertSortRecorder {
    public void recordInsertSortSteps(List<Integer> inputList, int practiceId, int userId) {
        int n = inputList.size();
        int processNum = 0;
        int turn = 0;
        int key = 0;
        int orderPos = 0;
        String sorted = inputList.get(0).toString().replace("[", "").replace("]", "");
        String unsorted = inputList.subList(1, n).toString().replace("[", "").replace("]", "");

        InsertSort insertSort = new InsertSort();
        insertSort.setPracticeId(practiceId);
        insertSort.setUserId(userId);
        insertSort.setPivot(key);
        insertSort.setOrderPos(orderPos);
        insertSort.setSortedList("");
        insertSort.setUnsortedList(inputList.toString().replace("[", "").replace("]", ""));
        insertSort.setCurrList(inputList.toString().replace("[", "").replace("]", ""));
        insertSort.setProcessNum(processNum);
        insertSort.setTurn(turn);
        System.out.println(insertSort);

        key = inputList.get(0);
        turn++;
        processNum++;
        insertSort.setPivot(key);
        insertSort.setSortedList(inputList.get(0).toString());
        insertSort.setUnsortedList(inputList.subList(1, n).toString().replace("[", "").replace("]", ""));
        insertSort.setProcessNum(processNum);
        insertSort.setTurn(turn);
        System.out.println(insertSort);

        for (int i = 1; i < n; i++) {
            turn++;
            processNum = 0;
            key = inputList.get(i);
//            System.out.println("key:" + key);
            int j;

            for (j = i - 1; j >= 0 && inputList.get(j) > key; j--) {
                inputList.set(j + 1, inputList.get(j));
                processNum++;
                orderPos = j + 1;
                sorted = inputList.subList(0, i + 1).toString().replace("[", "").replace("]", "");
                unsorted = inputList.subList(i + 1, n).toString().replace("[", "").replace("]", "");
                insertSort.setPivot(key);
                insertSort.setOrderPos(orderPos);
                insertSort.setSortedList(sorted);
                insertSort.setUnsortedList(unsorted);
                insertSort.setCurrList(inputList.toString().replace("[", "").replace("]", ""));
                insertSort.setProcessNum(processNum);
                insertSort.setTurn(turn);
                System.out.println(insertSort);
            }
            inputList.set(j + 1, key);
            processNum++;
            orderPos = j + 1;
            sorted = inputList.subList(0, i + 1).toString().replace("[", "").replace("]", "");
            unsorted = inputList.subList(i + 1, n).toString().replace("[", "").replace("]", "");
            insertSort.setPivot(key);
            insertSort.setOrderPos(orderPos);
            insertSort.setSortedList(sorted);
            insertSort.setUnsortedList(unsorted);
            insertSort.setCurrList(inputList.toString().replace("[", "").replace("]", ""));
            insertSort.setProcessNum(processNum);
            insertSort.setTurn(turn);
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
