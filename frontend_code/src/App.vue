<template>
  <div id="app">
    <el-container style="height: 700px; border: 1px solid #eee" >
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['0']" router :default-active="this.$route.name">
          <el-submenu v-for="(item, index) in $router.options.routes" :index="index+''" :key="item.name" >
            <template slot="title"><i class="el-icon-message"></i>{{ item.name }}</template>
            <el-menu-item v-for="(item2) in item.children " v-bind:index="item2.path" :key="item2.name" v-show="item2.show"
                          :class="$route.path === item2.path?'is-active':''">{{item2.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <!--          <el-dropdown>-->
          <!--            <i class="el-icon-setting" style="margin-right: 15px"></i>-->
          <!--            <el-dropdown-menu slot="dropdown">-->
          <!--              <el-dropdown-item>查看</el-dropdown-item>-->
          <!--              <el-dropdown-item>新增</el-dropdown-item>-->
          <!--              <el-dropdown-item>删除</el-dropdown-item>-->
          <!--            </el-dropdown-menu>-->
          <!--          </el-dropdown>-->
          <span>LIU XINGWEI</span>
        </el-header>

        <el-main>
          <router-view v-if="isRouterAlive"/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    }
  }
}
</script>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
