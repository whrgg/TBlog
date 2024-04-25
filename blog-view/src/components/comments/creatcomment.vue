<template>
  <div id="comment-section">
    <h2>评论区</h2>
    <p>在下方进行评论：</p>
    <textarea id="comment-text" placeholder="请输入您的评论..."></textarea>
    <button>评论</button>
</div>
</template>

<script>
export default {

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
