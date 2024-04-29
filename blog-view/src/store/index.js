// userStore.js

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: null
  },
  mutations: {
    setToken (state, token) {
      state.token = token
    }
  },
  actions: {
    login ({ commit }, token) {
      // 在登录成功后调用此方法来设置token
      commit('setToken', token)
    },
    logout ({ commit }) {
      // 在登出时调用此方法来清除token
      commit('setToken', null)
    }
  },
  getters: {
    getToken: state => state.token
  }
})
