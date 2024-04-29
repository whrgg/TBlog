<template>
  <div class="blogDesc-containner">
    <div class="title">{{this.blogdesc.title}}</div>
    <div class="article-meta">
        <span>Date:{{ this.blogdesc.createTime }}</span> |
        <span>Reads: {{this.blogdesc.views}}</span> |
        <span>Words: {{this.blogdesc.words}}</span> |
        <span>Read Time: {{ this.blogdesc.readTime }}</span>
    </div>
    <img :src="this.blogdesc.firstPicture" alt="Article Image" class="article-image">
    <router-link :to="`/blog/${this.blogdesc.id}`" class="read-more">阅读全文</router-link>
  </div>
</template>

<script>
export default {
  props: ['blogdesc']
}
</script>

<style  scoped>
*{
  padding: 0;
  margin: 0;
}

.blogDesc-containner{
  box-sizing: border-box;
    margin: 3vh 0;
    border: 1px solid black;
    transition: 0.2s all ease-in;
}

.title{
  height: 5vh;
}

.article-meta {
  height: 12vh;
    font-size: 0.9em;
    color: #666;
}
.read-more {
    font-weight: bold;
    color: #007bff;
    text-decoration: none;
}
img.article-image {
    width: 100%;
    height: auto;
    display: block;
    margin: 20px 0;
}
.containner:hover{
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.8);
}
</style>
