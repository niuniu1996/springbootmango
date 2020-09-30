<template>
  <div class="page">
    <h2>Login page</h2>
    <el-button class="primary" @click="login()">登录</el-button>
  </div>
</template>

<script>


  import Cookies from "js-cookie"
  import router from '@/router'

  export default {
    name: "Login",
    methods: {
      login() {
        this.$api.login.login().then(function (res) {
          alert("正常")
          alert(res.token)
          Cookies.set('token', res.token)
          router.push('/')
        }).catch(function (res) {
          alert("报错")
          alert(res)
        });
      }
    }
  }
</script>

<style scoped>

</style>
