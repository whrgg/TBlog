<template>
  <div class="main-box">
    <div class="firedbox">
            <h2 class="by">{{friend.description}}</h2>
            <img src="../../assets/qwq.jpg" alt="" class="firend">
            <div class="info">
                <div class="info-top"></div>
                <div class="info-bottom"></div>
                <img :src="friend.avatar" alt="" class="info-img">
                <h2 class="friendname">{{friend.nickname}}</h2>
            </div>
        </div>
  </div>
</template>

<script>
export default {
  props: ['friend'],
  mounted () {
  }

}
</script>

<style src="@/css/friend.css" scoped>

</style>
