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
      solution: null,

    }
  },
  mounted() {
    this.drawChart();
  },
  methods: {
    receiveList() {
      axios.post('/api/sort/add', {
          sortList: "5,8,10,23,44,19,0,2,55,29,33,50,1",
          practiceId: 5,
          userId: 5,
        }, {
          headers: {
            'token': this.token
          }
        })
        .then(response => {
          console.log(response.data)
        })
        .catch(error => {
          console.error("There was an error!", error)
        })
    },
    addSort() {
      axios.post('/api/sort/add',{
        headers: {
          'token': this.token,
        },
        params: {
          sortList: "5,8,10,23,44,19,0,2,55,29,33,50,1",
          practiceId: 5,
          userId: 5,
        }
      })
      .then(res => {
        console.log(res.data)
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
