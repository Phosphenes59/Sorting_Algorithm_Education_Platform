<template>
    <mainContainer>
        <div class="navigation">
            <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
                <el-tab-pane label="个人信息选项卡" name="first">
                    <InfoManage/>
                </el-tab-pane>
                <el-tab-pane label="学习情况" name="second">
                    <LearningSituation/>
                </el-tab-pane>
                <el-tab-pane label="历史操作" name="third">
                    <LearningHistory/>
                </el-tab-pane>
            </el-tabs>
        </div>
    </mainContainer>
</template>

<script>
    import LearningSituation from "@/components/LearningSituation.vue";
    import InfoManage from "@/components/InfoManage.vue";
    import LearningHistory from "@/components/LearningHistory.vue";
    export default {
        name: "personalCenter",
        components: {
            LearningSituation,
            InfoManage,
            LearningHistory
        },
        data(){
            return {
                activeName: 'first',
            }
        },
        methods: {
            handleClick(tab, event) {
                console.log(tab, event);
            }
        },
    }
</script>

<style scoped>
   .navigation{
       margin-top: 20px;
   }

   ::v-deep .el-tabs__item {
      font-size:20px;
   }


</style>
