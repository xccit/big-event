import request from '@/utils/request.js'

const baseUrl = '/category'
export const list = ()=>{
    return request({
        method: 'GET',
        url: `${baseUrl}`
    })
}

export const insert = (category)=>{
    return request({
        method: 'POST',
        url:`${baseUrl}`,
        data: category
    })
}

export const update = (category)=>{
    return request({
        method: 'PUT',
        url: `${baseUrl}`,
        data: category
    })
}

export const remove = (id)=>{
    return request({
        method: 'DELETE',
        url: `${baseUrl}/${id}`
    })
}

export const detail = (id)=>{
    return request({
        method: 'GET',
        url: `${baseUrl}/detail`,
        params: id
    })
}
