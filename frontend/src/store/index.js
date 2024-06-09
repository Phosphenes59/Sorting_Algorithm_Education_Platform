import { defineStore } from 'pinia'

export const useStore = defineStore('user', {
  state: () => ({
    sortList: [],
  }),
  getters: {
    sortList: (state) => state.sortList
  },
  actions: {
    setSortList(list) {
      this.sortList = list
    }
  }
})