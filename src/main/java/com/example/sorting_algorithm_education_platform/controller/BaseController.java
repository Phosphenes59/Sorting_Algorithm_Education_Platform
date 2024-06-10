package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.BubbleSort;
import com.example.sorting_algorithm_education_platform.entity.InsertSort;
import com.example.sorting_algorithm_education_platform.entity.Problems;
import com.example.sorting_algorithm_education_platform.entity.SelectSort;
import com.example.sorting_algorithm_education_platform.service.*;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/sort")
public class BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private BubbleSortService bubbleSortService;
    @Autowired
    private InsertSortService insertSortService;
    @Autowired
    private SelectSortService selectSortService;
    @Autowired
    private ProblemsService problemsService;

    @PostMapping("/all")
    public ResponseEntity<Res<List<Problems>>> getAllProblems(@RequestHeader("token") String token){
        List<Problems> solution = problemsService.findAll();
        return getResResponseEntity(solution);
    }

    @PostMapping("/myPractice")
    public ResponseEntity<Res<List<Problems>>> getMyProblems(@RequestHeader("token") String token,
                                                             @RequestParam(value = "userId") Integer userId){
        List<Problems> solution = problemsService.findMy(userId);
        return getResResponseEntity(solution);
    }

    @PostMapping("/add")
    public ResponseEntity<Res<String>> addSort(@RequestHeader("token") String token,
                                               @RequestParam(value = "sortList") String sortList,
                                               @RequestParam(value = "practiceId") Integer practiceId,
                                               @RequestParam(value = "userId") Integer userId) {

        if (!userService.userIdExists(userId)) {
            System.out.println("user id not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }

        if (practiceIdExists(practiceId)) {
            System.out.println("user id && practiceId not exist");
            return ResponseEntity.badRequest().body(new Res<>(0, "题号存在", null));
        }
        if (!isValidSequence(sortList)) {
            System.out.println("invalid sequence");
            return ResponseEntity.badRequest().body(new Res<>(0, "序列无效", null));
        }
        Problems problems = new Problems();
        problems.setCurrList(sortList);
        problems.setPracticeId(practiceId);
        problems.setUserId(userId);
        try {
            insertBubble(sortList, practiceId, userId);
            insertInsert(sortList, practiceId, userId);
            insertSelect(sortList, practiceId, userId);
            problemsService.insertProblems(problems);
            return ResponseEntity.ok(new Res<>(1, "添加成功",null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0, "添加失败: " , e.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Res<String>> deleteSort(@RequestHeader("token") String token,
                                                  @RequestParam("practiceId") Integer practiceId,
                                                  @RequestParam("userId") Integer userId) {
        if (!userService.userIdExists(userId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }

        if (!practiceIdExists(practiceId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "题号不存在", null));
        }
        try {
            bubbleSortService.deleteSort(practiceId, userId);
            insertSortService.deleteSort(practiceId, userId);
            selectSortService.deleteSort(practiceId, userId);
            problemsService.deleteProblems(practiceId, userId);
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
        if (!userService.userIdExists(userId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "用户ID不存在", null));
        }

        if (!practiceIdExists(practiceId)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "题号不存在", null));
        }
        if (!isValidSequence(sortList)) {
            return ResponseEntity.badRequest().body(new Res<>(0, "序列无效", null));
        }
        Problems problems = new Problems();
        problems.setCurrList(sortList);
        problems.setPracticeId(practiceId);
        problems.setUserId(userId);
        try {
            //first delete
            bubbleSortService.deleteSort(practiceId, userId);
            insertBubble(sortList, practiceId, userId);
            insertSortService.deleteSort(practiceId, userId);
            insertInsert(sortList, practiceId, userId);
            selectSortService.deleteSort(practiceId, userId);
            insertSelect(sortList, practiceId, userId);
            problemsService.deleteProblems(practiceId, userId);
            problemsService.insertProblems(problems);
            return ResponseEntity.ok(new Res<>(1, "修改成功",null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Res<>(0,"修改失败: ",e.getMessage()));
        }
    }

    private ResponseEntity<Res<List<Problems>>> getResResponseEntity(List<Problems> problems) {
        Res<List<Problems>> result;
        if (problems == null) {
            result = new Res<>(0, "查找失败",null);
        } else {
            result = new Res<>(1, "success", problems);
        }
        return ResponseEntity.ok(result);
    }

    // 方法用于检查该userID的practiceId是否存在
    private boolean practiceIdExists(Integer practiceId) {
        int count = bubbleSortService.countByPracticeId(practiceId);
        return count > 0;
    }

    // 方法用于检查传进来的序列是否正确
    public boolean isValidSequence(String sequence) {
        String regex = "^\\d+(\\s*,\\s*\\d+)*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(sequence).matches();
    }

    public void insertBubble(String inputList, Integer practiceId, Integer userId){
        int processNum = 0;
        int turn = 0;
        int prePos = 0;
        int postPos = 0;
        int exchange = 0;
        int processStep = 0;
        String currList = null;

        String[] stringArray = inputList.split(","); // 使用逗号分割字符串，得到字符串数组
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringArray) {
            integerList.add(Integer.parseInt(str.trim()));
        }

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.setPracticeId(practiceId);
        bubbleSort.setUserId(userId);
        bubbleSort.setTurn(0);
        bubbleSort.setExchange(0);
        bubbleSort.setPrePos(0);
        bubbleSort.setPostPos(0);
        bubbleSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
        bubbleSort.setProcessNum(0);
        bubbleSort.setProcessStep(0);
        System.out.println(bubbleSort);
        bubbleSortService.insertSort(bubbleSort);

        int n = integerList.size();
        for (int i = 0; i < n - 1; i++) {
            turn++;
            exchange = 0;
            prePos = 0;
            postPos = 0;
            processStep = 0;

            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    exchange = 1;
                    prePos = j;
                    postPos = j + 1;
                    Collections.swap(integerList, j, j + 1);
                    processNum++;
                    processStep++;
                    currList = integerList.toString().replace("[", "").replace("]", "");
                    bubbleSort.setTurn(turn);
                    bubbleSort.setExchange(exchange);
                    bubbleSort.setPrePos(prePos);
                    bubbleSort.setPostPos(postPos);
                    bubbleSort.setCurrList(currList);
                    bubbleSort.setProcessNum(processNum);
                    bubbleSort.setProcessStep(processStep + turn - 1);
                    System.out.println(bubbleSort);
                    bubbleSortService.insertSort(bubbleSort);
                } else {
                    exchange = 0;
                    prePos = 0;
                    postPos = 0;
                    processNum++;
                    processStep++;
                    currList = integerList.toString().replace("[", "").replace("]", "");
                    bubbleSort.setTurn(turn);
                    bubbleSort.setExchange(exchange);
                    bubbleSort.setPrePos(prePos);
                    bubbleSort.setPostPos(postPos);
                    bubbleSort.setCurrList(currList);
                    bubbleSort.setProcessNum(processNum);
                    bubbleSort.setProcessStep(processStep + turn - 1);
                    System.out.println(bubbleSort);
                    bubbleSortService.insertSort(bubbleSort);
                }
            }
        }
    }

    public void insertInsert(String inputList, Integer practiceId, Integer userId){

        String[] stringArray = inputList.split(","); // 使用逗号分割字符串，得到字符串数组
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringArray) {
            integerList.add(Integer.parseInt(str.trim()));
        }
        int n = integerList.size();
        int processNum = 0;
        int processStep = 0;
        int turn = 0;
        int key = 0;
        int orderPos = 0;
        String sorted = integerList.get(0).toString().replace("[", "").replace("]", "");
        String unsorted = integerList.subList(1, n).toString().replace("[", "").replace("]", "");

        InsertSort insertSort = new InsertSort();
        insertSort.setPracticeId(practiceId);
        insertSort.setUserId(userId);
        insertSort.setPivot(0);
        insertSort.setOrderPos(0);
        insertSort.setSortedList("");
        insertSort.setUnsortedList(integerList.toString().replace("[", "").replace("]", ""));
        insertSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
        insertSort.setProcessNum(0);
        insertSort.setProcessStep(0);
        insertSort.setTurn(0);
        System.out.println(insertSort);
        insertSortService.insertSort(insertSort);

        key = integerList.get(0);
        turn++;
        processNum++;
        processStep++;
        insertSort.setPivot(key);
        insertSort.setSortedList(integerList.get(0).toString());
        insertSort.setUnsortedList(integerList.subList(1, n).toString().replace("[", "").replace("]", ""));
        insertSort.setProcessNum(processNum);
        insertSort.setProcessStep(processStep + turn - 1);
        insertSort.setTurn(turn);
        System.out.println(insertSort);
        insertSortService.insertSort(insertSort);

        for (int i = 1; i < n; i++) {
            turn++;
            processStep = 0;
            key = integerList.get(i);
//            System.out.println("key:" + key);
            int j;

            for (j = i - 1; j >= 0 && integerList.get(j) > key; j--) {
                integerList.set(j + 1, key);
                processNum++;
                processStep++;
                orderPos = j + 1;
                sorted = integerList.subList(0, i + 1).toString().replace("[", "").replace("]", "");
                unsorted = integerList.subList(i + 1, n).toString().replace("[", "").replace("]", "");
                insertSort.setPivot(key);
                insertSort.setOrderPos(orderPos);
                insertSort.setSortedList(sorted);
                insertSort.setUnsortedList(unsorted);
                insertSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
                insertSort.setProcessNum(processNum);
                insertSort.setProcessStep(turn - processStep + 1);
                insertSort.setTurn(turn);
                insertSortService.insertSort(insertSort);
                integerList.set(j + 1, integerList.get(j));
            }
            integerList.set(j + 1, key);
            processNum++;
            processStep++;
            orderPos = j + 1;
            sorted = integerList.subList(0, i + 1).toString().replace("[", "").replace("]", "");
            unsorted = integerList.subList(i + 1, n).toString().replace("[", "").replace("]", "");
            insertSort.setPivot(key);
            insertSort.setOrderPos(orderPos);
            insertSort.setSortedList(sorted);
            insertSort.setUnsortedList(unsorted);
            insertSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
            insertSort.setProcessNum(processNum);
            insertSort.setProcessStep(turn - processStep + 1);
            insertSort.setTurn(turn);
            System.out.println(insertSort);
            insertSortService.insertSort(insertSort);
        }
    }

    public void insertSelect(String inputList, Integer practiceId, Integer userId){
        String[] stringArray = inputList.split(","); // 使用逗号分割字符串，得到字符串数组
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringArray) {
            integerList.add(Integer.parseInt(str.trim()));
        }

        int n = integerList.size();
        int processNum = 0;
        int processStep = 0;
        int turn = 0;
        int curPos = 0;
        int minPos = 0;
        int exchange = 0;

        SelectSort selectSort = new SelectSort();
        selectSort.setPracticeId(practiceId);
        selectSort.setUserId(userId);
        selectSort.setExchange(exchange);
        selectSort.setCurPos(curPos);
        selectSort.setMinPos(minPos);
        selectSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
        selectSort.setProcessNum(processNum);
        selectSort.setProcessStep(processStep);
        selectSort.setTurn(turn);
        System.out.println(selectSort);
        selectSortService.insertSort(selectSort);

        for (int i = 0; i < n - 1; i++) {
            turn++;
            processStep = 0;
            exchange = 0;
            curPos = i;
            minPos = i;
            selectSort.setCurPos(curPos);
            selectSort.setTurn(turn);
            for (int j = i + 1; j < n; j++) {
                if (integerList.get(j) < integerList.get(minPos)){
                    minPos = j;
                    processNum++;
                    processStep++;
                    selectSort.setProcessNum(processNum);
                    selectSort.setProcessStep(processStep + turn - 1);
                    selectSort.setExchange(exchange);
                    selectSort.setMinPos(minPos);
                    selectSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
                    selectSortService.insertSort(selectSort);
                }
            }
            if (minPos != i){
                exchange = 1;
                Collections.swap(integerList, i, minPos);
            }
            processNum++;
            processStep++;
            selectSort.setProcessNum(processNum);
            selectSort.setProcessStep(processStep + turn - 1);
            selectSort.setExchange(exchange);
            selectSort.setMinPos(minPos);
            selectSort.setCurrList(integerList.toString().replace("[", "").replace("]", ""));
            System.out.println(selectSort);
            selectSortService.insertSort(selectSort);
        }
    }
}
