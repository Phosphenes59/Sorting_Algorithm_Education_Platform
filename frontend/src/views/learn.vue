<template slot-scope="scope">
    <mainContainer>
        <el-row class="main">
            <!-- 这里显示题目动画 -->
            <el-col :span="18" v-if="id === '0'">
                <el-row>
                    <el-tag size="large" class="tag" type="warning" @click="open">冒泡排序</el-tag>
                    <el-tag size="large" class="tag" type="success" @click="goback">我的学习</el-tag>
                </el-row>
                <BubbleSortVisalization />
            </el-col>
            <el-col :span="18" v-if="id === '1'">
                <el-row>
                    <el-tag size="large" class="tag" type="warning" @click="open">插入排序</el-tag>
                    <el-tag size="large" class="tag" type="success" @click="goback">我的学习</el-tag>
                </el-row>
                <InsertSortVisalization />
            </el-col>
            <el-col :span="18" v-show="id === '2'">
                <el-row>
                    <el-tag size="large" class="tag" type="warning" @click="open">选择排序</el-tag>
                    <el-tag size="large" class="tag" type="success" @click="goback">我的学习</el-tag>
                </el-row>
                <SelectSortVisalization />
            </el-col>


            <el-col :span='5' :offset="1" class="content">
                <div class="card">
                    <div class="header">
                        <div class="card-header">
                            <span>题目：<br />
                                <span class="sortlist">[{{ " " + rawList + " " }}]</span>
                            </span>
                        </div>
                        <el-divider />
                    </div>
                    <el-row class="empty">
                        <el-col :span="3" :offset="21">
                            <el-icon class="icon" @click="open">
                                <QuestionFilled />
                            </el-icon></el-col>
                    </el-row>
                </div>
            </el-col>
        </el-row>
    </mainContainer>
</template>


<script>
// import SortVisalization from "@/components/SortVisalization.vue";
import BubbleSortVisalization from "@/components/BubbleSortVisalization.vue";
import InsertSortVisalization from "@/components/InsertSortVisalization.vue";
import SelectSortVisalization from "@/components/SelectSortVisalization.vue";
import { ElNotification } from 'element-plus';
import { getBubbleCurList, getInsertCurList, getSelectCurList } from "@/api/index";
import { getUSER } from "@/utils/loginInfo";

export default {
    name: "learnPage",
    components: {
        BubbleSortVisalization, InsertSortVisalization, SelectSortVisalization
    },
    data() {
        return {
            //id  为0时是冒泡   为 1时是插入   为2是选择
            id: '0',
            //题目序号
            practiceId: '',
            //题目序列
            rawList: '',
            //帮助信息
            message: 'help',
        }
    },
    mounted() {
        this.id = this.$route.query.id;
        this.practiceId = this.$route.query.practiceId;
        this.getList();
    },
    methods: {
        getList() {
            let userId = getUSER();
            //实际上应该都是一样，还是接口分情况
            if (this.id === '0') {
                getBubbleCurList({ userId: userId, practiceId: this.practiceId }).then(response => {
                    // console.log("当前序列0", response.data);
                    this.rawList = response.data;
                    this.message = 
                    `
                    <div>
                       <div><strong>冒泡排序:</strong></div>
                     <ul>
                     <li>比较相邻的两个元素,如果顺序错误就交换它们;</li>
                     <li>对未排序的部分重复上述步骤,直到整个序列有序。</li>
                     </ul>
                     <div><strong>时间复杂度:O(n^2)</strong></div>
                    </div>
                     `
                })
            }
            if (this.id === '1') {
                getInsertCurList({ userId: userId, practiceId: this.practiceId }).then(response => {
                    // console.log("当前序列1", response.data);
                    this.rawList = response.data;
                    this.message =  `
                    <div>
                       <div><strong>插入排序:</strong></div>
                     <ul>
                     <li>将第 i 个元素插入到前 i-1 个已经排好序的元素中的适当位置,使得前 i 个元素有序;</li>
                     <li>重复上述过程,直到整个序列有序。</li>
                     </ul>
                     <div><strong>时间复杂度:O(n^2)</strong></div>
                    </div>
                     `
                       
                   
                })
            }
            if (this.id === '2') {
                getSelectCurList({ userId: userId, practiceId: this.practiceId }).then(response => {
                    // console.log("当前序列2", response.data);
                    this.rawList = response.data;
                    this.message =  `
                    <div>
                       <div><strong>选择排序:</strong></div>
                     <ul>
                     <li>首先在未排序序列中找到最小元素,存放到排序序列的起始位置;</li>
                     <li>再从剩余未排序元素中寻找最小元素,放到已排序序列的末尾；</li>
                     <li>重复上述过程,直到整个序列有序。</li>
                     </ul>
                     <div><strong>时间复杂度:O(n^2)</strong></div>
                    </div>
                     `
                })
            }
        },
        open() {
            ElNotification({
                title: '帮助',
                dangerouslyUseHTMLString: true,
                message: this.message
            })
        },
        goback() {
            this.$router.push({ path: '/evaluation' })
        }
    },

}
</script>

<style scoped>
.main {
    height: 570px;
    padding-top: 10px;
}

.tag {
    font-size: 17px;
    text-align: left;
    height: 40px;
    width: 100px;
    display: flex;
    justify-content: flex-start;
    margin-right: 8px;
}

.tag :hover {
    cursor: pointer;
}

.content {
    font-size: 17px;
    text-align: left;
    align-items: center;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.content .card {
    height: 540px;
    padding-left: 20px;
    padding-top: 20px;

}

.content .card .empty {
    padding-top: 390px;
}

.sortlist {
    margin-left: 50px;
    font-size: 21px;
}

.icon {
    font-size: 22px;
    color: #72b2f1;
}

.icon :hover {
    color: #258af0;
}
</style>
