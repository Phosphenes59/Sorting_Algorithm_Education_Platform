<template>
    <div class="info-manage">
      <el-card class="box-card">
        <div class="text item">
          <el-avatar :src="userInfo.avatar"></el-avatar>
          <div v-if="!isEditing">
            <p>姓名：{{ userInfo.name }}</p>
            <p>邮箱：{{ userInfo.email }}</p>
            <p>电话：{{ userInfo.phone }}</p>
            <el-button type="primary" @click="startEditing">修改信息</el-button>
          </div>
          <div v-else>
            <el-form :model="editFormData">
              <el-form-item label="姓名">
                <el-input v-model="editFormData.name"></el-input>
              </el-form-item>
              <el-form-item label="邮箱">
                <el-input v-model="editFormData.email" disabled></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="editFormData.phone"></el-input>
              </el-form-item>
              <el-form-item label="头像">
                <el-upload
                  class="avatar-uploader"
                  action="" 
                  :show-file-list="false"
                  :before-upload="beforeAvatarUpload"
                  :on-success="handleAvatarSuccess"
                >
                  <img v-if="editFormData.avatar" :src="editFormData.avatar" class="avatar" />
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
              </el-form-item>
              <el-form-item>
                <el-button @click="cancelEditing">取消</el-button>
                <el-button type="primary" @click="submitEdit">确认修改</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </el-card>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { ElMessage } from 'element-plus';
  import axios from 'axios';
  const userInfo = ref({
    name: '',
    email: '',
    phone: '',
    avatar: ''
  });
  
  const editFormData = ref({...userInfo.value});
  const isEditing = ref(false);
  
  onMounted(() => {
    const storedUser = sessionStorage.getItem('user');
    console.log(storedUser);
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      userInfo.value = {
        id: userData.id,
        name: userData.userName,
        password: userData.password,
        email: userData.email,
        phone: userData.phone,
        avatar: userData.avatar || 'https://i.pravatar.cc/300' // 默认头像
      };
      editFormData.value = {...userInfo.value};
    }
  });
  
  const startEditing = () => {
    editFormData.value = {...userInfo.value};
    isEditing.value = true;
  };
  
  const cancelEditing = () => {
    isEditing.value = false;
  };
  
  const handleAvatarSuccess = (response, file) => {
    editFormData.value.avatar = URL.createObjectURL(file.raw);
  };
  
  const beforeAvatarUpload = (file) => {
    const isJPG = file.type === 'image/jpeg' || file.type === 'image/png';
    if (!isJPG) {
      ElMessage.error('上传头像图片只能是 JPG 或 PNG 格式!');
      return false;
    }
    const isLt2M = file.size / 1024 / 1024 < 2;
    if (!isLt2M) {
      ElMessage.error('上传头像图片大小不能超过 2MB!');
      return false;
    }
    return true;
  };
  


  const submitEdit = () => {
    const { id, password } = userInfo.value;
    console.log(id, password);
    const params = new URLSearchParams();
    params.append('id', Number.parseInt(id));
    params.append('email', editFormData.value.email);
    params.append('password', password);
    params.append('userName', editFormData.value.name);
    params.append('phone', editFormData.value.phone);
    axios.post('/api/api/user/modify', params).then(response => {
      if (response.data.code === 1) {
        ElMessage.success('信息修改成功');
        userInfo.value = {...editFormData.value}; // 更新本地的用户信息
        isEditing.value = false; // 关闭编辑模式
        sessionStorage.setItem('user', JSON.stringify(userInfo.value)); // 更新 sessionStorage
      } else {
        ElMessage.error(response.data.msg);
      }
    }, error => {
      console.log(error)
      ElMessage.error('修改失败: ' + error.message);
    });
    
    
  } 
  </script>
  
  <style scoped>
  .avatar-uploader .avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
  }
  </style>