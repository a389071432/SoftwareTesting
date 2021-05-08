import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
// 首先声明一个状态 state
const state = {
  questionCase:[],
  question: "",
  // case:""
}

// 然后给 actions 注册事件处理函数，当这个函数被触发时，将状态提交到 mutaions中处理
const actions = {
  setQuestionAndCase(context,payload){
    context.commit('setQuestionAndCase',payload)
  },
  setQuestion(context,payload){
    context.commit('setQuestion',payload)
  }
  // 提交到mutations中处理
}
// 更新状态
const mutations = {
  setQuestionAndCase (state,payload) {
    state.questionCase = payload.value
  },
  setQuestion (state,payload) {
    state.question = payload.value[0]
  }
}
// 获取状态信息
const getters = {
}

// 下面这个相当关键了，所有模块，记住是所有，注册才能使用
export default new Vuex.Store({
  state,
  mutations,
  actions,
  getters
})