<template>
  <div class="home">
    <el-container>
      <div>
        <img src="../assets/bj.jpg" class="el-container-background">
      </div>
      <el-container>
      <el-main>
        <!-- 走马图 -->
        <el-carousel height="400px" direction="vertical" :autoplay="true" trigger="click">
          <el-carousel-item v-for="item in RangeBlog" :key="item">
            <div class="carousel-div-containner">
              <img :src="item.img" class="carousel-img">
              <div class="carousel-div-containner-right">
                <h3>2023-12-23</h3>
                <h3 class="medium">{{ item.text }}</h3>
              </div>
            </div>
          </el-carousel-item>
       </el-carousel>
       <!-- 走马图结束 -->
        <BlogDesc v-for="item in BlogDesc" :key="item.index" :blogdesc="item"></BlogDesc>
        <el-pagination
  background
  layout="prev, pager, next"
  :total="total"
  @current-change="handleCurrentChange">
</el-pagination>
      </el-main>
      <div class="container-left-somedesc">
        <HomeLeft class="somedesc-margin-1"></HomeLeft>
      </div>
      </el-container>
      <el-footer>

      </el-footer>
    </el-container>

  </div>
</template>

<script>
import HomeLeft from '@/components/home/homeLeft.vue'
import BlogDesc from '@/components/Blog/BlogDesc.vue'
import { getBlogPage } from '@/api/Blog'
export default {
  components: {
    HomeLeft: HomeLeft,
    BlogDesc: BlogDesc
  },
  data: function () {
    return {
      RangeBlog: [{ img: 'https://github.com/whrgg/IMG/raw/main/TBlog-img/103451088_p0_master1200.jpg', text: '666666' },
        { img: 'https://github.com/whrgg/IMG/raw/main/TBlog-img/%E5%A3%81%E7%BA%B8.png', text: '99999999999' },
        { img: 'https://github.com/whrgg/IMG/raw/main/TBlog-img/%E5%BE%88%E5%A5%BD%E7%9C%8B%E7%9A%84%E7%A5%9E%E5%AD%90.png', text: '77777777777' }],
      BlogDesc: [],
      total: 10,
      currentPage: 1
    }
  },
  mounted () {
    getBlogPage(1, 2).then(response => {
      this.BlogDesc = response.data.data.records
      this.total = response.data.data.pages * 10
    })
  },
  methods: {
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      this.currentPage = val
      getBlogPage(this.currentPage, 2).then(response => {
        this.BlogDesc = response.data.data.records
        this.total = response.data.data.pages * 10
      })
    }
  }
}

</script>

<style scoped>
  .home{
    margin: 0;
    padding: 0;
  }

  .el-header, .el-footer {
    background-color: white;
    color: #E9EEF3;
    text-align: center;
    line-height: 60px;
  }
  .el-footer{
    width: 0px;
    height: 0px;
    line-height: 0px;
  }
  .el-header{
    height: 100vh;
    /* width: 98%; */
    /* position:fixed; */
  }

  .home .el-main {
    background-color:white;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .el-container-background{
    width: 100%;
    height: 60vw;
    object-fit: cover;
    /* filter: brightness(0.8); */
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  /* 走马灯中的布局 */
  .carousel-div-containner{
    height: 100%;
    width: 100%;
    display: flex;
  }
  /* 走马灯中的图片 */
  .carousel-img{
    height: 100%;
    width: 40%;
    object-fit: cover;
  }

  .carousel-div-containner-right{
    width: 60%;
    text-align: center;
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
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
