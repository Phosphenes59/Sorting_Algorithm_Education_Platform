<template slot-scope="scope">
    <mainContainer >
        <div class="main">
            <div class="login-main">
                <!--      输入账号和密码的地方-->
                <div class="login-input">
                    <div class="login" @keyup.enter="login">
                        <div style="margin: 0 0 10px 0;text-align: center;font-size:40px;font-weight: bold;color:rgb(19,18,18);">
                            登录
                        </div>
                        <el-form :model="login_data" size="large" :rules="rules">
                            <el-form-item label="邮&nbsp&nbsp&nbsp箱">
                                <el-input prefix-icon = "User" v-model="login_data.email" />
                            </el-form-item>
                            <el-form-item label="密&nbsp&nbsp&nbsp码">
                                <el-input show-password prefix-icon="Lock" v-model="login_data.password"/>
                            </el-form-item>
                            <el-button style="width: 88%;background:black;color:white;margin-top:5%;margin-left:11%"  @click="login">
                                登录
                            </el-button>
                            <div style="font-size: 15px;margin-top: 5px;float: right;cursor: pointer"  @click = "register">
                                还没有账号？立即注册
                            </div>
                        </el-form>
                    </div>
                </div>
            </div>
        </div>
    </mainContainer>

</template>

<script>
    import {getCurrentInstance, reactive} from "vue";
    import router from "@/router";
    import axios from "axios";
    import {ElMessage} from "element-plus";

    export default {
        name: "LoginPage",
        data(){
            return{
                flag:'',
                login_data:{
                    email:'',
                    password:''
                },
                rules:{
                    email: [
                        { required: true, message: '请输入邮箱', trigger: 'blur' },
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            login(){
                const params = new URLSearchParams();
                params.append('email', this.login_data.email);
                params.append('password', this.login_data.password);
                axios.post("/api/api/user/login",params).then(res => {
                    if(res.data.code === 1){
                        console.log('Response:', res.data);
                        ElMessage.success(res.data.msg);
                        sessionStorage.setItem("user", JSON.stringify(res.data.data));
                         router.push("/personalCenter");
                    }else{
                        ElMessage.error(res.data.msg);
                    }
                })
            },
            register(){
                router.push("/register");
            }
        },

    }
</script>

<style scoped>
    body{
        width: 100%;
        height: 100%;
    }
    ::v-deep .common-layout{
        background: url(../assets/bg3.jpg);
    }
    .main{
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        position: fixed;
    }
    .header{
        height: 10%;
    }
    .login-main{
        width: 100%;
        height:88%;
        display: flex;
    }
    .login-input{
        background: transparent;
        /*background: white;*/
        margin:1% 0 0 24.6%;
        width: 50%;
        height: 70%;
        border-radius: 12px;
        display: flex;
    }
    .login{
        width: 90%;
        height: 90%;
        float: right;
        margin: 15% 20% 20% 20%;
    }
    .footer{
        height: 5%;
        margin: 10px auto;
        font-size: small;
    }
</style>
