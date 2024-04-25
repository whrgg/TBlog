<template>
  <div class="home">
    <el-container>
      <el-main>
        <BlogVue></BlogVue>
      </el-main>
      <div class="container-left-somedesc">
        <Homeleft class="somedesc-margin"></Homeleft>
      </div>
    </el-container>
    <Comments></Comments>
    <el-pagination
  background
  layout="prev, pager, next"
  :total="30">
</el-pagination>
  </div>
</template>

<script>
import BlogVue from '@/components/Blog/Blog.vue'
import homeleft from '@/components/home/homeLeft.vue'
import Comments from '@/components/comments/comments.vue'
export default {
  components: {
    BlogVue: BlogVue,
    Homeleft: homeleft,
    Comments: Comments
  }
}
</script>

<style scoped>
  .home .el-main {
    width: 75vw;
    background-color:white;
    color: #333;
    text-align: center;
  }
  .container-left-somedesc{
    width: 25vw;
    display: flex;
    flex-direction: column;
  }
  .somedesc-margin{
    margin: 10vh 0;
  }
</style>
