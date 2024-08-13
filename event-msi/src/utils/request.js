import axios from "axios"
import { ElMessage } from 'element-plus';
import {useTokenStore} from "@/store/auth.js";
import router from "@/router/index.js";

const baseURL = '/api'
// 创建axios实例
const service = axios.create({
    baseURL: baseURL, // 设置默认的 API 地址，url = baseURL + url（使用proxy代理时此处可不写）
    timeout: 5000,	// 设置请求超时时间
})

//请求拦截器
service.interceptors.request.use(
    (config)=>{
        let tokenStore = useTokenStore()
        if (tokenStore.token){
            config.headers.Authorization = tokenStore.token
        }
        return config
    },
    (error)=>{
        ElMessage.error(error.message)
        return Promise.reject(error)
    }
)

// 响应拦截器
service.interceptors.response.use(
    // 响应数据，2xx 范围内的状态码都会触发该函数。
    (response) => {
        if (response.data.code == 200){
            const { status, data } = response;
            if (status === 200) {
                const { code, message } = data;
                // 根据后端返回的自定义状态码 code 进行错误信息提示（根据具体需求确定是否需要书写）
                switch (code) {
                    case 401:
                        ElMessage({ message: message, type: 'error' })
                        return Promise.reject(data);
                    default:
                        return data;
                }
            }
        }else{
            return Promise.reject(response.data)
        }
    },
    (error) => {
        if (error.response.status == 401){
            router.push('/login')
        }
        if (error.response) {
            const { data } = error.response;
            ElMessage({ message: data.message, type: 'error' })
        } else if (error.request) {
            // 请求已发送，未收到响应
            ElMessage({ message: error.message || '请求已发送，未收到响应信息！', type: 'error' })
        } else {
            // 其他错误
            ElMessage({ message: error.message, type: 'error' })
        }
        // 若简写，上面代码可省略，只写此一行
        return Promise.reject(error);
    }
)

export default service;
