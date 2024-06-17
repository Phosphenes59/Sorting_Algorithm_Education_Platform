<template>
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            :ellipsis="false"
            @select="handleSelect"
    >
        <img src="../../assets/mylogo.jpg" alt="logo" style="width: 55px;height: 55px;border-radius: 50%">
        <el-menu-item index="main" class="main">算法教学平台</el-menu-item>
        <div class="flex-grow" />
        <el-menu-item index="postList">新手引导</el-menu-item>
        <el-menu-item index="evaluation">学习</el-menu-item>
        <el-sub-menu index="2">
            <template #title>个人中心</template>
            <el-menu-item v-if="!flag" index="login">登录</el-menu-item>
            <el-menu-item v-if="!flag" index="register">注册</el-menu-item>
            <el-menu-item v-if="flag" index="personalCenter">个人信息</el-menu-item>
            <el-menu-item v-if="flag" @click="logout">注销登录</el-menu-item>
        </el-sub-menu>
    </el-menu>
</template>

<script>
    import { ref } from 'vue'
    import router from "@/router";
    import { removeUSER } from "@/utils/loginInfo";
    export default {
        name:"layoutHeader",
        data(){
            return{
                flag:'',
            }
        },
        mounted(){
            this.$data.flag = (sessionStorage.getItem('user'))?true:false
        },
        computed: {
            activeIndex() {
                return this.$route.name;
            },
        },
        methods:{
            handleSelect(index) {
                if (index === 'postList') {
                    this.$emit('intro')
                } else {
                        this.$router.push({
                        name: index,  
                    })
                }
            },
            logout(){
                sessionStorage.removeItem("user");
                //删除userId
                removeUSER();
                router.push("/login");
            }
        }

    }
</script>

<style>
    .flex-grow {
        flex-grow: 1;
    }
    .el-menu-demo{
        height: 60px;
    }
    .main{
        font-weight: bold;
        font-size: 39px;
    }
</style>
@/utils/loginInfo