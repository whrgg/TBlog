<template>
  <div class="home">
    <el-container>
      <div>
        <img src="../assets/bj.jpg" class="el-container-background">
      </div>
      <el-main>Main</el-main>
      <el-footer>
        foot
      </el-footer>
    </el-container>

  </div>
</template>

<script>

</script>

<style scoped>
  .home{
    margin: 0;
    padding: 0;
  }

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-header{
    height: 100vw;
    /* width: 98%; */
    /* position:fixed; */
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .el-container-background{
    width: 100%;
    height: 60vw;
    object-fit: cover;
    /* filter: brightness(0.8); */
  }
</style>
