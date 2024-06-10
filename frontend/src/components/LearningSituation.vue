<template>
    <div class="ls-container">
        <el-collapse v-model="activeNames" @change="handleChange">
            <el-collapse-item title="章节学习情况" name="1">
                <div v-for="(progress, index) in chapterProgress" :key="index" class="progress-container">
                    <div class="progress-title">{{ chapterNames[index] }}</div>
                    <div class="progress-bar">
                        <div class="progress" :style="{ width: progress + '%' }"></div>
                    </div>
                    <div class="progress-percentage">{{ progress }}%</div>
                </div>
            </el-collapse-item>
            <el-collapse-item title="7天学习时长统计图" name="2">
                <div id="barChart"></div>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
    import * as d3 from 'd3';
    import axios from 'axios';
    import dayjs from 'dayjs';

    export default {
        name: "LearningSituation",
        data() {
            return {
                activeNames: ['1','2'],
                studyData:[],//学习数据
                totalStudyData:0,
                mockStudyData: [100000, 200000, 30000, 40000, 50000, 60000, 7000],
                chapterProgress: [30, 50, 70], // 每一章的学习进度，百分比
                chapterNames: ['冒泡排序', '插入排序', '选择排序'] // 章节名称
            };
        },
        mounted() {
            this.getData()
        },
        methods: {
            handleChange(val) {
                console.log(val);
            },

            getData(){
                const config = {
                    headers: {
                        token: "user1",
                    },
                    params: {
                        userId: '2',
                        currTime: dayjs().toISOString()
                    }
                };
                axios.post('api/study-history/studytime',null, config).then(res => {
                    console.log(res);
                    this.studyData = res.data.data.slice(-7);
                    this.totalStudyData = res.data.data.slice(-1);
                    this.barChart();
                })
                    .catch(err => {
                        console.log(err);
                    })
            },

            // 生成从指定日期开始的日期数组
            generateDates(endDate, days) {
                const dates = [];
                for (let i = days - 1; i >= 0; i--) {
                    dates.push(dayjs(endDate).subtract(i, 'day').format('MM-DD'));
                }
                return dates;
            },

            barChart(){
                // 清空之前的图表
                d3.select("#barChart").selectAll("*").remove();

                // 设置图表的边距和尺寸
                const margin = { top: 20, right: 30, bottom: 60, left: 40 };
                const width = 990 - margin.left - margin.right;
                const height = 450 - margin.top - margin.bottom;

                // 设置起始日期和天数
                const endDate = dayjs(); // 当前日期
                const days = 7;
                const dates = this.generateDates(endDate, days);

                // 创建一个 SVG 元素，并将其附加到组件的引用元素中
                const svg = d3.select("#barChart")
                    .append("svg") // 添加一个 SVG 容器
                    .attr("width", width + margin.left + margin.right) // 设置 SVG 宽度
                    .attr("height", height + margin.top + margin.bottom) // 设置 SVG 高度
                    .append("g") // 添加一个分组 <g> 元素
                    .attr("transform", `translate(${margin.left},${margin.top})`); // 平移图表位置以适应边距

                // 创建 x 轴的比例尺
                const x = d3.scaleBand() // 使用带状比例尺（Band Scale）
                    .domain(dates) // 设置比例尺的输入域为最近7天的日期
                    .range([0, width]) // 设置比例尺的输出范围为图表的宽度
                    .padding(0.1); // 设置条之间的间距

                // 创建 y 轴的比例尺
                const y = d3.scaleLinear() // 使用线性比例尺（Linear Scale）
                    .domain([0, d3.max(this.mockStudyData)]) // 设置比例尺的输入域为 0 到数据的最大值
                    .nice() // 将比例尺的域值调整为适合的刻度值
                    .range([height, 0]); // 设置比例尺的输出范围为图表的高度（倒置）

                // 绘制柱状图
                svg.append("g") // 添加一个分组 <g> 元素
                    .selectAll("rect") // 选择所有的矩形元素
                    .data(this.mockStudyData) // 绑定数据
                    .enter() // 对数据的每一项执行以下操作
                    .append("rect") // 添加矩形元素
                    .attr("x", (_, i) => x(dates[i])) // 设置矩形的 x 坐标
                    .attr("y", d => y(d)) // 设置矩形的 y 坐标
                    .attr("height", d => y(0) - y(d)) // 设置矩形的高度
                    .attr("width", x.bandwidth()) // 设置矩形的宽度
                    .attr("fill", "steelblue"); // 设置矩形的填充颜色

                // 添加柱子上方的具体时长文本
                svg.append("g") // 添加一个分组 <g> 元素
                    .selectAll("text") // 选择所有的文本元素
                    .data(this.mockStudyData) // 绑定数据
                    .enter() // 对数据的每一项执行以下操作
                    .append("text") // 添加文本元素
                    .attr("x", (_, i) => x(dates[i]) + x.bandwidth() / 2) // 设置文本的 x 坐标
                    .attr("y", d => y(d) - 5) // 设置文本的 y 坐标，略高于柱子
                    .attr("text-anchor", "middle") // 设置文本的锚点为中间
                    .text(d => d3.format(",")(d)); // 设置文本内容为具体时长

                // 添加 x 轴
                svg.append("g") // 添加一个分组 <g> 元素
                    .attr("class", "x-axis") // 设置类名为 x-axis
                    .attr("transform", `translate(0,${height})`) // 将 x 轴移动到图表的底部
                    .call(d3.axisBottom(x)); // 创建并调用 x 轴生成器

                // 添加 y 轴
                svg.append("g") // 添加一个分组 <g> 元素
                    .attr("class", "y-axis") // 设置类名为 y-axis
                    .call(d3.axisLeft(y).ticks(10, 's')); // 创建并调用 y 轴生成器，并设置刻度数量和格式

                // 添加 x 轴标签
                svg.append("text") // 添加一个文本元素
                    .attr("x", width / 2) // 设置文本的 x 坐标
                    .attr("y", height + margin.bottom - 20) // 设置文本的 y 坐标，预留足够的空间
                    .attr("text-anchor", "middle") // 设置文本的锚点为中间
                    .text("7天内学习时长统计"); // 设置文本内容

                // 添加 y 轴标签
                svg.append("text") // 添加一个文本元素
                    .attr("x", -margin.left / 2 + 25) // 设置文本的 x 坐标
                    .attr("y", -margin.top / 2) // 设置文本的 y 坐标
                    .attr("text-anchor", "middle") // 设置文本的锚点为中间
                    .text("学习时长 (秒)"); // 设置文本内容
            },

        }
    }
</script>

<style scoped>
    .ls-container {
        margin: 0px 20px 20px 20px;
        width: 100%;
        height: 100%;
    }

    ::v-deep .el-collapse-item__header {
        font-size: 20px; /* 调整章节学习情况和7天学习时长统计图的字体大小 */
    }

    .progress-container {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
        margin-left:20px;
    }

    .progress-title {
        width: 80px;
        font-size: 15px;
    }

    .progress-bar {
        width: 80%;
        background-color: #e0e0e0;
        border-radius: 4px;
        overflow: hidden;
        margin-right: 10px;
    }

    .progress {
        height: 24px;
        background-color: #8dc63f;
    }

    .progress-percentage {
        width: 50px;
        text-align: right;
    }

</style>
