<template>
  <div class="main-contain">
    <div class="shell">
      <friendboxVue v-for="item in friendList" :key="item.id" :friend="item"></friendboxVue>
    </div>
    <comments :comments="comments"></comments>
    <el-pagination
  background
  layout="prev, pager, next"
  :total="total"
  @current-change="handleCurrentChange">
</el-pagination>
  </div>

</template>

<script>
import friendboxVue from '@/components/friend/friendbox.vue'
import comments from '@/components/comments/comments.vue'
import { getFriendList } from '@/api/Friend'
import { getCommentByBlogId } from '@/api/Comment'
export default {
  name: 'firend',
  components: {
    friendboxVue: friendboxVue,
    comments: comments
  },
  data: function () {
    return {
      friendList: [],
      comments: null,
      currentPage: 1,
      total: 1
    }
  },
  mounted () {
    getFriendList().then(resp => {
      this.friendList = resp.data.data
    })
  },
  created () {
    getCommentByBlogId(-1, null, null)
      .then(res => {
        this.comments = res.data.data.records
        this.total = res.data.data.pages * 10
      })
  },
  methods: {
    handleCurrentChange (val) {
      this.currentPage = val
      getCommentByBlogId(-1, this.currentPage, null).then(response => {
        this.comments = response.data.data.records
        this.total = response.data.data.pages * 10
      })
    }
  }
}
</script>
<style src="@/css/friend.css" scoped>

</style>
