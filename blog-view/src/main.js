import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import hljs from 'highlight.js'
import 'github-markdown-css/github-markdown.css'
// import Viewer from 'v-viewer'
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.directive('highlight', function (el) {
  const blocks = el.querySelectorAll('pre code')
  blocks.forEach((block) => {
    hljs.highlightBlock(block)
  })
})
// Vue.use(Viewer)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
