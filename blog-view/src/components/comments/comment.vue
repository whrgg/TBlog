<template>
  <div class="comments-containner">
    <img :src="comment.avatar" alt="" class="comments-photo">
    <div class="comments-containner-left">
      <div class="comments-containner-time">
        <span class="comment-desc">{{comment.nickname}}</span>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span class="comment-desc">{{comment.createTime}}</span>
      </div>
      <div class="comment-text">
        {{ comment.content }}
      </div>
      <br>
      <br>
      <commentchild v-for="item in comment.children " :key="item.id" :commentchild="item"></commentchild>
      <el-button type="text" @click="open">回复</el-button>
    </div>

  </div>
</template>

<script>
import commentchild from '@/components/comments/commentChild.vue'
import { saveComment } from '@/api/Comment'
export default {
  props: ['comment'],
  components: {
    commentchild: commentchild
  },
  data: function () {
    return {
      newComment: null,
      path: ''
    }
  },
  methods: {
    createNewComment (value) {
      if (value === '' || value === null) {
        return
      }
      this.newComment = {
        content: value,
        isPublished: 1,
        isAdminComment: 0,
        page: 0,
        isNotice: 0,
        blogId: this.$route.params.id,
        parentCommentId: this.comment.id,
        website: '6666',
        qq: '666666666'
      }
      this.path = this.$route.path
      if (this.path.includes('/friend')) {
        this.newComment.page = 0
        this.newComment.blogId = -1
      }
      saveComment(this.newComment)
    },
    open () {
      this.$prompt('请输入回复', '回复', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputErrorMessage: '回复不正确'
      }).then(({ value }) => {
        this.createNewComment(value)
        this.$message({
          type: 'success',
          message: '回复成功'
        })
        // this.$router.go(0)
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '回复取消'
        })
      })
    }
  }
}

</script>

<style scoped>
*{
  padding: 0;
  margin: 0;
}
.comments-containner{
  display: flex;
  text-align: left;
  position: relative;
  width: 100%;
  min-height: 20vh;
  background-color: aqua;
}

.comments-containner > img{
  border-radius:50%;
  width: 75px;
  height: 75px;
  object-fit: contain;
}

.comments-containner-left{
  width: 100%;
  margin-left: 2%;
}
.comment-desc{
  font-weight:600;
  font-size: large;
}

.el-button {
  width: 68px;
  height: 37px;
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

.el-button:hover {
    background-color: #0056b3;
}
</style>
