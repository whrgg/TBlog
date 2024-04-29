import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IndexView from '../views/index.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/LoginView'),
    meta: { title: '登录' }
  },
  {
    path: '/',
    name: 'index',
    component: IndexView,
    redirect: '/home',
    children: [
      {
        path: '/home',
        name: 'home',
        component: HomeView,
        meta: { title: '首页' }
      },
      {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
      },
      {
        path: '/friend',
        name: 'friend',
        component: () => import('../views/friendView.vue')
      },
      {
        path: '/diary',
        name: 'diary',
        component: () => import('../views/diaryView.vue')
      },
      {
        path: '/blog/:id',
        name: '/blog',
        component: () => import('../views/blogView.vue')
      }
    ]
  }

]

const router = new VueRouter({
  routes
})

export default router
