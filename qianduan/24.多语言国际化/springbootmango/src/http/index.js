/**
 * 这里把axios注册为vue插件使用，并将api模块挂载在vue原型的$api对象上，
 * 这样在能获取this引用的地方就可以通过this.$api.子模块.方法的方式调用API了
 */
// 导入所有接口
import api from './api'

const install = Vue => {
    if (install.installed)
        return;

    install.installed = true;

    Object.defineProperties(Vue.prototype, {
        // 注意，此处挂载在 Vue 原型的 $api 对象上
        $api: {
            get() {
                return api
            }
        }
    })
}

export default install
