<template>
  <div class="containner">
    <h1>原神，启动！</h1>
    <div class="article-meta">
        <span>Date</span> |
        <span>Reads: Number</span> |
        <span>Words: Number</span> |
        <span>Read Time: Number min</span>
    </div>
    <img src="https://github.com/whrgg/IMG/raw/main/TBlog-img/102799524_p2_master1200.jpg" alt="Article Image" class="article-image">
    <a href="link_to_full_article" class="read-more">阅读全文</a>
  </div>
</template>

<script>
export default {

}
</script>

<style  scoped>
    .containner{
            margin: 3vh 0;
            border: 1px solid black;
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
</style>
