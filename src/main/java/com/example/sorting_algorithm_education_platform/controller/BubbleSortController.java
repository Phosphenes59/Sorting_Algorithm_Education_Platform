package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.mapper.BubbleSortMapper;
import com.example.sorting_algorithm_education_platform.util.BubbleSortRecorder;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bubble-sort")
public class BubbleSortController {
    @Autowired
    BubbleSortMapper bubbleSortMapper;
    BubbleSortRecorder bubbleSortRecorder;

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
                                               @RequestParam(value = "sortList") List sortList,
                                               @RequestParam(value = "practiceId") Integer practiceId,
                                               @RequestParam(value = "userId") Integer userId) {
        try {
            // insert
            BubbleSort bubbleSort = new BubbleSort();
            String currList = sortList.toString().replace("[", "").replace("]", "");
            bubbleSort.setCurrList(currList);
            bubbleSort.setPracticeId(practiceId);
            bubbleSort.setProcessNum(0);
            bubbleSort.setUserId(userId);
            bubbleSort.setExchange(0);
            bubbleSort.setPrePos(0);
            bubbleSort.setPostPos(0);
            bubbleSort.setTurn(0);

            bubbleSortMapper.insertSort(bubbleSort);
            bubbleSortRecorder.recordBubbleSortSteps(sortList,practiceId, userId);

            return ResponseEntity.ok(new Res<>(1, "添加成功",""));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0, "添加失败: " , e.getMessage()));
        }                                        
    }

    @PostMapping("/delete")
    public ResponseEntity<Res<String>> deleteSort(@RequestHeader("token") String token,
                                                  @RequestParam(value = "practiceId") Integer practiceId,
                                                  @RequestParam(value = "userId") Integer userId) {
        try {
            bubbleSortMapper.deleteSort(practiceId, userId);
            return ResponseEntity.ok(new Res<>(1, "添加成功",""));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0,"删除失败: ",e.getMessage()));
        }
    }

    @PostMapping("/modify")
    public ResponseEntity<Res<String>> modifySort(@RequestHeader("token") String token,
                                                  @RequestParam(value = "sortList") List sortList,
                                                  @RequestParam(value = "practiceId") Integer practiceId,
                                                  @RequestParam(value = "userId") Integer userId) {
        try {
            //first delete
            bubbleSortMapper.deleteSort(practiceId, userId);
            // insert
            BubbleSort bubbleSort = new BubbleSort();
            String currList = sortList.toString().replace("[", "").replace("]", "");
            bubbleSort.setCurrList(currList);
            bubbleSort.setPracticeId(practiceId);
            bubbleSort.setProcessNum(0);
            bubbleSort.setUserId(userId);
            bubbleSort.setExchange(0);
            bubbleSort.setPrePos(0);
            bubbleSort.setPostPos(0);
            bubbleSort.setTurn(0);

            bubbleSortMapper.insertSort(bubbleSort);
            bubbleSortRecorder.recordBubbleSortSteps(sortList,practiceId, userId);
            return ResponseEntity.ok(new Res<>(1, "添加成功",""));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0,"删除失败: ",e.getMessage()));
        }
    }



    private ResponseEntity<Res<BubbleSort>> getResResponseEntity(BubbleSort bubbleSort) {
        Res<BubbleSort> result;
        if (bubbleSort == null) {
            result = new Res<>(0, "查找失败");
        } else {
            result = new Res<>(1, "success");
        }
        return ResponseEntity.ok(result);
    }
    private ResponseEntity<Res<String>> getResResponseEntity(String solution) {
        Res<String> result;
        if (solution == null) {
            result = new Res<>(0, "查找失败");
        } else {
            result = new Res<>(1, "success");
        }
        return ResponseEntity.ok(result);
    }
}
