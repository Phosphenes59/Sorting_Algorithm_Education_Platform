package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.util.BubbleSortRecorder;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bubble-sort")
public class BubbleSortController {
    @Autowired
    BubbleSortMapper bubbleSortMapper;

    @Autowired
    private BubbleSortRecorder bubbleSortRecorder;

    @PostMapping("/find")
    public ResponseEntity<Res<BubbleSort>> findSortById(@RequestHeader("token") String token,
                                                        @RequestParam(value = "bubbleId") Integer bubbleId){
        BubbleSort bubbleSort = bubbleSortMapper.selectById(bubbleId);
        return getResResponseEntity(bubbleSort);
    }

    @PostMapping("/nextStep")
    public ResponseEntity<Res<BubbleSort>> findNextStep(@RequestHeader("token") String token,
                                                        @RequestParam(value = "practiceId") Integer practiceId,
                                                        @RequestParam(value = "processNum") Integer processNum){
        BubbleSort bubbleSort = bubbleSortMapper.findNextStep(practiceId, processNum);
        return getResResponseEntity(bubbleSort);
    }

    @PostMapping("/currList")
    public ResponseEntity<Res<String>> findCurrList(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId,
                                                    @RequestParam(value = "processNum") Integer processNum){
        String currList = bubbleSortMapper.findCurrList(practiceId, processNum);
        return getResResponseEntity(currList);
    }

    @PostMapping("/solution")
    public ResponseEntity<Res<String>> findSolution(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId){
        String solution = bubbleSortMapper.findSolution(practiceId);
        return getResResponseEntity(solution);
    }

    @PostMapping("/addSort")
    public ResponseEntity<Res<String>> addSort(@RequestHeader("token") String token,
                                               @RequestParam(value = "sortList") String sortList,
                                               @RequestParam(value = "practiceId") Integer practiceId,
                                               @RequestParam(value = "userId") Integer userId) {

        try {
            // insert
            BubbleSort bubbleSort = new BubbleSort();
            // String currList = sortList.toString().replace("[", "").replace("]", "");
            bubbleSort.setCurrList(sortList);
            bubbleSort.setPracticeId(practiceId);
            bubbleSort.setProcessNum(0);
            bubbleSort.setUserId(userId);
            bubbleSort.setExchange(0);
            bubbleSort.setPrePos(0);
            bubbleSort.setPostPos(0);
            bubbleSort.setTurn(0);

            bubbleSortMapper.insertSort(bubbleSort);
            System.out.println("------------------------");
            recordBubbleSortSteps(sortList,practiceId, userId);

            return ResponseEntity.ok(new Res<>(1, "添加成功",null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0, "添加失败: " , e.getMessage()));
        }                                        
    }

    @PostMapping("/delete")
    public ResponseEntity<Res<String>> deleteSort(@RequestHeader("token") String token,
                                                  @RequestParam("practiceId") Integer practiceId,
                                                  @RequestParam("userId") Integer userId) {
        try {
            bubbleSortMapper.deleteSort(practiceId, userId);
            return ResponseEntity.ok(new Res<>(1, "删除成功",null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0,"删除失败: ",e.getMessage()));
        }
    }

    @PostMapping("/modify")
    public ResponseEntity<Res<String>> modifySort(@RequestHeader("token") String token,
                                                  @RequestParam(value = "sortList") String sortList,
                                                  @RequestParam(value = "practiceId") Integer practiceId,
                                                  @RequestParam(value = "userId") Integer userId) {
        try {
            //first delete
            bubbleSortMapper.deleteSort(practiceId, userId);
            // insert
            BubbleSort bubbleSort = new BubbleSort();
            // String currList = sortList.toString().replace("[", "").replace("]", "");
            bubbleSort.setCurrList(sortList);
            bubbleSort.setPracticeId(practiceId);
            bubbleSort.setProcessNum(0);
            bubbleSort.setUserId(userId);
            bubbleSort.setExchange(0);
            bubbleSort.setPrePos(0);
            bubbleSort.setPostPos(0);
            bubbleSort.setTurn(0);

            bubbleSortMapper.insertSort(bubbleSort);
            recordBubbleSortSteps(sortList,practiceId, userId);
            return ResponseEntity.ok(new Res<>(1, "添加成功",null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0,"删除失败: ",e.getMessage()));
        }
    }



    private ResponseEntity<Res<BubbleSort>> getResResponseEntity(BubbleSort bubbleSort) {
        Res<BubbleSort> result;
        if (bubbleSort == null) {
            result = new Res<>(0, "查找失败",null);
        } else {
            result = new Res<>(1, "success", bubbleSort);
        }
        return ResponseEntity.ok(result);
    }
    private ResponseEntity<Res<String>> getResResponseEntity(String solution) {
        Res<String> result;
        if (solution == null) {
            result = new Res<>(0, "查找失败",null);
        } else {
            result = new Res<>(1, "success",solution);
        }
        return ResponseEntity.ok(result);
    }

    public void recordBubbleSortSteps(String inputList, int practiceId, int userId) {
        int processNum = 0;
        int turn = 0;
        int prePos = 0;
        int postPos = 0;
        int exchange = 0;
        String currList = null;

        String[] stringArray = inputList.split(","); // 使用逗号分割字符串，得到字符串数组
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringArray) {
            integerList.add(Integer.parseInt(str.trim()));
        }


        int n = integerList.size();
        processNum = 0;
        for (int i = 0; i < n - 1; i++) {
            turn++;
            exchange = 0;
            prePos = 0;
            postPos = 0;


            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    exchange = 1;
                    prePos = j;
                    postPos = j + 1;
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                    processNum++;
                    currList = integerList.toString().replace("[", "").replace("]", "");
                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.setPracticeId(practiceId);
                    bubbleSort.setUserId(userId);
                    bubbleSort.setTurn(turn);
                    bubbleSort.setExchange(exchange);
                    bubbleSort.setPrePos(prePos);
                    bubbleSort.setPostPos(postPos);
                    bubbleSort.setCurrList(currList);
                    bubbleSort.setProcessNum(processNum);
                    System.out.println("change " + turn + " " + processNum+ " "+ prePos +" "+ postPos);

                    bubbleSortMapper.insertSort(bubbleSort);
                }

            }
            if(exchange == 0) {
                processNum++;
                currList = integerList.toString().replace("[", "").replace("]", "");
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.setPracticeId(practiceId);
                bubbleSort.setUserId(userId);
                bubbleSort.setTurn(turn);
                bubbleSort.setExchange(exchange);
                bubbleSort.setPrePos(prePos);
                bubbleSort.setPostPos(postPos);
                bubbleSort.setCurrList(currList);
                bubbleSort.setProcessNum(processNum);
                System.out.println("no " + turn + " " + processNum);
                bubbleSortMapper.insertSort(bubbleSort);
            }


        }

    }


}
