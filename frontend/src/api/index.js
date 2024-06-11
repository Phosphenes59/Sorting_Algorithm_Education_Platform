import requests from "@/api/requests";


// 查询所有题目
export function listAllSorts() {
    return requests({
      url: '/sort/all',
      method: 'post',
    })
  }
  
//查询我的所有题目
export function listMySorts(data) {
    return requests({
      url: '/sort/myPractice',
      method: 'post',
      params:data
    })
  }


  //新建题目
  export function AddMySort(data) {
    return requests({
      url: '/sort/add',
      method: 'post',
      params:data
    })
  }


  //删除题目
  export function DelMySort(data) {
    return requests({
      url: '/sort/delete',
      method: 'post',
      params:data
    })
  }

  //编辑题目
  export function ExitMySort(data) {
    return requests({
      url: '/sort/modify',
      method: 'post',
      params:data
    })
  }


  //获取当前排序方法的序列
  export function getBubbleCurList(data) {
    return requests({
      url: '/bubble-sort/currList',
      method: 'post',
      params:data
    })
  }

  
  export function getInsertCurList(data) {
    return requests({
      url: '/insert-sort/currList',
      method: 'post',
      params:data
    })
  }

  export function getSelectCurList(data) {
    return requests({
      url: '/select-sort/currList',
      method: 'post',
      params:data
    })
  }
  