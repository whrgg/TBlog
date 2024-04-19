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
        <el-menu-item index="1">
            <router-link to="/">首页</router-link>
        </el-menu-item>
        <el-submenu index="2">
            <template slot="title">
                 <router-link to="/message">文章</router-link>
            </template>
            <el-menu-item index="2-1" ><router-link to="/home/diary" >日记</router-link></el-menu-item>
            <el-menu-item index="2-2"><router-link to="/home/technology">技术</router-link></el-menu-item>
        </el-submenu>
        <el-menu-item index="3"><router-link to="/friend">友链</router-link></el-menu-item>
        <el-menu-item index="4">
            <router-link to=""></router-link>
        </el-menu-item>
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
        height: 100%; /* 或者一个具体的高度值 */
    }
</style>
