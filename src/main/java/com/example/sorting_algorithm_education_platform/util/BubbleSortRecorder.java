package com.example.sorting_algorithm_education_platform.util;

import com.example.sorting_algorithm_education_platform.controller.BubbleSortController;
import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.service.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BubbleSortRecorder {
    private int exchange;
    private int prePos;
    private int postPos;
    private String currList;
    private int processNum;
    private int processStep;
    private int turn;
//    @Autowired
//    private BubbleSortMapper bubbleSortMapper;
//    @Autowired
//    private static BubbleSortController bubbleSortController;

    @Autowired
    private BubbleSortService bubbleSortService;


//    private static BubbleSortMapper bubbleSortMapper;
//    @Autowired
//    public void setBubbleSortMapper (BubbleSortMapper bubbleSortMapper) {
//        BubbleSortRecorder.bubbleSortMapper = bubbleSortMapper;
//    }

    public BubbleSortRecorder() {
        this.exchange = 0;
        this.prePos = -1;
        this.postPos = -1;
        this.currList = null;
        this.processNum = 0;
        this.processStep = 0;
        this.turn = 0;
    }

    public void recordBubbleSortSteps(List<Integer> inputList, int practiceId, int userId) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.setPracticeId(practiceId);
        bubbleSort.setUserId(userId);
        bubbleSort.setTurn(0);
        bubbleSort.setExchange(0);
        bubbleSort.setPrePos(0);
        bubbleSort.setPostPos(0);
        bubbleSort.setCurrList(inputList.toString().replace("[", "").replace("]", ""));
        bubbleSort.setProcessNum(0);
        bubbleSort.setProcessStep(0);
        System.out.println(bubbleSort);
//        bubbleSortService.insertSort(bubbleSort);

        int n = inputList.size();
        processNum = 0;
        for (int i = 0; i < n - 1; i++) {
            turn++;
            exchange = 0;
            prePos = 0;
            postPos = 0;


            for (int j = 0; j < n - i - 1; j++) {
                if (inputList.get(j) > inputList.get(j + 1)) {
                    exchange = 1;
                    prePos = j;
                    postPos = j + 1;
//                    int temp = inputList.get(j);
//                    int next = inputList.get(j + 1);
//                    inputList.set(j, next);
//                    inputList.set(j + 1, temp);
                    Collections.swap(inputList, j, j + 1);
                    processNum++;
                    processStep++;
                    currList = inputList.toString().replace("[", "").replace("]", "");
                    bubbleSort.setTurn(turn);
                    bubbleSort.setExchange(exchange);
                    bubbleSort.setPrePos(prePos);
                    bubbleSort.setPostPos(postPos);
                    bubbleSort.setCurrList(currList);
                    bubbleSort.setProcessNum(processNum);
                    System.out.println(bubbleSort);
//                    bubbleSortService.insertSort(bubbleSort);
//                    bubbleSortMapper.insertSort(bubbleSort);
                }
            }
            if(exchange == 0) {
                processNum++;
                currList = inputList.toString().replace("[", "").replace("]", "");
                bubbleSort.setTurn(turn);
                bubbleSort.setExchange(exchange);
                bubbleSort.setPrePos(prePos);
                bubbleSort.setPostPos(postPos);
                bubbleSort.setCurrList(currList);
                bubbleSort.setProcessNum(processNum);
                System.out.println(bubbleSort);
//                bubbleSortService.insertSort(bubbleSort);
//                bubbleSortMapper.insertSort(bubbleSort);
            }
        }

    }

    public static void main(String[] args) {
        BubbleSortRecorder recorder = new BubbleSortRecorder();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(12);
        inputList.add(15);
        inputList.add(7);
        inputList.add(8);
        inputList.add(10);
        inputList.add(25);
        recorder.recordBubbleSortSteps(inputList,4,1);
    }
}