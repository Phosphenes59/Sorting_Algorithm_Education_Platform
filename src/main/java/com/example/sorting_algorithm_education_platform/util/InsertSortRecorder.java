package com.example.sorting_algorithm_education_platform.util;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;

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
            turn++;
            int key = inputList.get(i);
            System.out.println("key:" + key);
            int j;

            for (j = i - 1; j >= 0 && inputList.get(j) > key; j--) {
                inputList.set(j + 1, inputList.get(j));
//                    prePos = j;
//                    postPos = j + 1;
////                    int temp = inputList.get(j);
////                    int next = inputList.get(j + 1);
////                    inputList.set(j, next);
////                    inputList.set(j + 1, temp);
//                    Collections.swap(inputList, j, j + 1);
//                    processNum++;
//                    currList = inputList.toString().replace("[", "").replace("]", "");
//                    BubbleSort bubbleSort = new BubbleSort();
//                    bubbleSort.setPracticeId(practiceId);
//                    bubbleSort.setBubbleId(userId);
//                    bubbleSort.setTurn(turn);
//                    bubbleSort.setExchange(exchange);
//                    bubbleSort.setPrePos(prePos);
//                    bubbleSort.setPostPos(postPos);
//                    bubbleSort.setCurrList(currList);
//                    bubbleSort.setProcessNum(processNum);
//                System.out.print("change: ");
//                System.out.println(inputList);
//                    bubbleSortMapper.insertSort(bubbleSort);
            }
            inputList.set(j + 1, key);
            orderPost = j + 1;
            sorted = inputList.subList(0, i + 1).toString();
            unsorted = inputList.subList(i + 1, n).toString();
            System.out.println(orderPost);
            System.out.println(sorted);
            System.out.println(unsorted);
            System.out.println(inputList);
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
