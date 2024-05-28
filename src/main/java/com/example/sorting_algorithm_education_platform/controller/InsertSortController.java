package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.service.InsertSortService;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insert-sort")
public class InsertSortController {
    @Autowired
    private InsertSortService insertSortService;

    @PostMapping("/find")
    public ResponseEntity<Res<InsertSort>> findSortById(@RequestHeader("token") String token,
                                                        @RequestParam(value = "insertId") Integer insertId){
        InsertSort bubbleSort = insertSortService.getByInsertId(insertId);
        return getResResponseEntity(bubbleSort);
    }

    @PostMapping("/nextStep")
    public ResponseEntity<Res<InsertSort>> findNextStep(@RequestHeader("token") String token,
                                                        @RequestParam(value = "practiceId") Integer practiceId,
                                                        @RequestParam(value = "processNum") Integer processNum){
        InsertSort insertSort = insertSortService.getNextStep(practiceId, processNum);
        return getResResponseEntity(insertSort);
    }

    @PostMapping("/currList")
    public ResponseEntity<Res<String>> findCurrList(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId,
                                                    @RequestParam(value = "processNum") Integer processNum){
        String currList = insertSortService.getCurrList(practiceId, processNum);
        return getResResponseEntity(currList);
    }

    @PostMapping("/solution")
    public ResponseEntity<Res<String>> findSolution(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId){
        String solution = insertSortService.getSolution(practiceId);
        return getResResponseEntity(solution);
    }

    private ResponseEntity<Res<InsertSort>> getResResponseEntity(InsertSort insertSort) {
        Res<InsertSort> result;
        if (insertSort == null) {
            result = new Res<>(0, "查找失败",null);
        } else {
            result = new Res<>(1, "success", insertSort);
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
