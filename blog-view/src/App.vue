<template>
  <div id="app">
    <headerVue></headerVue>
    <router-view/>
    <footerVue></footerVue>
  </div>
</template>

<script>
import headerVue from './components/header.vue'
import footerVue from '@/components/footer/footer.vue'
export default {
  components: {
    headerVue: headerVue,
    footerVue: footerVue
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

</style>
