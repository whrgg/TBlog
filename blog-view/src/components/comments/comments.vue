<template>
  <div class="comments-containner">
    <createcomment></createcomment>
    <commentVue v-for=" item in comments" :key="item.id" class="comentVue" :comment="item"></commentVue>

  </div>
</template>

<script>
import commentVue from './comment.vue'
import createcomment from './creatcomment.vue'
export default {
  props: ['comments'],
  name: 'comments',
  components: {
    commentVue: commentVue,
    createcomment: createcomment
  }
}
</script >

<style scoped>
 .comments-containner .commentVue{
    margin: 5vh 0;
  }
</style>
