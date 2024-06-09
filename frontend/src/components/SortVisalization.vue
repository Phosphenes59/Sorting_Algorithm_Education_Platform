<template>
  <div class="vis-container">
    <div class="sort-container" ref="sort_container">
      <svg id="sort_chart">
      </svg>
    </div>
    <div class="btn-container">
      <Button label="step back" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" />
      <Button label="Play" severity="success" rounded style="margin-left:10px; margin-right: 10px;"  />
      <Button label="Pause" severity="warning" rounded style="margin-left:10px; margin-right: 10px;" @click="receiveList" />
      <Button label="step forward" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="addSort" />
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
      solution:[
    {
        "bubbleId": 55,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "5, 8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 0,
        "userId": 3,
        "turn": 0
    },
    {
        "bubbleId": 56,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 5, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 57,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 5, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 58,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 5, 44, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 59,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 44, 5, 19, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 60,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 44, 19, 5, 0, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 61,
        "exchange": 1,
        "prePos": 5,
        "postPos": 6,
        "currList": "8, 10, 23, 44, 19, 0, 5, 2, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 62,
        "exchange": 1,
        "prePos": 6,
        "postPos": 7,
        "currList": "8, 10, 23, 44, 19, 0, 2, 5, 55, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 63,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 44, 19, 0, 2, 55, 5, 29, 33, 50, 1",
        "practiceId": 6,
        "processNum": 8,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 64,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 44, 19, 0, 2, 55, 29, 5, 33, 50, 1",
        "practiceId": 6,
        "processNum": 9,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 65,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 5, 50, 1",
        "practiceId": 6,
        "processNum": 10,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 66,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 5, 1",
        "practiceId": 6,
        "processNum": 11,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 67,
        "exchange": 1,
        "prePos": 11,
        "postPos": 12,
        "currList": "8, 10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 12,
        "userId": 3,
        "turn": 1
    },
    {
        "bubbleId": 68,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 8, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 69,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 8, 44, 19, 0, 2, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 70,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 44, 8, 19, 0, 2, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 71,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 44, 19, 8, 0, 2, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 72,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "10, 23, 44, 19, 0, 8, 2, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 73,
        "exchange": 1,
        "prePos": 5,
        "postPos": 6,
        "currList": "10, 23, 44, 19, 0, 2, 8, 55, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 74,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 44, 19, 0, 2, 55, 8, 29, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 75,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 44, 19, 0, 2, 55, 29, 8, 33, 50, 1, 5",
        "practiceId": 6,
        "processNum": 8,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 76,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 44, 19, 0, 2, 55, 29, 33, 8, 50, 1, 5",
        "practiceId": 6,
        "processNum": 9,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 77,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 8, 1, 5",
        "practiceId": 6,
        "processNum": 10,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 78,
        "exchange": 1,
        "prePos": 10,
        "postPos": 11,
        "currList": "10, 23, 44, 19, 0, 2, 55, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 11,
        "userId": 3,
        "turn": 2
    },
    {
        "bubbleId": 79,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 10, 44, 19, 0, 2, 55, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 80,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 44, 10, 19, 0, 2, 55, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 81,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 44, 19, 10, 0, 2, 55, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 82,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "23, 44, 19, 0, 10, 2, 55, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 83,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "23, 44, 19, 0, 2, 10, 55, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 84,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 44, 19, 0, 2, 55, 10, 29, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 85,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 44, 19, 0, 2, 55, 29, 10, 33, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 86,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 44, 19, 0, 2, 55, 29, 33, 10, 50, 1, 8, 5",
        "practiceId": 6,
        "processNum": 8,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 87,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "23, 44, 19, 0, 2, 55, 29, 33, 50, 10, 1, 8, 5",
        "practiceId": 6,
        "processNum": 9,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 88,
        "exchange": 1,
        "prePos": 9,
        "postPos": 10,
        "currList": "23, 44, 19, 0, 2, 55, 29, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 10,
        "userId": 3,
        "turn": 3
    },
    {
        "bubbleId": 89,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "44, 23, 19, 0, 2, 55, 29, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 90,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "44, 19, 23, 0, 2, 55, 29, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 91,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "44, 19, 0, 23, 2, 55, 29, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 92,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "44, 19, 0, 2, 23, 55, 29, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 93,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "44, 19, 0, 2, 55, 23, 29, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 94,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "44, 19, 0, 2, 55, 29, 23, 33, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 95,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "44, 19, 0, 2, 55, 29, 33, 23, 50, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 96,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "44, 19, 0, 2, 55, 29, 33, 50, 23, 1, 10, 8, 5",
        "practiceId": 6,
        "processNum": 8,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 97,
        "exchange": 1,
        "prePos": 8,
        "postPos": 9,
        "currList": "44, 19, 0, 2, 55, 29, 33, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 9,
        "userId": 3,
        "turn": 4
    },
    {
        "bubbleId": 98,
        "exchange": 1,
        "prePos": 0,
        "postPos": 1,
        "currList": "19, 44, 0, 2, 55, 29, 33, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 99,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "19, 0, 44, 2, 55, 29, 33, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 100,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "19, 0, 2, 44, 55, 29, 33, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 101,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "19, 0, 2, 55, 44, 29, 33, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 102,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "19, 0, 2, 55, 29, 44, 33, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 103,
        "exchange": 1,
        "prePos": 5,
        "postPos": 6,
        "currList": "19, 0, 2, 55, 29, 33, 44, 50, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 104,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "19, 0, 2, 55, 29, 33, 50, 44, 1, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 105,
        "exchange": 1,
        "prePos": 7,
        "postPos": 8,
        "currList": "19, 0, 2, 55, 29, 33, 50, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 8,
        "userId": 3,
        "turn": 5
    },
    {
        "bubbleId": 106,
        "exchange": 1,
        "prePos": 0,
        "postPos": 1,
        "currList": "0, 19, 2, 55, 29, 33, 50, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 107,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "0, 2, 19, 55, 29, 33, 50, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 108,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 55, 19, 29, 33, 50, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 109,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 55, 29, 19, 33, 50, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 110,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 55, 29, 33, 19, 50, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 111,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "0, 2, 55, 29, 33, 50, 19, 1, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 112,
        "exchange": 1,
        "prePos": 6,
        "postPos": 7,
        "currList": "0, 2, 55, 29, 33, 50, 1, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 6
    },
    {
        "bubbleId": 113,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 0, 55, 29, 33, 50, 1, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 114,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 55, 0, 29, 33, 50, 1, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 115,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 55, 29, 0, 33, 50, 1, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 116,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 55, 29, 33, 0, 50, 1, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 117,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 55, 29, 33, 50, 0, 1, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 118,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 55, 29, 33, 50, 1, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 6,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 119,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "2, 55, 29, 33, 50, 1, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 7,
        "userId": 3,
        "turn": 7
    },
    {
        "bubbleId": 120,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "55, 2, 29, 33, 50, 1, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 121,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "55, 29, 2, 33, 50, 1, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 122,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "55, 29, 33, 2, 50, 1, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 123,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "55, 29, 33, 50, 2, 1, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 124,
        "exchange": 1,
        "prePos": 4,
        "postPos": 5,
        "currList": "55, 29, 33, 50, 1, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 5,
        "userId": 3,
        "turn": 8
    },
    {
        "bubbleId": 125,
        "exchange": 1,
        "prePos": 0,
        "postPos": 1,
        "currList": "29, 55, 33, 50, 1, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 126,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "29, 33, 55, 50, 1, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 127,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "29, 33, 50, 55, 1, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 128,
        "exchange": 1,
        "prePos": 3,
        "postPos": 4,
        "currList": "29, 33, 50, 1, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 4,
        "userId": 3,
        "turn": 9
    },
    {
        "bubbleId": 129,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "33, 29, 50, 1, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 10
    },
    {
        "bubbleId": 130,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "33, 50, 29, 1, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 10
    },
    {
        "bubbleId": 131,
        "exchange": 1,
        "prePos": 2,
        "postPos": 3,
        "currList": "33, 50, 1, 29, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 3,
        "userId": 3,
        "turn": 10
    },
    {
        "bubbleId": 132,
        "exchange": 0,
        "prePos": 0,
        "postPos": 0,
        "currList": "50, 33, 1, 29, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 11
    },
    {
        "bubbleId": 133,
        "exchange": 1,
        "prePos": 1,
        "postPos": 2,
        "currList": "50, 1, 33, 29, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 2,
        "userId": 3,
        "turn": 11
    },
    {
        "bubbleId": 134,
        "exchange": 1,
        "prePos": 0,
        "postPos": 1,
        "currList": "1, 50, 33, 29, 55, 2, 0, 19, 44, 23, 10, 8, 5",
        "practiceId": 6,
        "processNum": 1,
        "userId": 3,
        "turn": 12
    }
],

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
          practiceId: 6,
        }
      };
      axios.post('/api/bubble-sort/solution', null, config)
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
          practiceId: 6,
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

      const containerWidth = container.clientWidth;
      const containerHeight = container.clientHeight;
      console.log('width,height',containerWidth,containerHeight);
      const chart_width = containerWidth - 30;
      const chart_height = containerHeight - 30;

      svg.attr('width', chart_width).attr('height', chart_height);

      console.log(svg);

      const xScale = d3.scaleBand()
        .domain(d3.range(this.currList.length))
        .range([0, chart_width])
        .padding(0.1);

      const yScale = d3.scaleLinear()
        .domain([0, d3.max(this.currList) + 10])
        .range([chart_height, 0]);

      const barWidth = chart_width / this.currList.length;

      const colorScale = d3.scaleSequential(d3.interpolateBlues)
        .domain([0, d3.max(this.currList)]);

      console.log(this.currList)
      svg.selectAll(".bar")
        .data(this.currList)
        .enter().append("rect")
        .attr("class", "bar")
        .attr("x", (d, i) => xScale(i))
        .attr("y", d => yScale(d))
        .attr("width", xScale.bandwidth())
        .attr("height", d => chart_height - yScale(d) || 1)
        .attr("transform","translate(0,-20)")
        .attr("fill", d => colorScale(d));

      svg.selectAll(".label")
        .data(this.currList)
        .enter().append("text")
        .attr("class", "label")
        .attr("x", (d, i) => xScale(i) + xScale.bandwidth() / 2)
        .attr("y", d => yScale(d) - 5)
        .attr("text-anchor", "middle")
        .attr("transform","translate(0,-20)")
        .text(d => d);

      svg.append("circle")
        .attr("class", "pivot-circle")
        .attr("cx", xScale(0) + xScale.bandwidth() / 2)
        .attr("cy", chart_height - 10)
        .attr("r", 5)
        .attr("fill", "red");
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
</style>
