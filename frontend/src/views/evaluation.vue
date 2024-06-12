<template>
    <mainContainer>
        <el-row class="tac">
            <el-col :span="4">
                <h5 class="mb-2">我的学习</h5>
                <el-menu :default-active="activeIndex" class="el-menu-vertical-demo" @select="handleSelect">
                    <el-menu-item index="1">
                        <el-icon>
                            <Star />
                        </el-icon>
                        <span>冒泡排序</span>
                    </el-menu-item>
                    <el-menu-item index="2">
                        <el-icon>
                            <Star />
                        </el-icon>
                        <span>插入排序</span>
                    </el-menu-item>
                    <el-menu-item index="3">
                        <el-icon>
                            <Star />
                        </el-icon>
                        <span>选择排序</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <el-icon>
                            <document />
                        </el-icon>
                        <span>我的题库</span>
                    </el-menu-item>
                </el-menu>
            </el-col>


            <!-- 对应冒泡排序 -->
            <el-col :span="18" :offset="2" v-if="activeIndex === '1'">
                <el-card class="content">
                    <template #header>
                        <div class="card-header">
                            <span> <el-icon>
                                    <CircleCheckFilled />
                                </el-icon>
                                总任务点: {{ allSortList.length }}
                            </span>
                        </div>
                    </template>
                    <div v-for="(item, index) in allSortList" :key="index" class="text item">
                        <div class="list-title">
                            <el-row>
                                <el-col :span="16">
                                    <el-icon>
                                        <Compass />
                                    </el-icon>
                                    <span>题目序列： [ {{ ' ' + item.currList + ' ' }}]</span>
                                    <!-- <span class="state">
                                        <el-icon class="icon1" v-if="state == 1">
                                            <Clock />
                                        </el-icon>
                                        <el-icon class="icon2" v-else>
                                            <Clock />
                                        </el-icon>
                                        完成状态：<span v-if="state == 1">已完成</span> <span v-else>未完成</span></span> -->
                                </el-col>
                                <el-col class="con" :span="4" :offset="4"><el-button type="primary"
                                        @click="goBubbleLearn(item)">进入学习</el-button>
                                </el-col>
                            </el-row>
                            <el-divider />
                        </div>
                    </div>
                </el-card>
            </el-col>

            <!-- 对应插入排序 -->
            <el-col :span="18" :offset="2" v-if="activeIndex === '2'">
                <el-card class="content">
                    <template #header>
                        <div class="card-header">
                            <span> <el-icon>
                                    <CircleCheckFilled />
                                </el-icon>
                                总任务点: {{ allSortList.length }}
                            </span>
                        </div>
                    </template>
                    <div v-for="(item, index) in allSortList" :key="index" class="text item">
                        <div class="list-title">
                            <el-row>
                                <el-col :span="16">
                                    <el-icon>
                                        <Compass />
                                    </el-icon>
                                    <span>题目序列： [ {{ ' ' + item.currList + ' ' }}]</span>
                                    <!-- <span class="state">
                                        <el-icon class="icon1" v-if="state == 1">
                                            <Clock />
                                        </el-icon>
                                        <el-icon class="icon2" v-else>
                                            <Clock />
                                        </el-icon>
                                        完成状态：<span v-if="state == 1">已完成</span> <span v-else>未完成</span></span> -->
                                </el-col>
                                <el-col class="con" :span="4" :offset="4"><el-button type="primary"
                                        @click="goInsertLearn(item)">进入学习</el-button>
                                </el-col>
                            </el-row>
                            <el-divider />
                        </div>
                    </div>
                </el-card>
            </el-col>

            <!-- 对应选择排序 -->
            <el-col :span="18" :offset="2" v-if="activeIndex === '3'">
                <el-card class="content">
                    <template #header>
                        <div class="card-header">
                            <span> <el-icon>
                                    <CircleCheckFilled />
                                </el-icon>
                                总任务点: {{ allSortList.length }}
                            </span>
                        </div>
                    </template>
                    <div v-for="(item, index) in allSortList" :key="index" class="text item">
                        <div class="list-title">
                            <el-row>
                                <el-col :span="16">
                                    <el-icon>
                                        <Compass />
                                    </el-icon>
                                    <span>题目序列： [ {{ ' ' + item.currList + ' ' }}]</span>
                                    <!-- <span class="state">
                                        <el-icon class="icon1" v-if="state == 1">
                                            <Clock />
                                        </el-icon>
                                        <el-icon class="icon2" v-else>
                                            <Clock />
                                        </el-icon>
                                        完成状态：<span v-if="state == 1">已完成</span> <span v-else>未完成</span></span> -->
                                </el-col>
                                <el-col class="con" :span="4" :offset="4"><el-button type="primary"
                                        @click="goSelectLearn(item)">进入学习</el-button>
                                </el-col>
                            </el-row>
                            <el-divider />
                        </div>
                    </div>
                </el-card>
            </el-col>

            <el-col :span="18" :offset="2" v-if="activeIndex === '4'">
                <el-card class="problem">
                    <template #header>
                        <div class="card-header">
                            <span>
                                <el-icon>
                                    <Collection />
                                </el-icon>
                                我的题目：
                            </span>
                            <el-button @click="add">
                                <template #icon>
                                    <el-icon class="icon3">
                                        <Plus />
                                    </el-icon>
                                </template>
                                新建题目
                            </el-button>
                        </div>
                    </template>
                    <el-table :data="mySortList" class="tableData" style="width: 100%"
                        @selection-change="handleSelectionChange" size="large">
                        <el-table-column type="selection" width="55" />
                        <el-table-column label="题目序列" width="220">
                            <template #default="scope">[{{ " " + scope.row.currList + " " }}]</template>
                        </el-table-column>
                        <el-table-column label="创建时间" width="200">
                            <template >{{ date }}</template>
                        </el-table-column>
                        <el-table-column align="right">
                            <template #header>
                                <el-input v-model="search" size="medium" placeholder="Type to search" />
                            </template>
                            <template #default="scope">
                                <el-button type="success" @click="handleEdit(scope.row)">
                                    编辑
                                </el-button>
                                <el-button type="danger" @click="handleDelete(scope.row)">
                                    删除
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>

                </el-card>
            </el-col>
        </el-row>


        <el-dialog class="dialog" v-model="dialogVisible" :title="title" width="500" :before-close="handleClose">
            <el-form label-width="auto" style="max-width: 600px">
                <el-form-item label="题目序列">
                    <el-input v-model="input" type="textarea" placeholder="请输入一个序列" :suffix-icon="Calendar" />
                </el-form-item>
            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="dialogVisible = false">Cancel</el-button>
                    <el-button type="primary" @click="confirm">
                        Confirm
                    </el-button>
                </div>
            </template>
        </el-dialog>
    </mainContainer>
</template>

<script>
import { ElMessageBox } from 'element-plus';
import { getUSER } from "@/utils/loginInfo";
import { listAllSorts, listMySorts, AddMySort, DelMySort, ExitMySort } from "@/api/index";
import {ElMessage} from "element-plus";
export default {
    name: "evaluationPage",

    data() {
        return {
            activeIndex: '1',
            allSortList: [],
            mySortList: [],
            date: '2024-06-10',
            //对话框相关内容
            dialogVisible: false,
            title: '',
            input: '',
            state:'',
            practiceId:'',

        }
    },
    mounted() {
        //发送请求
        this.getAllData();
    },
    methods: {
        //获取所有数据
        getAllData() {
            let userId = getUSER();
            listAllSorts({userId:userId}).then(response => {
                // console.log("所有题目", response.data);
                this.allSortList = response.data;
            })
        
            listMySorts({ userId: userId }).then(response => {
                // console.log("我的题目", response.data);
                this.mySortList = response.data;
            })
        },
        handleSelect(key, keyPath) {
            this.activeIndex = key
        },
        goBubbleLearn(item) {
            this.$router.push({ path: '/learn', query: { id: 0, practiceId: item.practiceId } })
        },
        goInsertLearn(item) {
            this.$router.push({ path: '/learn', query: { id: 1, practiceId: item.practiceId } })
        },
        goSelectLearn(item) {
            this.$router.push({ path: '/learn', query: { id: 2, practiceId: item.practiceId } })
        },
        add() {
            this.dialogVisible = true;
            this.title = "新建题目";
            this.state='0';
            this.input='';
        },
        handleClose() {
            this.dialogVisible = false;
            this.title = "";
            this.state='';
        },
        handleEdit(row) {
            this.dialogVisible = true;
            this.title = "编辑题目";
            this.input = row.currList;
            this.practiceId=row.practiceId;
            this.state='1';
        },
        handleDelete(row) {
            ElMessageBox.confirm(
                '将要删除该题目，是否继续?',
                '提示',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
            .then(() => {
                    // 确认操作
                    let userId = getUSER();
                    let practiceId = row.practiceId;
                    // console.log(row,userId,practiceId);
                    DelMySort({ userId: userId, practiceId: practiceId }).then(response => {
                        if (response.code === 1) {
                            // console.log('Response:', response);
                            ElMessage.success(response.msg);
                            this.getAllData();
                        } else {
                            ElMessage.error(response.msg);
                        }
                    })
                    
                })
                .catch(() => {
                    // 取消操作
                })

        },
        confirm(){
            if(this.state==='0'){
                let sortList=this.input;
                let userId = getUSER();
                let practiceId = this.allSortList.length+1;
                AddMySort({ userId: userId, practiceId: practiceId,sortList:sortList }).then(response => {
                        if (response.code === 1) {
                            // console.log('Response:', response);
                            ElMessage.success(response.msg);
                            this.getAllData();
                        } else {
                            ElMessage.error(response.msg);
                        }
                    })
               
            }
            if(this.state=='1'){
                //编辑题目
                let sortList=this.input;
                let userId = getUSER();
                let practiceId = this.practiceId;
                ExitMySort({ userId: userId, practiceId: practiceId,sortList:sortList }).then(response => {
                        if (response.code === 1) {
                            // console.log('Response:', response);
                            ElMessage.success(response.msg);
                            this.getAllData();
                        } else {
                            ElMessage.error(response.msg);
                        }
                    })
            }
            this.dialogVisible = false;
            this.input='';

        }
    },
}
</script>

<style scoped>
.tac .content {
    margin-top: 20px;
}

.tac .text.item {
    text-align: left;
}

.tac .card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.tac .card-header .el-icon {
    margin-right: 4px;
    color: #409EFF;
    /* 蓝色 */
}

.tac .card-header span {
    font-weight: bold;
}

.tac .list-title {
    padding-top: 10px;
    padding-bottom: 10px;
}

.tac .list-title .con :hover {
    background-color: gainsboro;
}

.tac .list-title .el-icon {
    margin-right: 12px;
    color: #409EFF;
}

.tac .list-title .state {
    margin-left: 100px;
}

.tac .list-title .state .icon2 {
    /* color: #67C23A; */
    color: gray;
}

.tac .list-title .state .icon1 {
    color: #67C23A;
    /* color: gray; */
}

.tac .problem {
    height: 600px;
}

.tac .tableData {
    font-size: 16px;
}

::v-deep .dialog .el-dialog__header {
    text-align: left;
}
</style>
