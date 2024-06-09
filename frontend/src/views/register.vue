<template slot-scope="scope">
    <mainContainer>
        <div class="main">
            <div class="login-main">
                <!--      输入账号和密码的地方-->
                <div class="login-input">
                    <div class="login" @keyup.enter="login">
                        <div style="margin: 0 0 20px 30px;text-align: center;font-size:40px;font-weight: bold;color:rgb(19,18,18);">
                            请输入您的注册信息
                        </div>
                        <el-form :model="register_data" size="large" :rules="rules">
                            <el-form-item label="邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱"  prop="email">
                                <el-input prefix-icon = "User" v-model="register_data.email" />
                            </el-form-item>
                            <el-form-item label="联系电话"  prop="phone">
                                <el-input prefix-icon="Iphone" v-model="register_data.phone"/>
                            </el-form-item>
                            <el-form-item label="密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码"  prop="password">
                                <el-input show-password prefix-icon="Lock" v-model="register_data.password" autocomplete="off"/>
                            </el-form-item>
                            <el-form-item label="确认密码" prop="passwordCheck">
                                <el-input show-password prefix-icon="Lock" v-model="register_data.passwordCheck" autocomplete="off"/>
                            </el-form-item>
                            <el-button style="width: 85%;background:black;color:white;margin-top:1%;margin-left:15%"  @click="register">
                                注册
                            </el-button>
                            <div style="font-size: 15px;margin-top: 5px;float: right;cursor: pointer"  @click = "login">
                                已有账号？立即登录
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
        name: "RegisterPage",
        data(){
            let reCheckPw =(rule,value,callback)=>{
                if (value===""){
                    callback(new Error('请再次确认密码'));
                    return false;
                }
                else {
                    if(this.$data.register_data.password!=value){
                        callback(new Error('两次输入密码不一致'));
                        return false;
                    }
                    else {
                        callback();
                        return true;
                    }
                }
            };
            return{
                flag:'',
                register_data:{
                    email:'',
                    phone:'',
                    password:'',
                    passwordCheck:''
                },
                rules:{
                    email: [
                        { required: true, message: '请输入邮箱', trigger: 'blur' },
                    ],
                    phone:[
                        { required: true, message: '请输入电话号码', trigger: 'blur' },
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ],
                    passwordCheck:[
                        {required: true, validator: reCheckPw, trigger: 'blur',},
                    ],
                }
            }
        },
        methods: {
            register(){
                const params = new URLSearchParams();
                params.append('email', this.register_data.email);
                params.append('password', this.register_data.password);
                params.append('phone', this.register_data.phone);
                axios.post("/api/api/user/register",params).then(res => {
                    if(res.data.code === 1){
                        console.log('Response:', res.data);
                        ElMessage.success(res.data.msg);
                        sessionStorage.setItem("user", JSON.stringify(res.data.data));
                         router.push("/login");
                    }else{
                        ElMessage.error(res.data.msg);
                    }
                })
            },
            login(){
                router.push("/login");
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
