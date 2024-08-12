import request from '@/utils/request.js'

const baseUrl = '/user'
export const register = (params)=>{
    return request({
        method: "POST",
        url: `${baseUrl}/register`,
        params: params
    })
}

export const login = (params)=>{
    return request({
        method: "POST",
        url: `${baseUrl}/login`,
        params: params
    })
}
