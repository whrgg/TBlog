<template>
  <div class="comments-containner">
    <createcomment></createcomment>
    <commentVue></commentVue>
  </div>
</template>

<script>
import commentVue from './comment.vue'
import createcomment from './creatcomment.vue'
export default {
  name: 'comments',
  components: {
    commentVue: commentVue,
    createcomment: createcomment
  }
}
</script >

<style scoped>

</style>
