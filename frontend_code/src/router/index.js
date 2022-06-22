import Vue from 'vue'
import Router from 'vue-router'
import 'element-ui/lib/theme-chalk/index.css'
import index from '../components/index'
import StudentInformation from '../components/StudentInformation'
import AddStudent from '../components/AddStudent'
import StudentUpdate from '../components/StudentUpdate'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '学生管理',
      component: index,
      redirect: '/StudentInformation',
      children: [
        {
          path: '/StudentInformation',
          name: '学生情報',
          show: true,
          component: StudentInformation
        },
        {
          path: '/add',
          name: '学生追加',
          show: true,
          component: AddStudent
        },
        {
          path: '/update',
          show: false,
          component: StudentUpdate
        }
      ]
    }
  ]
})
