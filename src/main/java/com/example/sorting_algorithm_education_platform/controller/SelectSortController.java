package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import com.example.sorting_algorithm_education_platform.service.SelectSortService;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/select-sort")
public class SelectSortController {
    @Autowired
    private SelectSortService selectSortService;

    @PostMapping("/find")
    public ResponseEntity<Res<SelectSort>> findSortById(@RequestHeader("token") String token,
                                                        @RequestParam(value = "selectId") Integer selectId){
        SelectSort selectSort = selectSortService.getByInsertId(selectId);
        return getResResponseEntity(selectSort);
    }

    @PostMapping("/nextStep")
    public ResponseEntity<Res<SelectSort>> findNextStep(@RequestHeader("token") String token,
                                                        @RequestParam(value = "practiceId") Integer practiceId,
                                                        @RequestParam(value = "processNum") Integer processNum){
        SelectSort selectSort = selectSortService.getNextStep(practiceId, processNum);
        return getResResponseEntity(selectSort);
    }

    @PostMapping("/currList")
    public ResponseEntity<Res<String>> findCurrList(@RequestHeader("token") String token,
                                                    @RequestParam(value = "practiceId") Integer practiceId,
                                                    @RequestParam(value = "processNum") Integer processNum){
        String currList = selectSortService.getCurrList(practiceId, processNum);
        return getResResponseEntity(currList);
    }

    @PostMapping("/solution")
    public ResponseEntity<Res<List<SelectSort>>> findSolution(@RequestHeader("token") String token,
                                                              @RequestParam(value = "userId") Integer userId,
                                                              @RequestParam(value = "practiceId") Integer practiceId){
        List<SelectSort> solution = selectSortService.getSolution(userId, practiceId);
        return getResResponseEntity(solution);
    }

    private ResponseEntity<Res<List<SelectSort>>> getResResponseEntity(List<SelectSort> selectSortList) {
        Res<List<SelectSort>> result;
        if (selectSortList == null) {
            result = new Res<>(0, "查找失败",null);
        } else {
            result = new Res<>(1, "success", selectSortList);
        }
        return ResponseEntity.ok(result);
    }

    private ResponseEntity<Res<SelectSort>> getResResponseEntity(SelectSort insertSort) {
        Res<SelectSort> result;
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
