import axios from "axios";
import nprogress from 'nprogress';
import 'nprogress/nprogress.css';
import { getTOKEN } from "@/utils/loginInfo";

//利用axios的create方法创建一个axios实例
const requests=axios.create({
    //基础路径
    baseURL: 'http://127.0.0.1:8888', 
    //超时的设置
    timeout: 5000
});

//请求拦截器
requests.interceptors.request.use((config)=>{
    nprogress.start();
    //带上token
    let token = getTOKEN();
    if(token){
        config.headers.token=token;
    }
    return config
});

//响应拦截器
requests.interceptors.response.use((res)=>{
    nprogress.done();
    return res.data
},(error)=>{
    return Promise.reject(new Error(error.message))
})

export default requests;