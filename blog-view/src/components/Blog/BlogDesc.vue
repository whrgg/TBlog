<template>
  <div class="containner">
    <h1>{{this.blogdesc.title}}</h1>
    <div class="article-meta">
        <span>Date:{{ this.blogdesc.createTime }}</span> |
        <span>Reads: {{this.blogdesc.views}}</span> |
        <span>Words: {{this.blogdesc.words}}</span> |
        <span>Read Time: {{ this.blogdesc.readTime }}</span>
    </div>
    <img :src="this.blogdesc.firstPicture" alt="Article Image" class="article-image">
    <a href="link_to_full_article" class="read-more">阅读全文</a>
  </div>
</template>

<script>
export default {
  props: ['blogdesc'],
  created () {
    console.log(this.blogdesc.title)
  }
}
</script>

<style  scoped>
    .containner{
            margin: 3vh 0;
            border: 1px solid black;
            transition: 0.2s all ease-in;
        }

    .article-meta {
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
