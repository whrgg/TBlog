<template>
  <div class="comments-containner">
    <img src="@/assets/qwq.jpg" alt="" class="comments-photo">
    <div class="comments-containner-left">
      <div class="comments-containner-time">
        <span class="comment-desc">traveller</span>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span class="comment-desc">2024-4-25</span>
      </div>
      <div class="comment-text">
Unix系统使用的是时间片算法，而Windows则属于抢占式的。

在时间片算法中，所有的进程排成一个队列。操作系统按照他们的顺序，给每个进程分配一段时间，即该进程允许运行的时间。如果在时间片结束时进程还在运行，则CPU将被剥夺并分配给另一个进程。如果进程在时间片结束前阻塞或结束，则CPU当即进行切换。调度程序所要做的就是维护一张就绪进程列表，当进程用完它的时间片后，它被移到队列的末尾。

所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
所谓抢占式操作系统，就是说如果一个进程得到了 CPU 时间，除
      </div>
    </div>
  </div>
</template>

<script>

export default {

}
</script>

<style scoped>
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
    margin-left: 2%;
  }
  .comment-desc{
    font-weight:600;
    font-size: large;
  }
</style>
