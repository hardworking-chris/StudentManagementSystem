// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import router from './router'
import moment from 'moment'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.filter('dateFormat', function (dateStr, pattern = 'YYYY-MM-DD') {
  return moment(dateStr).format(pattern)
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App)
})
