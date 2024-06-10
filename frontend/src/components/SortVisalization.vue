<template>
  <div class="vis-container">
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
      <!-- <Button label="addsort" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="addSort" />
      <Button label="receive list" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="receiveList" /> -->
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
      solution: [
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
          practiceId: 8,
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
          practiceId: 8,
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
        const processNum = Math.max(dataItem.processNum, 1);
        svg.append("circle")
          .attr("class", "turn-circle")
          .attr("cx", this.xScale(cur_length - turn ) + this.xScale.bandwidth() / 2)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "red");
     
        // Draw process circle
        svg.append("circle")
          .attr("class", "process-circle")
          .attr("cx", this.xScale(processNum-1) + this.xScale.bandwidth() / 4)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "green");
    },
    updateExchange(dataIndex){
      const svg = d3.select("#sort_chart")
      const currList_str = this.solution[dataIndex-1].currList;
      const currList = currList_str.split(',').map(Number);
      const cur_length = currList.length;
      const dataItem = this.solution[dataIndex];
        // Remove existing circles
        svg.selectAll(".turn-circle").remove();
        svg.selectAll(".process-circle").remove();

        // Draw turn circle
        const turn = Math.max(dataItem.turn, 1);
        const processNum = Math.max(dataItem.processNum, 1);
        svg.append("circle")
          .attr("class", "turn-circle")
          .attr("cx", this.xScale(cur_length - turn) + this.xScale.bandwidth() / 2)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "red");
     
        // Draw process circle
        svg.append("circle")
          .attr("class", "process-circle")
          .attr("cx", this.xScale(processNum ) + this.xScale.bandwidth() / 4)
          .attr("cy", this.chart_height - 10)
          .attr("r", 5)
          .attr("fill", "green");
        console.log(currList)
        // Handle exchange animation
        if (dataItem.exchange === 1) {
          const prePos = dataItem.prePos;
          const postPos = dataItem.postPos;

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
      const svg = d3.select("#sort_chart");
      svg.selectAll(".bar").remove();
      svg.selectAll(".label").remove();
      svg.selectAll(".turn-circle").remove();
      svg.selectAll(".process-circle").remove();
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
