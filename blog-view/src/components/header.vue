<template>
    <div class="headerComponent">
        <el-menu
        :default-active="activeIndex1"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="rgb(36, 74, 191)"
        text-color="#00FFFF"
        active-text-color="#fff">
        <router-link to="/">
          <el-menu-item index="1">
              首页
          </el-menu-item>
        </router-link>
        <el-submenu index="2">
            <template slot="title">
              文章
            </template>
           <router-link to="/diary" ><el-menu-item index="2-1" >日记</el-menu-item></router-link>
          <router-link to="/technology"><el-menu-item index="2-2">技术</el-menu-item></router-link>
        </el-submenu>
        <router-link to="/friend"><el-menu-item index="3">友链</el-menu-item></router-link>
        </el-menu>
    </div>
</template>

<script>
export default {
  name: 'headerVue',
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
<style scoped>
    *{
        margin: 0;
        padding: 0;
        list-style: none;
        text-decoration: none;
    }
    a:visited  {
        background-color: red;
    }
    .el-menu-demo {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 15vh; /* 或者一个具体的高度值 */
    }
    .el-menu-item{
      font-size: larger;
    }
    .el-submenu *{
        font-size: larger;
    }
</style>
