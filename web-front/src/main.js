import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
// import firebase from 'firebase/app'
// import 'firebase/firestore'
import ElementUI from 'element-ui' //element-ui的全部组件
import 'element-ui/lib/theme-chalk/index.css'//element-ui的css
import Vuex from 'vuex'
import store from './vuex/store'

Vue.use(Vuex)
Vue.use(ElementUI) //使用elementUI
Vue.config.productionTip = false

// firebase.initializeApp({
//  Configurações do seu app
// })

// export const db = firebase.firestore()

new Vue({
    vuetify,
    store,
    render: h => h(App)
}).$mount('#app')
