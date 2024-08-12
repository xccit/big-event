<script setup>
import { User, Lock } from '@element-plus/icons-vue'
import { ref } from 'vue'
import {register,login} from "@/api/user/user.js";
import {useRouter} from 'vue-router'
import {ElMessage} from "element-plus";

//路由函数
const router = useRouter()
//控制注册与登录表单的显示， 默认显示登录
const isRegister = ref(false)
//注册表单数据
const registerParams = ref({
  username:'',
  password:'',
  confirmPassword:''
})
//注册表单校验规则
const confirmPasswordCheck = (rule,value,callback)=>{
  if (value === ''){
    callback( new Error('请输入确认密码') )
  }
  else if (value !== registerParams.value.password){
    callback( new Error('两次输入密码不一致') )
  }
  else{
    callback()
  }
}
const registerRules = {
  username:[
    {required: true,message:'请输入用户名',trigger:'blur'},
    {min: 5,max:16,message: '请输入5~16位合法用户名',trigger: 'blur'}
  ],
  password:[
    {required: true,message:'请输入密码',trigger:'blur'},
    {min: 6,max:16,message: '请输入6~16位密码',trigger: 'blur'}
  ],
  confirmPassword:[
    {validator: confirmPasswordCheck,trigger:'blur'}
  ]
}
//注册函数
const submitRegister = () => {
  register(registerParams.value).then(response=>{
    //跳转到登录
    isRegister.value = false
  }).catch(response=>{

  })
}

//登录函数
const submitLogin = ()=>{
  login(registerParams.value)
      .then(response=>{
        router.push('/main')
      })
      .catch(response=>{

      })
}
//清空数据模型
const clearParams = ()=>{
  registerParams.value = {
    username: '',
    password: '',
    confirmPassword: ''
  }
}
</script>

<template>
  <el-row class="login-page">
    <el-col :span="12" class="bg"></el-col>
    <el-col :span="6" :offset="3" class="form">
      <!-- 注册表单 -->
      <el-form ref="form" size="large" autocomplete="off" v-if="isRegister" :model="registerParams" :rules="registerRules">
        <el-form-item>
          <h1>注册</h1>
        </el-form-item>
        <el-form-item prop="username">
          <el-input :prefix-icon="User" placeholder="请输入用户名" v-model="registerParams.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input :prefix-icon="Lock" type="password" placeholder="请输入密码" v-model="registerParams.password"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input :prefix-icon="Lock" type="password" placeholder="请输入再次密码" v-model="registerParams.confirmPassword"></el-input>
        </el-form-item>
        <!-- 注册按钮 -->
        <el-form-item>
          <el-button class="button" type="primary" auto-insert-space @click="submitRegister">
            注册
          </el-button>
        </el-form-item>
        <el-form-item class="flex">
          <el-link type="info" :underline="false" @click="isRegister = false;clearParams()">
            ← 返回
          </el-link>
        </el-form-item>
      </el-form>
      <!-- 登录表单 -->
      <el-form ref="form" size="large" autocomplete="off" v-else :model="registerParams" :rules="registerRules">
        <el-form-item>
          <h1>登录</h1>
        </el-form-item>
        <el-form-item prop="username">
          <el-input :prefix-icon="User" placeholder="请输入用户名" v-model="registerParams.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input name="password" :prefix-icon="Lock" type="password" placeholder="请输入密码" v-model="registerParams.password"></el-input>
        </el-form-item>
        <el-form-item class="flex">
          <div class="flex">
            <el-checkbox>记住我</el-checkbox>
            <el-link type="primary" :underline="false">忘记密码？</el-link>
          </div>
        </el-form-item>
        <!-- 登录按钮 -->
        <el-form-item>
          <el-button class="button" type="primary" auto-insert-space @click="submitLogin">登录</el-button>
        </el-form-item>
        <el-form-item class="flex">
          <el-link type="info" :underline="false" @click="isRegister = true;clearParams()">
            注册 →
          </el-link>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<style lang="scss" scoped>
/* 样式 */
.login-page {
  height: 100vh;
  background-color: #fff;

  .bg {
    background: url('@/assets/logo2.png') no-repeat 60% center / 240px auto,
    url('@/assets/login_bg.jpg') no-repeat center / cover;
    border-radius: 0 20px 20px 0;
  }

  .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    user-select: none;

    .title {
      margin: 0 auto;
    }

    .button {
      width: 100%;
    }

    .flex {
      width: 100%;
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>
