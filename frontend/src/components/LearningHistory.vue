<template>
    <div class="learning-history">
      <el-card class="box-card">
        <div v-if="studyHistory.length > 0">
          <el-table :data="studyHistory" style="width: 100%">
            <el-table-column prop="date" label="日期" width="180"></el-table-column>
            <el-table-column prop="sortMethod" label="排序方法" width="180"></el-table-column>
            <el-table-column prop="problemId" label="题目编号" width="180"></el-table-column>
            <el-table-column prop="status" label="状态" width="100" :formatter="formatStatus"></el-table-column>
            <el-table-column prop="lastStep" label="最后一步" width="180"></el-table-column>
          </el-table>
        </div>
        <div v-else>
          <p>暂无学习记录</p>
        </div>
      </el-card>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  import { ElMessage } from 'element-plus';
  
  const studyHistory = ref([]);
  
  // 函数用于格式化显示状态
  const formatStatus = (row, column, value) => {
    return value === 1 ? '已完成' : '进行中';
  };
  
  // 在组件挂载时从 sessionStorage 获取用户ID，并请求学习历史
  onMounted(() => {
    const storedUser = sessionStorage.getItem('user');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      const userId = userData.id; // 从存储的用户信息中获取用户ID
      fetchStudyHistory(userId);
    } else {
      ElMessage.error('无法获取用户信息，请确保已登录');
    }
  });
  
  // 使用 Axios 发送 POST 请求获取学习历史
  const fetchStudyHistory = async (userId) => {
    try {
        const token = 'mock';
    //   const token = sessionStorage.getItem('token'); // 从 sessionStorage 获取 token
    //   console.log(token);
      const response = await axios.post('http://localhost:8888/study-history/history', null, {
        headers: { token },
        params: { userId }
      });
      if (response.data.code === 1) {
        studyHistory.value = response.data.data;
      } else {
        ElMessage.error(response.data.msg);
      }
    } catch (error) {
      ElMessage.error('获取学习记录失败: ' + error.message);
    }
  };
  </script>
  
  <style scoped>
  .box-card {
    margin: 20px;
  }
  </style>