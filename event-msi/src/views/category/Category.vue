<script setup>
import {
  Edit,
  Delete, Clock
} from '@element-plus/icons-vue'
import {list,insert,update,remove,detail} from '@/api/category/category.js'
import {onMounted, ref} from 'vue'
import {ElMessage} from "element-plus";
const categorys = ref([])
onMounted( ()=>{
  getCategoryList()
})
//列表渲染
const getCategoryList = ()=>{
  list().then(response=>{
    ElMessage.success("文章分类获取成功")
    categorys.value = response.data
  }).catch(response=>{
  })
}
</script>
<template>
  <el-card class="page-container">
    <template #header>
      <div class="header">
        <span>文章分类</span>
        <div class="extra">
          <el-button type="primary">添加分类</el-button>
        </div>
      </div>
    </template>
    <el-table :data="categorys" style="width: 100%">
      <el-table-column label="序号" width="100" type="index"> </el-table-column>
      <el-table-column label="分类名称" prop="categoryName"></el-table-column>
      <el-table-column label="分类别名" prop="categoryAlias"></el-table-column>
      <el-table-column label="创建时间" prop="createTime">
        <template #default="scope">
          <el-tag type="primary"><span><el-icon><Clock /></el-icon></span>{{scope.row.createTime}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="100">
        <template #default="{ row }">
          <el-button :icon="Edit" circle plain type="primary" ></el-button>
          <el-button :icon="Delete" circle plain type="danger"></el-button>
        </template>
      </el-table-column>
      <template #empty>
        <el-empty description="没有数据" />
      </template>
    </el-table>
  </el-card>
</template>

<style lang="scss" scoped>
.page-container {
  min-height: 100%;
  box-sizing: border-box;

  .header {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }
}
</style>
