import {createRouter,createMemoryHistory} from 'vue-router'

import Main from "@/views/Main.vue";
import Login from "@/views/Login.vue";
import Category from "@/views/category/Category.vue";
import Article from "@/views/article/Article.vue";
import UserAvatar from "@/views/user/UserAvatar.vue";
import UserInfo from "@/views/user/UserInfo.vue";
import UserRestPassword from "@/views/user/UserRestPassword.vue";

const routes = [
    {path: '/',component: Login},
    {path:'/login',component: Login},
    {
        path:'/main',
        component: Main,
        redirect: '/article',
        children:[
            {path:'/category',component:Category},
            {path:'/article',component:Article},
            {path:'/user/avatar',component:UserAvatar},
            {path:'/user/info',component:UserInfo},
            {path:'/user/password',component:UserRestPassword},
        ]
    }
]

const router = createRouter({
    history: createMemoryHistory(),
    routes: routes
})

export default router

