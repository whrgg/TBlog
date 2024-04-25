<template>
  <div class="main-contain">
    <div class="shell">
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
      <friendboxVue></friendboxVue>
    </div>
    <comments></comments>
    <el-pagination
  background
  layout="prev, pager, next"
  :total="30">
</el-pagination>
  </div>

</template>

<script>
import friendboxVue from '@/components/friend/friendbox.vue'
import comments from '@/components/comments/comments.vue'
export default {
  name: 'firend',
  components: {
    friendboxVue: friendboxVue,
    comments: comments
  }
}
</script>
<style src="@/css/friend.css" scoped>

</style>
