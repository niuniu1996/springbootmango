// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import api from './http'
import global from '@/utils/global'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'

Vue.config.productionTip = false
//注册使用Element
Vue.use(ElementUI)
//注册使用API模块
Vue.use(api)
//挂载全局配置模块
Vue.prototype.global=global

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  //components: { App },
  //template: '<App/>'
  render:h=>h(App)
})
