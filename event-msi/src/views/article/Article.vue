<script lang="ts" setup>
import { Timer } from '@element-plus/icons-vue'
import { Delete, Edit, Search, Close } from '@element-plus/icons-vue'
import { ref } from 'vue'
import { reactive } from 'vue'

interface User {
  title: string,
  category: string,
  date: string
  name: string,
  state: string,
  address: string
}

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  console.log(index, row)
}

const tableData: User[] = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    title: 'xccit',
    category: 'IT',
    state: '已发布'
  },
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    title: 'xccit',
    category: 'IT',
    state: '已发布'
  },
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    title: 'xccit',
    category: 'IT',
    state: '已发布'
  },
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    title: 'xccit',
    category: 'IT',
    state: '已发布'
  },
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    title: 'xccit',
    category: 'IT',
    state: '已发布'
  }
]
//分页
import type { ComponentSize } from 'element-plus'
const currentPage = ref(4)
const pageSize = ref(5)
const size = ref<ComponentSize>('default')
const background = ref(false)
const disabled = ref(false)
const total = ref(20)

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
}

//表单
const queryParam = reactive({
  category: '',
  state:''
})

const categories = reactive([
  {categoryId:1,categoryName:'IT'},
  {categoryId:2,categoryName:'财经'}
])

const state = reactive(['已发布','草稿'])


const onSubmit = () => {
  console.log('submit!')
}

const onClear = () => {
  console.log("onClear!")
}

</script>

<template>
  <!-- 表头 -->
  <el-card style="margin-bottom: 10px;margin-top: 3px">
     <div class="card-header">
       <span>文章管理</span>
       <el-button type="primary" size="small" style="">发布文章</el-button>
     </div>
  </el-card>
    <!-- 表单 -->
    <el-form :inline="true" :model="queryParam" class="demo-form-inline">
      <el-form-item label="文章分类:">
          <el-select
              v-model="queryParam.category"
              placeholder="请选择分类"
              clearable
          >
            <el-option v-for="(item,index) in categories" :label="item.categoryName" :value="item.categoryId" />
          </el-select>
      </el-form-item>
      <el-form-item label="发布状态:">
        <el-select
            v-model="queryParam.state"
            placeholder="请选择状态"
            clearable
        >
          <el-option v-for="(item,index) in state" :label="item" :value="item" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" :icon="Search" size="small">搜索</el-button>
        <el-button @click="onClear" :icon="Close" size="small">重置</el-button>
      </el-form-item>
    </el-form>
    <!-- 表格 -->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="标题" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon><timer /></el-icon>
            <span style="margin-left: 10px">{{ scope.row.title }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="分类" width="180">
        <template #default="scope">
          <el-tag type="success">
            {{scope.row.category}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="发布时间" width="180">
        <template #default="scope">
          <el-tag type="success">
            {{scope.row.date}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="状态" width="180">
        <template #default="scope">
          <el-tag type="success">
            {{scope.row.state}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" type="warning" :icon="Edit">编辑</el-button>
          <el-button size="small" type="danger" :icon="Delete">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        size="small"
        class="el-page"
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[5,10,15,20]"
        :size="size"
        :disabled="disabled"
        :background="background"
        layout="jumper,total, sizes, prev, pager, next"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
</template>

<style scoped>
  .el-page{
    margin-top: 10px;
    margin-right: 10px;
    display: flex;
    justify-content: flex-end;
  }
  .demo-form-inline .el-input {
    --el-input-width: 220px;
  }

  .demo-form-inline .el-select {
    --el-select-width: 220px;
  }
  .card-header{
    display: flex;
    justify-content: space-between;
  }
</style>
