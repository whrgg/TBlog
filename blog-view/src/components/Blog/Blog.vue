<template>
    <div v-highlight class="main-containner" >
        <div class="main-containner-title">
            <h1>{{blog.title}}</h1>
        </div>
        <div class="main-containner-desc">
            <span>最后更新时间:{{ blog.updateTime }}</span> |
            <span>浏览次数: {{blog.views}}</span> |
            <span>文本数量: {{blog.words}}</span> |
            <span>大致阅读时间: {{ blog.readTime }} min</span>
        </div>
        <div  class="main-containner-body markdown-body"  v-highlight v-html="blog.content">
        </div>
        <br>
        <br>
        <br>
        <Comments :comments="comments"></Comments>
    </div>
</template>

<script scoped>
import Comments from '@/components/comments/comments.vue'
export default {
  props: ['blog', 'comments'],
  components: {
    Comments: Comments
  },
  data: function () {
    return {
    }
  },
  mounted () {
  }

}
</script>

<style scoped >
*{
    margin: 0;
    padding: 0;
}

.main-containner{
    width: 100%;
    position: relative;
}

.main-containner-title{
    margin-bottom: 2vh;
}
.main-containner-desc{
    margin-bottom: 1vh;
    font-size: large;
}
.main-containner-body{
    text-align:left ;
}
.markdown-body {
    box-sizing: border-box;
    min-width: 200px;
    max-width: 980px;
    margin: 0 auto;
    padding: 45px;
}
@media (max-width: 767px) {
    .markdown-body {
        padding: 15px;
    }
}

</style>
