import axios from 'axios'
import {ElMessage} from "element-plus";
const baseURL = '/api'
const service = axios.create({
    baseURL: baseURL,
    timeout: 5000
})

/*service.interceptors.request.use(
    config=>{
        //请求头信息
    },
    error=>{
        return Promise.reject(error)
    }
)*/


/*响应拦截器*/
service.interceptors.response.use(
    success=>{
        if (success.data.code == '200'){
            ElMessage.success(success.data.message)
            return success.data
        }else{
            ElMessage.error(success.data.message)
            return Promise.reject(success.data)
        }
    },
        error=>{
        ElMessage.error(success.data.message)
            return Promise.reject(error.data) //异步状态转换为失败状态
    }
)

export default service
