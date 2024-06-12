import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router'
import LoginPage from "@/views/login";
import RegisterPage from "@/views/register";
import PersonalCenter from "@/views/personalCenter.vue";
import evaluationPage from "@/views/evaluation";
import learnPage from "@/views/learn";

import SortVisalization from '../components/SortVisalization.vue';

const routes = [
    {
        path: "/",
        name: '/',
        redirect:'/login'
    },
    {
        path: '/login',
        name: 'login',
        component: LoginPage
    },
    {
        path:'/register',
        name:'register',
        component: RegisterPage
    },
    {
        path: '/personalCenter',
        name:'personalCenter',
        component: PersonalCenter
    },
    {
        path: '/sort',
        name: 'SortVisalization',
        component: SortVisalization,
    }
    ,{
         path: '/evaluation',
        name:'evaluation',
        component: evaluationPage
    }
    ,{
        path: '/learn',
        name:'learn',
        component: learnPage
    }
    // ,{
    //      path: '/evaluation',
    //     name:'evaluation',
    //     component: evaluationPage
    // }
    // ,{
    //     path: '/learn',
    //     name:'learn',
    //     component: learnPage
    // }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

router.beforeEach((to, from, next) => {
    // 判断有没有登录
    // if (!sessionStorage.getItem('user')) {
    //     if (to.name == "login"||to.name == "main"||to.name == "/"||to.name == "register") {
    //         next();
    //     } else {
    //         alert("请先登录！")
    //         router.push('login')
    //     }
    // } else {
        next();
    // }
});

export default router
