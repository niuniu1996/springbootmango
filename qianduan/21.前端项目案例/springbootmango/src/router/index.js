import Vue from 'vue'
import Router from 'vue-router'
// 导入组件
import HelloWorld from '@/views/HelloWorld'
import Login from '@/views/Login'
import NotFound from '@/views/404'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/404',
      name: 'NotFound',
      component: NotFound
    }
  ]
})
