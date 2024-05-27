package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.service.BubbleSortService;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bubble-sort")
public class BubbleSortController {

    @Autowired
    private BubbleSortService bubbleSortService;

    @PostMapping("/find")
    public ResponseEntity<Res<BubbleSort>> findSortById(@RequestHeader("token") String token,
                                                        @RequestParam(value = "bubbleId") Integer bubbleId){
        BubbleSort bubbleSort = bubbleSortService.getByBubbleId(bubbleId);
        return getResResponseEntity(bubbleSort);
    }

    @PostMapping("/nextStep")
    public ResponseEntity<Res<BubbleSort>> findNextStep(@RequestHeader("token") String token,
                                                        @RequestParam(value = "practiceId") Integer practiceId,
                                                        @RequestParam(value = "processNum") Integer processNum){
        BubbleSort bubbleSort = bubbleSortService.getNextStep(practiceId, processNum);
        return getResResponseEntity(bubbleSort);
    }

    @PostMapping("/currList")
    public ResponseEntity<Res<String>> findCurrList(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId,
                                                    @RequestParam(value = "processNum") Integer processNum){
        String currList = bubbleSortService.getCurrList(practiceId, processNum);
        return getResResponseEntity(currList);
    }

    @PostMapping("/solution")
    public ResponseEntity<Res<String>> findSolution(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId){
        String solution = bubbleSortService.getSolution(practiceId);
        return getResResponseEntity(solution);
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
}
