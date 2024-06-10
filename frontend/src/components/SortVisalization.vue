<template>
  <div class="vis-container">
    <div class="btn-container1">
      <Button label="冒泡排序" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="selectButton('bubble')" :class="{'selected-button': selectedButton === 'bubble'}"  />
      <Button label="插入排序" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="selectButton('insert')" :class="{'selected-button': selectedButton === 'insert'}"  />
      <Button label="选择排序" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="selectButton('select')" :class="{'selected-button': selectedButton === 'select'}"  />
    </div>
    <div class="sort-container" ref="sort_container">
      <svg id="sort_chart">
      </svg>
    </div>
    <div class="btn-container">
      <Button label="step back" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="stepBack" />
      <Button label="Play" severity="success" rounded style="margin-left:10px; margin-right: 10px;" @click="play"  />
      <Button label="Pause" severity="warning" rounded style="margin-left:10px; margin-right: 10px;" @click="pause" />
      <Button label="Reset" severity="Info" rounded style="margin-left:10px; margin-right: 10px;" @click="reset" />
      <Button label="step forward" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="stepForward" />
      <Button label="addsort" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="addSort" />
      <Button label="receive list" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="receiveList" />
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Button from 'primevue/button';
import * as d3 from 'd3';

export default {
  name: 'SortVisualization',
  props: {
    
  },
  components: {
    Button,
  },
  data() {
    return {
      token: "user1",
      bubbleId: 2,
      currList: [5,8,10,23,44,19,0,2,55,29,33,50,1],
      solution_bubble: [
    {
        "bubbleId": 214,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 0,
        "userId": 3,
        "turn": 0
    },
    {
        "bubbleId": 215,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 216,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 217,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 218,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 219,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "5, 8, 10, 23, 19, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 220,
        "exchange": 1,
        "prePos": 5,
        "postPos": 6,
        "currList": "5, 8, 10, 23, 19, 0, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 221,
        "exchange": 1,
        "prePos": 6,
        "postPos": 7,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 7,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 222,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 55, 29, 33, 50, 1",
        "practiceId": 8,
        "processNum": 8,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 223,
        "exchange": 1,
        "prePos": 8,
        "postPos": 9,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 55, 33, 50, 1",
        "practiceId": 8,
        "processNum": 9,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 224,
        "exchange": 1,
        "prePos": 9,
        "postPos": 10,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 33, 55, 50, 1",
        "practiceId": 8,
        "processNum": 10,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 225,
        "exchange": 1,
        "prePos": 10,
        "postPos": 11,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 33, 50, 55, 1",
        "practiceId": 8,
        "processNum": 11,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 226,
        "exchange": 1,
        "prePos": 11,
        "postPos": 12,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 12,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 227,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 228,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 229,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 19, 0, 2, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 230,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "5, 8, 10, 19, 23, 0, 2, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 231,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "5, 8, 10, 19, 0, 23, 2, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 232,
        "exchange": 1,
        "prePos": 5,
        "postPos": 6,
        "currList": "5, 8, 10, 19, 0, 2, 23, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 233,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 19, 0, 2, 23, 44, 29, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 7,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 234,
        "exchange": 1,
        "prePos": 7,
        "postPos": 8,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 44, 33, 50, 1, 55",
        "practiceId": 8,
        "processNum": 8,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 235,
        "exchange": 1,
        "prePos": 8,
        "postPos": 9,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 33, 44, 50, 1, 55",
        "practiceId": 8,
        "processNum": 9,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 236,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 33, 44, 50, 1, 55",
        "practiceId": 8,
        "processNum": 10,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 237,
        "exchange": 1,
        "prePos": 10,
        "postPos": 11,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 11,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 238,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 239,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 240,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 19, 0, 2, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 241,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "5, 8, 10, 0, 19, 2, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 242,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 243,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 244,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 7,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 245,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 8,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 246,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 8,
        "processNum": 9,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 247,
        "exchange": 1,
        "prePos": 9,
        "postPos": 10,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 10,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 248,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 249,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 0, 2, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 250,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "5, 8, 0, 10, 2, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 251,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 252,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 253,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 254,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 7,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 255,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 8,
        "processNum": 8,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 256,
        "exchange": 1,
        "prePos": 8,
        "postPos": 9,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 9,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 257,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 0, 2, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 258,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "5, 0, 8, 2, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 259,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "5, 0, 2, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 260,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 0, 2, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 261,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 0, 2, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 262,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 0, 2, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 263,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 0, 2, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 7,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 264,
        "exchange": 1,
        "prePos": 7,
        "postPos": 8,
        "currList": "5, 0, 2, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 8,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 265,
        "exchange": 1,
        "prePos": 0,
        "postPos": 1,
        "currList": "0, 5, 2, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 266,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 267,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 268,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 269,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 270,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 271,
        "exchange": 1,
        "prePos": 6,
        "postPos": 7,
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 7,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 272,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 273,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 274,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 275,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 276,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 277,
        "exchange": 1,
        "prePos": 5,
        "postPos": 6,
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 6,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 278,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 279,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 280,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 281,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 282,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 5,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 283,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 284,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 285,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 286,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 4,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 287,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 10
    },
    {
        "bubbleId": 288,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 10
    },
    {
        "bubbleId": 289,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "0, 2, 1, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 3,
        "userId": 3,
        "turn": 10
    },
    {
        "bubbleId": 290,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 1, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 11
    },
    {
        "bubbleId": 291,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 2,
        "userId": 3,
        "turn": 11
    },
    {
        "bubbleId": 292,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 8,
        "processNum": 1,
        "userId": 3,
        "turn": 12
    }
],
      xScale: null,
      yScale: null,
      colorScale: null,
      index: 1,
      interval: null,
      isPlaying: false,
      chart_height: 0,
      chart_width: 0,
      selectedButton: 'insert',
      solution_insert: [
    {
        "insertId": 277,
        "pivot": 0,
        "orderPos": 0,
        "sortedList": "",
        "unsortedList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 0,
        "processStep": 0,
        "turn": 0
    },
    {
        "insertId": 278,
        "pivot": 5,
        "orderPos": 0,
        "sortedList": "5",
        "unsortedList": "8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 1,
        "processStep": 1,
        "turn": 1
    },
    {
        "insertId": 279,
        "pivot": 8,
        "orderPos": 1,
        "sortedList": "5, 8",
        "unsortedList": "10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 2,
        "processStep": 2,
        "turn": 2
    },
    {
        "insertId": 280,
        "pivot": 10,
        "orderPos": 2,
        "sortedList": "5, 8, 10",
        "unsortedList": "23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 3,
        "processStep": 3,
        "turn": 3
    },
    {
        "insertId": 281,
        "pivot": 23,
        "orderPos": 3,
        "sortedList": "5, 8, 10, 23",
        "unsortedList": "44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 4,
        "processStep": 4,
        "turn": 4
    },
    {
        "insertId": 282,
        "pivot": 44,
        "orderPos": 4,
        "sortedList": "5, 8, 10, 23, 44",
        "unsortedList": "19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 5,
        "processStep": 5,
        "turn": 5
    },
    {
        "insertId": 283,
        "pivot": 19,
        "orderPos": 5,
        "sortedList": "5, 8, 10, 23, 44, 19",
        "unsortedList": "0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 6,
        "processStep": 6,
        "turn": 6
    },
    {
        "insertId": 284,
        "pivot": 19,
        "orderPos": 4,
        "sortedList": "5, 8, 10, 23, 19, 44",
        "unsortedList": "0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 19, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 7,
        "processStep": 5,
        "turn": 6
    },
    {
        "insertId": 285,
        "pivot": 19,
        "orderPos": 3,
        "sortedList": "5, 8, 10, 19, 23, 44",
        "unsortedList": "0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 23, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 8,
        "processStep": 4,
        "turn": 6
    },
    {
        "insertId": 286,
        "pivot": 0,
        "orderPos": 6,
        "sortedList": "5, 8, 10, 19, 23, 44, 0",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 23, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 9,
        "processStep": 7,
        "turn": 7
    },
    {
        "insertId": 287,
        "pivot": 0,
        "orderPos": 5,
        "sortedList": "5, 8, 10, 19, 23, 0, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 23, 0, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 10,
        "processStep": 6,
        "turn": 7
    },
    {
        "insertId": 288,
        "pivot": 0,
        "orderPos": 4,
        "sortedList": "5, 8, 10, 19, 0, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 0, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 11,
        "processStep": 5,
        "turn": 7
    },
    {
        "insertId": 289,
        "pivot": 0,
        "orderPos": 3,
        "sortedList": "5, 8, 10, 0, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 0, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 12,
        "processStep": 4,
        "turn": 7
    },
    {
        "insertId": 290,
        "pivot": 0,
        "orderPos": 2,
        "sortedList": "5, 8, 0, 10, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 0, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 13,
        "processStep": 3,
        "turn": 7
    },
    {
        "insertId": 291,
        "pivot": 0,
        "orderPos": 1,
        "sortedList": "5, 0, 8, 10, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 0, 8, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 14,
        "processStep": 2,
        "turn": 7
    },
    {
        "insertId": 292,
        "pivot": 0,
        "orderPos": 0,
        "sortedList": "0, 5, 8, 10, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 15,
        "processStep": 1,
        "turn": 7
    },
    {
        "insertId": 293,
        "pivot": 2,
        "orderPos": 7,
        "sortedList": "0, 5, 8, 10, 19, 23, 44, 2",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 16,
        "processStep": 8,
        "turn": 8
    },
    {
        "insertId": 294,
        "pivot": 2,
        "orderPos": 6,
        "sortedList": "0, 5, 8, 10, 19, 23, 2, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 23, 2, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 17,
        "processStep": 7,
        "turn": 8
    },
    {
        "insertId": 295,
        "pivot": 2,
        "orderPos": 5,
        "sortedList": "0, 5, 8, 10, 19, 2, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 2, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 18,
        "processStep": 6,
        "turn": 8
    },
    {
        "insertId": 296,
        "pivot": 2,
        "orderPos": 4,
        "sortedList": "0, 5, 8, 10, 2, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 2, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 19,
        "processStep": 5,
        "turn": 8
    },
    {
        "insertId": 297,
        "pivot": 2,
        "orderPos": 3,
        "sortedList": "0, 5, 8, 2, 10, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 2, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 20,
        "processStep": 4,
        "turn": 8
    },
    {
        "insertId": 298,
        "pivot": 2,
        "orderPos": 2,
        "sortedList": "0, 5, 2, 8, 10, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 2, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 21,
        "processStep": 3,
        "turn": 8
    },
    {
        "insertId": 299,
        "pivot": 2,
        "orderPos": 1,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 22,
        "processStep": 2,
        "turn": 8
    },
    {
        "insertId": 300,
        "pivot": 55,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44, 55",
        "unsortedList": "29, 33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 23,
        "processStep": 9,
        "turn": 9
    },
    {
        "insertId": 301,
        "pivot": 29,
        "orderPos": 9,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29",
        "unsortedList": "33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 24,
        "processStep": 10,
        "turn": 10
    },
    {
        "insertId": 302,
        "pivot": 29,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44, 29, 55",
        "unsortedList": "33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 29, 55, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 25,
        "processStep": 9,
        "turn": 10
    },
    {
        "insertId": 303,
        "pivot": 29,
        "orderPos": 7,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55",
        "unsortedList": "33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 26,
        "processStep": 8,
        "turn": 10
    },
    {
        "insertId": 304,
        "pivot": 33,
        "orderPos": 10,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55, 33",
        "unsortedList": "50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 27,
        "processStep": 11,
        "turn": 11
    },
    {
        "insertId": 305,
        "pivot": 33,
        "orderPos": 9,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 33, 55",
        "unsortedList": "50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 33, 55, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 28,
        "processStep": 10,
        "turn": 11
    },
    {
        "insertId": 306,
        "pivot": 33,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55",
        "unsortedList": "50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 29,
        "processStep": 9,
        "turn": 11
    },
    {
        "insertId": 307,
        "pivot": 50,
        "orderPos": 11,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55, 50",
        "unsortedList": "1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 30,
        "processStep": 12,
        "turn": 12
    },
    {
        "insertId": 308,
        "pivot": 50,
        "orderPos": 10,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 31,
        "processStep": 11,
        "turn": 12
    },
    {
        "insertId": 309,
        "pivot": 1,
        "orderPos": 12,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55, 1",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 32,
        "processStep": 13,
        "turn": 13
    },
    {
        "insertId": 310,
        "pivot": 1,
        "orderPos": 11,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 1, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 1, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 33,
        "processStep": 12,
        "turn": 13
    },
    {
        "insertId": 311,
        "pivot": 1,
        "orderPos": 10,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 1, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 34,
        "processStep": 11,
        "turn": 13
    },
    {
        "insertId": 312,
        "pivot": 1,
        "orderPos": 9,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 35,
        "processStep": 10,
        "turn": 13
    },
    {
        "insertId": 313,
        "pivot": 1,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 36,
        "processStep": 9,
        "turn": 13
    },
    {
        "insertId": 314,
        "pivot": 1,
        "orderPos": 7,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 37,
        "processStep": 8,
        "turn": 13
    },
    {
        "insertId": 315,
        "pivot": 1,
        "orderPos": 6,
        "sortedList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 38,
        "processStep": 7,
        "turn": 13
    },
    {
        "insertId": 316,
        "pivot": 1,
        "orderPos": 5,
        "sortedList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 39,
        "processStep": 6,
        "turn": 13
    },
    {
        "insertId": 317,
        "pivot": 1,
        "orderPos": 4,
        "sortedList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 40,
        "processStep": 5,
        "turn": 13
    },
    {
        "insertId": 318,
        "pivot": 1,
        "orderPos": 3,
        "sortedList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 41,
        "processStep": 4,
        "turn": 13
    },
    {
        "insertId": 319,
        "pivot": 1,
        "orderPos": 2,
        "sortedList": "0, 2, 1, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 1, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 42,
        "processStep": 3,
        "turn": 13
    },
    {
        "insertId": 320,
        "pivot": 1,
        "orderPos": 1,
        "sortedList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 43,
        "processStep": 2,
        "turn": 13
    }
],
      solution_select: [
    {
        "selectId": 779,
        "exchange": 0,
        "minPos": 0,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 0,
        "processStep": 0,
        "userId": 3,
        "turn": 0
    },
    {
        "selectId": 780,
        "exchange": 0,
        "minPos": 0,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 1,
        "processStep": 2,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 781,
        "exchange": 0,
        "minPos": 0,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 2,
        "processStep": 3,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 782,
        "exchange": 0,
        "minPos": 0,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 3,
        "processStep": 4,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 783,
        "exchange": 0,
        "minPos": 0,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 4,
        "processStep": 5,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 784,
        "exchange": 0,
        "minPos": 0,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 5,
        "processStep": 6,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 785,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 6,
        "processStep": 7,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 786,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 7,
        "processStep": 8,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 787,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 8,
        "processStep": 9,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 788,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 9,
        "processStep": 10,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 789,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 10,
        "processStep": 11,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 790,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 11,
        "processStep": 12,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 791,
        "exchange": 0,
        "minPos": 6,
        "curPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 12,
        "processStep": 13,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 792,
        "exchange": 1,
        "minPos": 6,
        "curPos": 0,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 13,
        "processStep": 13,
        "userId": 3,
        "turn": 1
    },
    {
        "selectId": 793,
        "exchange": 0,
        "minPos": 1,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 14,
        "processStep": 3,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 794,
        "exchange": 0,
        "minPos": 1,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 15,
        "processStep": 4,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 795,
        "exchange": 0,
        "minPos": 1,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 16,
        "processStep": 5,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 796,
        "exchange": 0,
        "minPos": 1,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 17,
        "processStep": 6,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 797,
        "exchange": 0,
        "minPos": 6,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 18,
        "processStep": 7,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 798,
        "exchange": 0,
        "minPos": 7,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 19,
        "processStep": 8,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 799,
        "exchange": 0,
        "minPos": 7,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 20,
        "processStep": 9,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 800,
        "exchange": 0,
        "minPos": 7,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 21,
        "processStep": 10,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 801,
        "exchange": 0,
        "minPos": 7,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 22,
        "processStep": 11,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 802,
        "exchange": 0,
        "minPos": 7,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 23,
        "processStep": 12,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 803,
        "exchange": 0,
        "minPos": 12,
        "curPos": 1,
        "currList": "0, 8, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 21,
        "processNum": 24,
        "processStep": 13,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 804,
        "exchange": 1,
        "minPos": 12,
        "curPos": 1,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 25,
        "processStep": 14,
        "userId": 3,
        "turn": 2
    },
    {
        "selectId": 805,
        "exchange": 0,
        "minPos": 2,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 26,
        "processStep": 4,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 806,
        "exchange": 0,
        "minPos": 2,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 27,
        "processStep": 5,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 807,
        "exchange": 0,
        "minPos": 2,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 28,
        "processStep": 6,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 808,
        "exchange": 0,
        "minPos": 6,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 29,
        "processStep": 7,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 809,
        "exchange": 0,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 30,
        "processStep": 8,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 810,
        "exchange": 0,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 31,
        "processStep": 9,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 811,
        "exchange": 0,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 32,
        "processStep": 10,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 812,
        "exchange": 0,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 33,
        "processStep": 11,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 813,
        "exchange": 0,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 34,
        "processStep": 12,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 814,
        "exchange": 0,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 10, 23, 44, 19, 5, 2, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 35,
        "processStep": 13,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 815,
        "exchange": 1,
        "minPos": 7,
        "curPos": 2,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 36,
        "processStep": 15,
        "userId": 3,
        "turn": 3
    },
    {
        "selectId": 816,
        "exchange": 0,
        "minPos": 3,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 37,
        "processStep": 5,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 817,
        "exchange": 0,
        "minPos": 5,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 38,
        "processStep": 6,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 818,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 39,
        "processStep": 7,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 819,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 40,
        "processStep": 8,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 820,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 41,
        "processStep": 9,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 821,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 42,
        "processStep": 10,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 822,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 43,
        "processStep": 11,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 823,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 44,
        "processStep": 12,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 824,
        "exchange": 0,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 23, 44, 19, 5, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 45,
        "processStep": 13,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 825,
        "exchange": 1,
        "minPos": 6,
        "curPos": 3,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 46,
        "processStep": 16,
        "userId": 3,
        "turn": 4
    },
    {
        "selectId": 826,
        "exchange": 0,
        "minPos": 5,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 47,
        "processStep": 6,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 827,
        "exchange": 0,
        "minPos": 5,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 48,
        "processStep": 7,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 828,
        "exchange": 0,
        "minPos": 7,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 49,
        "processStep": 8,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 829,
        "exchange": 0,
        "minPos": 7,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 50,
        "processStep": 9,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 830,
        "exchange": 0,
        "minPos": 7,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 51,
        "processStep": 10,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 831,
        "exchange": 0,
        "minPos": 7,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 52,
        "processStep": 11,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 832,
        "exchange": 0,
        "minPos": 7,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 53,
        "processStep": 12,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 833,
        "exchange": 0,
        "minPos": 12,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 44, 19, 23, 10, 55, 29, 33, 50, 8",
        "practiceId": 21,
        "processNum": 54,
        "processStep": 13,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 834,
        "exchange": 1,
        "minPos": 12,
        "curPos": 4,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 55,
        "processStep": 17,
        "userId": 3,
        "turn": 5
    },
    {
        "selectId": 835,
        "exchange": 0,
        "minPos": 5,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 56,
        "processStep": 7,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 836,
        "exchange": 0,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 57,
        "processStep": 8,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 837,
        "exchange": 0,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 58,
        "processStep": 9,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 838,
        "exchange": 0,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 59,
        "processStep": 10,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 839,
        "exchange": 0,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 60,
        "processStep": 11,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 840,
        "exchange": 0,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 61,
        "processStep": 12,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 841,
        "exchange": 0,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 19, 23, 10, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 62,
        "processStep": 13,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 842,
        "exchange": 1,
        "minPos": 7,
        "curPos": 5,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 63,
        "processStep": 18,
        "userId": 3,
        "turn": 6
    },
    {
        "selectId": 843,
        "exchange": 0,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 64,
        "processStep": 8,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 844,
        "exchange": 0,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 65,
        "processStep": 9,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 845,
        "exchange": 0,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 66,
        "processStep": 10,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 846,
        "exchange": 0,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 67,
        "processStep": 11,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 847,
        "exchange": 0,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 68,
        "processStep": 12,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 848,
        "exchange": 0,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 23, 19, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 69,
        "processStep": 13,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 849,
        "exchange": 1,
        "minPos": 7,
        "curPos": 6,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 70,
        "processStep": 19,
        "userId": 3,
        "turn": 7
    },
    {
        "selectId": 850,
        "exchange": 0,
        "minPos": 7,
        "curPos": 7,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 71,
        "processStep": 9,
        "userId": 3,
        "turn": 8
    },
    {
        "selectId": 851,
        "exchange": 0,
        "minPos": 7,
        "curPos": 7,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 72,
        "processStep": 10,
        "userId": 3,
        "turn": 8
    },
    {
        "selectId": 852,
        "exchange": 0,
        "minPos": 7,
        "curPos": 7,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 73,
        "processStep": 11,
        "userId": 3,
        "turn": 8
    },
    {
        "selectId": 853,
        "exchange": 0,
        "minPos": 7,
        "curPos": 7,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 74,
        "processStep": 12,
        "userId": 3,
        "turn": 8
    },
    {
        "selectId": 854,
        "exchange": 0,
        "minPos": 7,
        "curPos": 7,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 75,
        "processStep": 13,
        "userId": 3,
        "turn": 8
    },
    {
        "selectId": 855,
        "exchange": 0,
        "minPos": 7,
        "curPos": 7,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 76,
        "processStep": 20,
        "userId": 3,
        "turn": 8
    },
    {
        "selectId": 856,
        "exchange": 0,
        "minPos": 9,
        "curPos": 8,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 77,
        "processStep": 10,
        "userId": 3,
        "turn": 9
    },
    {
        "selectId": 857,
        "exchange": 0,
        "minPos": 9,
        "curPos": 8,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 78,
        "processStep": 11,
        "userId": 3,
        "turn": 9
    },
    {
        "selectId": 858,
        "exchange": 0,
        "minPos": 9,
        "curPos": 8,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 79,
        "processStep": 12,
        "userId": 3,
        "turn": 9
    },
    {
        "selectId": 859,
        "exchange": 0,
        "minPos": 9,
        "curPos": 8,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 55, 29, 33, 50, 44",
        "practiceId": 21,
        "processNum": 80,
        "processStep": 13,
        "userId": 3,
        "turn": 9
    },
    {
        "selectId": 860,
        "exchange": 1,
        "minPos": 9,
        "curPos": 8,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 55, 33, 50, 44",
        "practiceId": 21,
        "processNum": 81,
        "processStep": 21,
        "userId": 3,
        "turn": 9
    },
    {
        "selectId": 861,
        "exchange": 0,
        "minPos": 10,
        "curPos": 9,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 55, 33, 50, 44",
        "practiceId": 21,
        "processNum": 82,
        "processStep": 11,
        "userId": 3,
        "turn": 10
    },
    {
        "selectId": 862,
        "exchange": 0,
        "minPos": 10,
        "curPos": 9,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 55, 33, 50, 44",
        "practiceId": 21,
        "processNum": 83,
        "processStep": 12,
        "userId": 3,
        "turn": 10
    },
    {
        "selectId": 863,
        "exchange": 0,
        "minPos": 10,
        "curPos": 9,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 55, 33, 50, 44",
        "practiceId": 21,
        "processNum": 84,
        "processStep": 13,
        "userId": 3,
        "turn": 10
    },
    {
        "selectId": 864,
        "exchange": 1,
        "minPos": 10,
        "curPos": 9,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 55, 50, 44",
        "practiceId": 21,
        "processNum": 85,
        "processStep": 22,
        "userId": 3,
        "turn": 10
    },
    {
        "selectId": 865,
        "exchange": 0,
        "minPos": 11,
        "curPos": 10,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 55, 50, 44",
        "practiceId": 21,
        "processNum": 86,
        "processStep": 12,
        "userId": 3,
        "turn": 11
    },
    {
        "selectId": 866,
        "exchange": 0,
        "minPos": 12,
        "curPos": 10,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 55, 50, 44",
        "practiceId": 21,
        "processNum": 87,
        "processStep": 13,
        "userId": 3,
        "turn": 11
    },
    {
        "selectId": 867,
        "exchange": 1,
        "minPos": 12,
        "curPos": 10,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 21,
        "processNum": 88,
        "processStep": 23,
        "userId": 3,
        "turn": 11
    },
    {
        "selectId": 868,
        "exchange": 0,
        "minPos": 11,
        "curPos": 11,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 21,
        "processNum": 89,
        "processStep": 13,
        "userId": 3,
        "turn": 12
    },
    {
        "selectId": 869,
        "exchange": 0,
        "minPos": 11,
        "curPos": 11,
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 21,
        "processNum": 90,
        "processStep": 24,
        "userId": 3,
        "turn": 12
    }
],
      solution: [
    {
        "insertId": 277,
        "pivot": 0,
        "orderPos": 0,
        "sortedList": "",
        "unsortedList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 0,
        "processStep": 0,
        "turn": 0
    },
    {
        "insertId": 278,
        "pivot": 5,
        "orderPos": 0,
        "sortedList": "5",
        "unsortedList": "8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 1,
        "processStep": 1,
        "turn": 1
    },
    {
        "insertId": 279,
        "pivot": 8,
        "orderPos": 1,
        "sortedList": "5, 8",
        "unsortedList": "10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 2,
        "processStep": 2,
        "turn": 2
    },
    {
        "insertId": 280,
        "pivot": 10,
        "orderPos": 2,
        "sortedList": "5, 8, 10",
        "unsortedList": "23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 3,
        "processStep": 3,
        "turn": 3
    },
    {
        "insertId": 281,
        "pivot": 23,
        "orderPos": 3,
        "sortedList": "5, 8, 10, 23",
        "unsortedList": "44, 19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 4,
        "processStep": 4,
        "turn": 4
    },
    {
        "insertId": 282,
        "pivot": 44,
        "orderPos": 4,
        "sortedList": "5, 8, 10, 23, 44",
        "unsortedList": "19, 0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 5,
        "processStep": 5,
        "turn": 5
    },
    {
        "insertId": 283,
        "pivot": 19,
        "orderPos": 5,
        "sortedList": "5, 8, 10, 23, 44, 19",
        "unsortedList": "0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 6,
        "processStep": 6,
        "turn": 6
    },
    {
        "insertId": 284,
        "pivot": 19,
        "orderPos": 4,
        "sortedList": "5, 8, 10, 23, 19, 44",
        "unsortedList": "0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 23, 19, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 7,
        "processStep": 5,
        "turn": 6
    },
    {
        "insertId": 285,
        "pivot": 19,
        "orderPos": 3,
        "sortedList": "5, 8, 10, 19, 23, 44",
        "unsortedList": "0, 2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 23, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 8,
        "processStep": 4,
        "turn": 6
    },
    {
        "insertId": 286,
        "pivot": 0,
        "orderPos": 6,
        "sortedList": "5, 8, 10, 19, 23, 44, 0",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 23, 44, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 9,
        "processStep": 7,
        "turn": 7
    },
    {
        "insertId": 287,
        "pivot": 0,
        "orderPos": 5,
        "sortedList": "5, 8, 10, 19, 23, 0, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 23, 0, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 10,
        "processStep": 6,
        "turn": 7
    },
    {
        "insertId": 288,
        "pivot": 0,
        "orderPos": 4,
        "sortedList": "5, 8, 10, 19, 0, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 19, 0, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 11,
        "processStep": 5,
        "turn": 7
    },
    {
        "insertId": 289,
        "pivot": 0,
        "orderPos": 3,
        "sortedList": "5, 8, 10, 0, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 10, 0, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 12,
        "processStep": 4,
        "turn": 7
    },
    {
        "insertId": 290,
        "pivot": 0,
        "orderPos": 2,
        "sortedList": "5, 8, 0, 10, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 8, 0, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 13,
        "processStep": 3,
        "turn": 7
    },
    {
        "insertId": 291,
        "pivot": 0,
        "orderPos": 1,
        "sortedList": "5, 0, 8, 10, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "5, 0, 8, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 14,
        "processStep": 2,
        "turn": 7
    },
    {
        "insertId": 292,
        "pivot": 0,
        "orderPos": 0,
        "sortedList": "0, 5, 8, 10, 19, 23, 44",
        "unsortedList": "2, 55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 15,
        "processStep": 1,
        "turn": 7
    },
    {
        "insertId": 293,
        "pivot": 2,
        "orderPos": 7,
        "sortedList": "0, 5, 8, 10, 19, 23, 44, 2",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 23, 44, 2, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 16,
        "processStep": 8,
        "turn": 8
    },
    {
        "insertId": 294,
        "pivot": 2,
        "orderPos": 6,
        "sortedList": "0, 5, 8, 10, 19, 23, 2, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 23, 2, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 17,
        "processStep": 7,
        "turn": 8
    },
    {
        "insertId": 295,
        "pivot": 2,
        "orderPos": 5,
        "sortedList": "0, 5, 8, 10, 19, 2, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 19, 2, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 18,
        "processStep": 6,
        "turn": 8
    },
    {
        "insertId": 296,
        "pivot": 2,
        "orderPos": 4,
        "sortedList": "0, 5, 8, 10, 2, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 10, 2, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 19,
        "processStep": 5,
        "turn": 8
    },
    {
        "insertId": 297,
        "pivot": 2,
        "orderPos": 3,
        "sortedList": "0, 5, 8, 2, 10, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 8, 2, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 20,
        "processStep": 4,
        "turn": 8
    },
    {
        "insertId": 298,
        "pivot": 2,
        "orderPos": 2,
        "sortedList": "0, 5, 2, 8, 10, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 5, 2, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 21,
        "processStep": 3,
        "turn": 8
    },
    {
        "insertId": 299,
        "pivot": 2,
        "orderPos": 1,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44",
        "unsortedList": "55, 29, 33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 22,
        "processStep": 2,
        "turn": 8
    },
    {
        "insertId": 300,
        "pivot": 55,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44, 55",
        "unsortedList": "29, 33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 23,
        "processStep": 9,
        "turn": 9
    },
    {
        "insertId": 301,
        "pivot": 29,
        "orderPos": 9,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29",
        "unsortedList": "33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 55, 29, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 24,
        "processStep": 10,
        "turn": 10
    },
    {
        "insertId": 302,
        "pivot": 29,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 44, 29, 55",
        "unsortedList": "33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 44, 29, 55, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 25,
        "processStep": 9,
        "turn": 10
    },
    {
        "insertId": 303,
        "pivot": 29,
        "orderPos": 7,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55",
        "unsortedList": "33, 50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 26,
        "processStep": 8,
        "turn": 10
    },
    {
        "insertId": 304,
        "pivot": 33,
        "orderPos": 10,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55, 33",
        "unsortedList": "50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 55, 33, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 27,
        "processStep": 11,
        "turn": 11
    },
    {
        "insertId": 305,
        "pivot": 33,
        "orderPos": 9,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 33, 55",
        "unsortedList": "50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 44, 33, 55, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 28,
        "processStep": 10,
        "turn": 11
    },
    {
        "insertId": 306,
        "pivot": 33,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55",
        "unsortedList": "50, 1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 29,
        "processStep": 9,
        "turn": 11
    },
    {
        "insertId": 307,
        "pivot": 50,
        "orderPos": 11,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55, 50",
        "unsortedList": "1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 55, 50, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 30,
        "processStep": 12,
        "turn": 12
    },
    {
        "insertId": 308,
        "pivot": 50,
        "orderPos": 10,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "1",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 31,
        "processStep": 11,
        "turn": 12
    },
    {
        "insertId": 309,
        "pivot": 1,
        "orderPos": 12,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55, 1",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55, 1",
        "practiceId": 14,
        "userId": 3,
        "processNum": 32,
        "processStep": 13,
        "turn": 13
    },
    {
        "insertId": 310,
        "pivot": 1,
        "orderPos": 11,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 1, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 1, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 33,
        "processStep": 12,
        "turn": 13
    },
    {
        "insertId": 311,
        "pivot": 1,
        "orderPos": 10,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 1, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 44, 1, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 34,
        "processStep": 11,
        "turn": 13
    },
    {
        "insertId": 312,
        "pivot": 1,
        "orderPos": 9,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 33, 1, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 35,
        "processStep": 10,
        "turn": 13
    },
    {
        "insertId": 313,
        "pivot": 1,
        "orderPos": 8,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 29, 1, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 36,
        "processStep": 9,
        "turn": 13
    },
    {
        "insertId": 314,
        "pivot": 1,
        "orderPos": 7,
        "sortedList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 23, 1, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 37,
        "processStep": 8,
        "turn": 13
    },
    {
        "insertId": 315,
        "pivot": 1,
        "orderPos": 6,
        "sortedList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 19, 1, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 38,
        "processStep": 7,
        "turn": 13
    },
    {
        "insertId": 316,
        "pivot": 1,
        "orderPos": 5,
        "sortedList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 10, 1, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 39,
        "processStep": 6,
        "turn": 13
    },
    {
        "insertId": 317,
        "pivot": 1,
        "orderPos": 4,
        "sortedList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 8, 1, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 40,
        "processStep": 5,
        "turn": 13
    },
    {
        "insertId": 318,
        "pivot": 1,
        "orderPos": 3,
        "sortedList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 5, 1, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 41,
        "processStep": 4,
        "turn": 13
    },
    {
        "insertId": 319,
        "pivot": 1,
        "orderPos": 2,
        "sortedList": "0, 2, 1, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 2, 1, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 42,
        "processStep": 3,
        "turn": 13
    },
    {
        "insertId": 320,
        "pivot": 1,
        "orderPos": 1,
        "sortedList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "unsortedList": "",
        "currList": "0, 1, 2, 5, 8, 10, 19, 23, 29, 33, 44, 50, 55",
        "practiceId": 14,
        "userId": 3,
        "processNum": 43,
        "processStep": 2,
        "turn": 13
    }
]
    }
  },
  mounted() {
    this.drawChart();
  },
  methods: {
    receiveList() {
      const config = {
        headers: {
          'token': this.token,
        },
        params: {
          userId: 3,
          practiceId: 21,
        }
      };
      axios.post(`/api/${this.selectedButton}-sort/solution`, null, config)
        .then(response => {
          console.log(response.data)
          // todo ...
         // this.solution = response.data
        })
        .catch(error => {
          console.error("There was an error!", error)
        })
    },
    addSort() {
      const config = {
        headers: {
          'token': this.token,
        },
        params: {
          sortList: "5,8,10,23,44,19,0,2,55,29,33,50,1",
          practiceId: 21,
          userId: 3,
        }
      };
      axios.post('/api/sort/add', null, config)
        .then(response => {
          console.log(response.data)
          // todo ...
         // this.solution = response.data
        })
        .catch(error => {
          console.error("There was an error!", error)
        })
    },
    drawChart() {
      const container = this.$refs.sort_container;
      const svg = d3.select("#sort_chart");
      const t_this = this;
      // Clear the svg
      svg.selectAll("*").remove();

      const containerWidth = container.clientWidth;
      const containerHeight = container.clientHeight;
      console.log('width,height',containerWidth,containerHeight);
      this.chart_width = containerWidth - 30;
      this.chart_height = containerHeight - 30;

      svg.attr('width', this.chart_width).attr('height', this.chart_height);

      this.xScale = d3.scaleBand()
        .range([0, this.chart_width])
        .padding(0.1);

      this.yScale = d3.scaleLinear()
        .range([this.chart_height, 0]);

      this.colorScale = d3.scaleSequential(d3.interpolateBlues);


      //
      const dataItem = this.solution[0];
      const currList = dataItem.currList.split(',').map(Number);
      const cur_length = currList.length;
      this.xScale.domain(d3.range(currList.length));
      this.yScale.domain([0, d3.max(currList) + 10]);
      this.colorScale.domain([0, d3.max(currList)]);

      const bars = svg.selectAll(".bar")
        .data(currList, (d, i) => i);
        
        bars.enter().append("rect")
          .attr("class", "bar")
          .attr("x", (d, i) => this.xScale(i))
          .attr("y", d => this.yScale(d))
          .attr("width", this.xScale.bandwidth())
          .attr("height", d => this.chart_height - this.yScale(d) || 1)
          .attr("transform","translate(0,-20)")
          .attr("fill", d => this.colorScale(d));

        bars.exit().remove();

        const labels = svg.selectAll(".label")
          .data(currList, (d, i) => i);
        
        labels.enter().append("text")
          .attr("class", "label")
          .attr("x", (d, i) => this.xScale(i) + this.xScale.bandwidth() / 2)
          .attr("y", d => this.yScale(d) - 5)
          .attr("text-anchor", "middle")
          .attr("transform","translate(0,-20)")
          .text(d => d);


        labels.exit().remove();

        const turn = Math.max(dataItem.turn, 1);
        let processNum = Math.max(dataItem.processNum, 1);
        if(this.selectedButton == 'bubble') {
          processNum = Math.max(dataItem.processNum, 1);
        } else if(this.selectedButton == 'insert') {
          processNum = Math.max(dataItem.processStep,1);
        }else if(this.selectedButton == 'select') {
          processNum = Math.max(dataItem.processStep,1);
        }
        svg.append("circle")
          .attr("class", "turn-circle")
          .attr("cx", this.xScale(t_this.calculateTurnX(0,turn,cur_length)) + this.xScale.bandwidth() / 2)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "red");
     
        // Draw process circle
        svg.append("circle")
          .attr("class", "process-circle")
          .attr("cx", this.xScale(t_this.calculateProcessX(0,processNum,cur_length)) + this.xScale.bandwidth() / 4)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "green");
        
        // Add legend
        const legend = svg.append("g")
          .attr("class", "legend")
          .attr("transform", `translate(20, 20)`);

        const legendData = [
          { color: "red", text: "轮数" },
          { color: "green", text: "步数" }
        ];

  if (this.selectedButton == 'select') {
    const minPos = dataItem.minPos;
    svg.append("circle")
      .attr("class", "minpos-circle")
      .attr("cx", this.xScale(minPos) + this.xScale.bandwidth() / 4 * 3)
      .attr("cy", this.chart_height - 10)
      .attr("r", 5)
      .attr("fill", "pink");

    legendData.push({ color: "pink", text: "最小点" });
  }

  const legendItem = legend.selectAll(".legend-item")
    .data(legendData)
    .enter().append("g")
    .attr("class", "legend-item")
    .attr("transform", (d, i) => `translate(0, ${i * 20})`);

  legendItem.append("circle")
    .attr("cx", 0)
    .attr("cy", 0)
    .attr("r", 5)
    .attr("fill", d => d.color);

  legendItem.append("text")
    .attr("x", 10)
    .attr("y", 5)
    .text(d => d.text)
    .attr("fill","#475569");


    },
    updateExchange(dataIndex){
      const t_this = this;
      const svg = d3.select("#sort_chart")
      const currList_str = this.solution[dataIndex-1].currList;
      const currList = currList_str.split(',').map(Number);
      const cur_length = currList.length;
      const dataItem = this.solution[dataIndex];
        // Remove existing circles
        svg.selectAll(".turn-circle").remove();
        svg.selectAll(".process-circle").remove();
        svg.selectAll(".minpos-circle").remove();

        // Draw turn circle
        const turn = Math.max(dataItem.turn, 1);
        let processNum = Math.max(dataItem.processNum, 1);
        if(this.selectedButton == 'bubble') {
          processNum = Math.max(dataItem.processNum, 1);
        } else if(this.selectedButton == 'insert') {
          processNum = Math.max(dataItem.processStep,1);
        }else if(this.selectedButton == 'select') {
          processNum = Math.max(dataItem.processStep,1);
        }
        svg.append("circle")
          .attr("class", "turn-circle")
          .attr("cx", this.xScale(t_this.calculateTurnX(dataIndex,turn,cur_length)) + this.xScale.bandwidth() / 2)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "red");
     
        // Draw process circle
        svg.append("circle")
          .attr("class", "process-circle")
          .attr("cx", this.xScale(t_this.calculateProcessX(dataIndex,processNum,cur_length)) + this.xScale.bandwidth() / 4)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "green");
        if(this.selectedButton == 'select') {
          const minPos = dataItem.minPos
          svg.append("circle")
            .attr("class", "minpos-circle")
            .attr("cx", this.xScale(minPos) + this.xScale.bandwidth() / 4 * 3)
            .attr("cy", this.chart_height - 10)
            .attr("r", 5)
            .attr("fill", "pink");
        }
        console.log(currList)
        // Handle exchange animation
        if (this.isExchange(dataItem)) {
          const prePos = this.getPrePos(dataItem);
          const postPos = this.getPostPos(dataItem);

          console.log("要交换啦",currList[prePos],currList[postPos],[prePos,postPos]);

          const preBar = svg.selectAll(".bar").filter(function(d, i) {
            if (i === prePos) {
              console.log(i, d)
            }
          return i === prePos});
          const postBar = svg.selectAll(".bar").filter((d, i) => i === postPos);
          console.log(preBar,postBar)
          const preLabel = svg.selectAll(".label").filter((d, i) => i === prePos);
          const postLabel = svg.selectAll(".label").filter((d, i) => i === postPos);


          preBar.transition().duration(300)
            .attr("x", this.xScale(postPos));
          
          preLabel.transition().duration(300)
            .attr("x",this.xScale(postPos) + this.xScale.bandwidth() / 2)

          postBar.transition().duration(300)
            .attr("x", this.xScale(prePos));
          postLabel.transition().duration(300)
            .attr("x",this.xScale(prePos) + this.xScale.bandwidth() / 2)

          // Update data binding
          const new_list = this.solution[dataIndex].currList.split(',').map(Number);
          console.log(new_list);
          svg.selectAll(".bar").remove();
          svg.selectAll(".label").remove();
          const bars = svg.selectAll(".bar")
        .data(new_list, (d, i) => i);
        
        bars.enter().append("rect")
          .attr("class", "bar")
          .attr("x", (d, i) => this.xScale(i))
          .attr("y", d => this.yScale(d))
          .attr("width", this.xScale.bandwidth())
          .attr("height", d => this.chart_height - this.yScale(d) || 1)
          .attr("transform","translate(0,-20)")
          .attr("fill", d => this.colorScale(d));

        bars.exit().remove();

        const labels = svg.selectAll(".label")
          .data(new_list, (d, i) => i);
        
        labels.enter().append("text")
          .attr("class", "label")
          .attr("x", (d, i) => this.xScale(i) + this.xScale.bandwidth() / 2)
          .attr("y", d => this.yScale(d) - 5)
          .attr("text-anchor", "middle")
          .attr("transform","translate(0,-20)")
          .text(d => d);
          console.log(svg.selectAll(".bar"))
        }
    },
    startAnimation(){
      this.interval = setInterval(() => {
        if (this.index < this.solution.length) {
          this.updateExchange(this.index);
          this.index++;
        } else {
          clearInterval(this.interval);
          this.isPlaying = false;
        }
      }, 1000);
    },
    play() {
      if (!this.isPlaying) {
        this.isPlaying = true;
        this.startAnimation();
      }
    },
    pause() {
      if (this.isPlaying) {
        clearInterval(this.interval);
        this.isPlaying = false;
      }
    },
    reset() {
      this.index = 1;
      this.pause();
      this.drawChart();
    },
    stepBack() {
      this.pause();
      if(this.index >= 2) {
        this.index--;
        const svg = d3.select("#sort_chart");
        svg.selectAll(".bar").remove();
        svg.selectAll(".label").remove();
        svg.selectAll(".turn-circle").remove();
        svg.selectAll(".process-circle").remove();
        this.drawChart();
        this.updateExchange(this.index);
      }
      console.log(this.index);
    },
    stepForward() {
      this.pause();
      console.log(this.index,this.solution.length);
      if(this.index < this.solution.length) {
        this.index++;
        const svg = d3.select("#sort_chart");
        svg.selectAll(".bar").remove();
        svg.selectAll(".label").remove();
        svg.selectAll(".turn-circle").remove();
        svg.selectAll(".process-circle").remove();
        this.drawChart();
        this.updateExchange(this.index);
      } else{
        this.index = 1;
        const svg = d3.select("#sort_chart");
        svg.selectAll(".bar").remove();
        svg.selectAll(".label").remove();
        svg.selectAll(".turn-circle").remove();
        svg.selectAll(".process-circle").remove();
        this.drawChart();
      }
      console.log(this.index);
    },
    selectButton(button) {
      this.selectedButton = button;
      if (button === 'bubble') {
        this.goBubble();
      } else if (button === 'insert') {
        this.goInsert();
      } else if (button === 'select') {
        this.goSelect();
      }
    },
    goBubble() {
      this.pause();
      this.index = 1;
      this.solution = this.solution_bubble;
      this.drawChart();
    },
    goInsert() {
      this.pause();
      this.index = 1;
      this.solution = this.solution_insert;
      this.drawChart();
    },
    goSelect() {
      this.pause();
      this.index = 1;
      this.solution = this.solution_select;
      this.drawChart();
    },
    calculateTurnX(index,turn, cur_length) {
      console.log("turn",turn)
      if(this.selectedButton == 'bubble') {
        return cur_length - turn;
      } else if(this.selectedButton == 'insert') {
        return turn - 1;
      } else if(this.selectedButton == 'select') {
        return turn -1;
      } else {
        return turn -1;
      }
    },
    calculateProcessX(index,processNum, cur_length) {
      processNum = processNum > cur_length? cur_length: processNum;
      if(this.selectedButton == 'bubble') {
        if(index == 0) {
          return processNum - 1;
          
        }
        else {
          return processNum;
        }
      } else if(this.selectedButton == 'insert') {
        return processNum - 1;
      } else if(this.selectedButton == 'select') {
        if(index == 0) {
          return 1;
        }
        else {
          return processNum -1;
        }
      } else {
        return processNum -1;
      }
    },
    isExchange(dataItem) {
      if(this.selectedButton == 'bubble') {
        return dataItem.exchange == 1;
      } else if(this.selectedButton == 'insert') {
        return dataItem.turn != dataItem.processStep;
      } else if(this.selectedButton == 'select') {
        return dataItem.exchange == 1;
      }
    },
    getPrePos(dataItem) {
      if(this.selectedButton == 'bubble') {
        return dataItem.prePos;
      } else if(this.selectedButton == 'insert') {
        return dataItem.orderPos;
      } else if(this.selectedButton == 'select') {
        return dataItem.turn - 1;
      }
    },
    getPostPos(dataItem) {
      if(this.selectedButton == 'bubble') {
        return dataItem.postPos;
      } else if(this.selectedButton == 'insert') {
        return dataItem.processStep;
      } else if(this.selectedButton == 'select') {
        return dataItem.minPos;
      }
    }
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.vis-container {
  width: 100%;
  height: 100%;
  align-items: center;
  margin-top: 80px;
}
.btn-container {
  bottom: 20px;
  display: flex;
  width: 100%;
  height: 50px;
  padding: 10px 100px 0 100px;
  position: fixed;
  margin: auto;
  justify-content: center;
  align-items: center;
}
.btn-container1 {
  top: 20px;
  display: flex;
  width: 100%;
  height: 50px;
  padding: 10px 100px 0 100px;
  position: fixed;
  margin: auto;
  justify-content: center;
  align-items: center;
}
.sort-container {
  width: 100%;
  padding: 100px 200px 100px 200px;
  background-color: aliceblue;
  height: 500px;
  padding: 15px;
}
#sort_chart{ 
  background-color: rgb(255, 244, 229);
}
.selected-button {
  background-color: #c5c5c5; /* Example selected color */
  color: white;
}
</style>
