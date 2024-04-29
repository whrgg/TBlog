<template>
  <div id="comment-section">
    <h2>评论区</h2>
    <p>在下方进行评论：</p>
    <textarea id="comment-text" placeholder="请输入您的评论..." v-model="textareaValue"></textarea>
    <button @click="createNewComment()">评论</button>
</div>
</template>

<script>
import { saveComment } from '@/api/Comment'
export default {
  data: function () {
    return {
      textareaValue: '',
      comment: null,
      path: ''
    }
  },
  methods: {
    createNewComment () {
      if (this.textareaValue === '' || this.textareaValue === null) {
        return
      }
      this.comment = {
        content: this.textareaValue,
        isPublished: 1,
        isAdminComment: 0,
        page: 0,
        isNotice: 0,
        blogId: this.$route.params.id,
        parentCommentId: -1,
        website: '6666',
        qq: '666666666'
      }
      this.path = this.$route.path
      if (this.path.includes('/friend')) {
        this.comment.page = 0
        this.comment.blogId = -1
      }
      saveComment(this.comment)
      this.$router.go(0)
    }
  }
}
</script>

<style scoped>
  * {
      margin: 0;
      padding: 0;
  }
  #comment-section {
      position: relative;
      box-sizing: border-box;
      width: 100%;
      min-height: 200px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  h2 {
      margin-top: 0;
  }
  textarea {
      box-sizing: border-box;
      width: 100%;
      height: 100px;
      resize: none;
      margin-bottom: 10px;
      outline: none;
  }
  button {
      position: absolute;
      padding: 10px 20px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      bottom: 0;
      right: 0;
  }
  button:hover {
      background-color: #0056b3;
  }
</style>
