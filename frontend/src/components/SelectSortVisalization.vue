<template>
  <div class="vis-container">
    <!-- <div class="btn-container1">
      <Button label="冒泡排序" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="selectButton('bubble')" :class="{'selected-button': selectedButton === 'bubble'}"  />
      <Button label="插入排序" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="selectButton('insert')" :class="{'selected-button': selectedButton === 'insert'}"  />
      <Button label="选择排序" severity="secondary" rounded style="margin-left:10px; margin-right: 10px;" @click="selectButton('select')" :class="{'selected-button': selectedButton === 'select'}"  />
    </div> -->
    <div class="sort-container" ref="sort_container">
      <svg id="sort_chart">
      </svg>
    <!-- </div>
    <div class="btn-container"> -->
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
import { getUSER } from "@/utils/loginInfo";
import { getBubbleCurList, getInsertCurList, getSelectCurList, getBubbleSolution, getInsertSolution, getSelectSolution } from "@/api/index";

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
      xScale: null,
      yScale: null,
      colorScale: null,
      index: 1,
      interval: null,
      isPlaying: false,
      chart_height: 0,
      chart_width: 0,
      //改为固定值
      selectedButton: 'select',
      solution_select: [],
      solution: []
    }
  },
mounted() {
  this.receiveList().then(() => {
    this.observeContainer(); // 确保在数据加载完后调用
  }).catch(error => {
    console.error("初始化过程中出错:", error);
  });
},
  methods: {
    observeContainer() {
    const container = this.$refs.sort_container;
    if (!container) return;

    const observer = new ResizeObserver(entries => {
      for (let entry of entries) {
        const { width, height } = entry.contentRect;
        if (width > 0 && height > 0) {
          this.drawChart();
          observer.disconnect(); // 停止观察
        }
      }
    });

    observer.observe(container);
  },
    receiveList() {
    const config = {
      headers: {
        'token': this.token,
      }
    };

    // 直接返回Promise
    return getSelectSolution({
      userId: 1,
      practiceId: this.$route.query.practiceId
    }).then((res) => {
      this.solution = res.data;
      this.solution_select = res.data; // 假设这是你需要的额外操作
      this.currList = res.data[0].currList.split(',').map(Number);
      console.log("当前列表:", this.currList);
      console.log("解决方案数据:", res.data);
    }).catch(error => {
      console.error("获取选择数据时出错:", error);
    });
  },
    addSort() {
      getSelectCurList({ userId: 1, practiceId: this.practiceId }).then(response => {
                    // console.log("当前序列0:", response.data);
                    this.sortList = response.data;
                    console.log(this.sortList)
                    console.log(111)
      })
      const config = {
        headers: {
          'token': this.token,
        },
        params: {
          sortList: this.sortList,
          practiceId: this.$route.query.practiceId,
          userId: 1,
        }
      };
      axios.post('/api/sort/add', null, config)
        .then(response => {
          console.log(response.data)
          // todo ...
         this.solution = response.data
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
          .attr("y", d => this.yScale(d)-5)
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
    .attr("transform", (d, i) => `translate(0, ${i * 20})`)
    .attr("font-size","16px");

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
  margin-top: 20px;
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
