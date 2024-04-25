<template>
    <div class="Abouttop">
        <div class="aboutmebox">
            <div class="tou">
                <img src="https://q.qlogo.cn/g?b=qq&nk=2186840198&s=640">
            </div>
            <div class="myname">
                traveller
            </div>
            <div id="text-container">
                <el-collapse accordion>
                    <el-collapse-item :title="item.title" :name="index" v-for="(item, index) in introduction.favorites"
                        :key="index">
                        <div>{{ item.content }}</div>
                    </el-collapse-item>
                </el-collapse>
            </div>
        </div>

    </div>
</template>

<script>

const about = {

  data: function () {
    return {
      introduction: {
        favorites: [
          { title: '喜欢的小说人物', content: '封不觉，陈平安，齐静春，高文，槐诗' },
          { title: '喜欢的游戏', content: '火山的女儿，卡拉比丘，原神，崩坏三' },
          { title: '喜欢游戏', content: '火山的女儿，卡拉比丘，原神，崩坏三' },
          { title: '喜欢游戏', content: '火山的女儿，卡拉比丘，原神，崩坏三' }
        ],
        rollText: '遇事不决，可问春风'
      },
      activeName: '1'
    }
  },
  methods: {

  },
  mounted () {

  }
}
export default about
</script>

<style scoped>
* {
    padding: 0;
    margin: 0;
}

.Abouttop {
    width: 100%;
    transition: 0.2s all ease-in;
}

.tou {
    width: 100%;
    height: 100%;
}

.tou img {
    width: 100%;
    height: 100%;
}

.aboutmebox {
    text-align: center;
    align-items: center;
    padding-bottom: 3%;
    flex-direction: column;
}

.myname {
    font-size: 20px;
}

.el-collapse-item {
    background-color:black;
}

.el-collapse-item .el-collapse-item__content {

    padding-bottom: 10px;
}

.Abouttop:hover {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.8);
}
.text-container{
    background: url('../../assets/qwq.jpg');
}

</style>
