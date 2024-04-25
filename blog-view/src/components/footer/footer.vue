<template>
<div class="main-contain">
    <div class="column left">
        <p>关于我</p>
    </div>
    <div class="column center">
        <h2>猜你想猜</h2>
        <div class="content">
            <div class="item">Content 1</div>
            <div class="item">Content 2</div>
            <div class="item">Content 3</div>
            <div class="item">Content 4</div>
        </div>
    </div>
    <div class="column right">
        <h2>我自有火，和羡他人光 --方向阳</h2>
    </div>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
* {
    box-sizing: border-box;
}
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: space-between;
}
.column {
    padding: 20px;
    flex: 1;
}
.center .content {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 10px;
}
.item {
    padding: 10px;
    background-color: #f8f8f8;
    border: 1px solid #ddd;
}
.main-contain{
    margin-top: 10px;
}
</style>
