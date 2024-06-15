<template>
    <div class="learning-history">
      <el-card class="box-card">
        <div v-if="studyHistory.length > 0">
          <el-table :data="studyHistory" border style="width: 100%">
            <el-table-column prop="currTime" label="日期" minWidth="90">
              <template #default="scope">
                {{ formatTime(scope.row.currTime) }}
              </template>
            </el-table-column>
            <el-table-column prop="sortMethod" label="排序方法">
              <template #default="scope">
                {{ formatSortMethod(scope.row.sortMethod) }}
              </template>
            </el-table-column>
            <el-table-column prop="problemId" label="题目编号"></el-table-column>
            <el-table-column prop="status" label="状态" :formatter="formatStatus"></el-table-column>
            <el-table-column prop="lastStep" label="最后一步" ></el-table-column>
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
  import { StudyHistory } from '@/api';
  
  const studyHistory = ref([]);
  
  // 函数用于格式化显示状态
  const formatStatus = (row, column, value) => {
    return value === 1 ? '已完成' : '进行中';
  };

  const formatTime = (time) => {
    const date = new Date(time);
    return `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()} ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
  }
  
  const formatSortMethod = (value) => {
    switch (value) {
      case 0:
        return '冒泡排序';
      case 1:
        return '插入排序';
      case 2:
        return '选择排序';
      default:
        return '未知排序方法';
    }
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
  const fetchStudyHistory = (userId) => {
        const token = 'mock';
    //   const token = sessionStorage.getItem('token'); // 从 sessionStorage 获取 token
    //   console.log(token);
      StudyHistory(token,userId)
      .then(response => {
        console.log("study history",response);
        if (response.code === 1) {
          studyHistory.value = response.data;
          console.log(studyHistory)
        } else {
          ElMessage.error(response.msg);
        }
      })
      .catch(error => {
        ElMessage.error('获取学习记录失败: ' + error.message);
      })

  };
  </script>
  
  <style scoped>
  .box-card {
    margin: 20px;
  }
  </style>