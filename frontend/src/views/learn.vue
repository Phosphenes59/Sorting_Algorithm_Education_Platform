<template slot-scope="scope">
    <mainContainer>
        <el-row class="main">
            <el-col :span="18">
                <SortVisalization />
            </el-col>
            <el-col :span='5' :offset="1" class="content">
                <div class="card">
                    <div class="header">
                        <div class="card-header">
                            <span>题目：<br />
                                <span class="sortlist">[3,4,1,8,0,9]</span>
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
import SortVisalization from "@/components/SortVisalization.vue";
import { ElNotification } from 'element-plus'
export default {
    name: "learnPage",
    components: {
        SortVisalization
    },
    data() {
        return {

        }
    },
    methods: {
        open() {
            ElNotification({
                title: 'Help',
                message: '一些帮助信息'
            })
        }
    },
}
</script>

<style scoped>
.main {
    height: 570px;
    padding-top: 30px;
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
}</style>
