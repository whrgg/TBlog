import axios from 'axios'
import userStore from '@/store'
import { Message } from 'element-ui'
// import { Message } from 'element-ui'
const userAxios = axios.create({
  baseURL: '/api/user',
  // 超时时间 单位是ms，这里设置了3s的超时时间
  timeout: 3 * 1000
})

const adminAxios = axios.create({
  // 公共接口--这里注意后面会讲
  baseURL: '/api/admin',
  // 超时时间 单位是ms，这里设置了3s的超时时间
  timeout: 3 * 10000
})

userAxios.interceptors.request.use(config => {
  // 发请求前做的一些处理，数据转化，配置请求头，设置token,设置loading等，根据需求去添加
  config.data = JSON.stringify(config.data) // 数据转化,也可以使用qs转换
  config.headers = {
    'Content-Type': 'application/json' // 配置请求头
  }
  // 如有需要：注意使用token的时候需要引入cookie方法或者用本地localStorage等方法，推荐js-cookie
  const token = userStore.getters.getToken
  // 如果token存在，则将其添加到请求头中
  if (token) {
    config.headers.token = `${token}`
  } else {
    // 如果token不存在，则将请求头中的Authorization字段设置为空
    config.headers.token = ''
  }
  return config
}, error => {
  Promise.reject(error)
})

adminAxios.interceptors.request.use(config => {
  // 发请求前做的一些处理，数据转化，配置请求头，设置token,设置loading等，根据需求去添加
  config.data = JSON.stringify(config.data) // 数据转化,也可以使用qs转换
  config.headers = {
    'Content-Type': 'application/json' // 配置请求头
  }
  // 如有需要：注意使用token的时候需要引入cookie方法或者用本地localStorage等方法，推荐js-cookie
  const token = userStore.getters.getToken
  // 如果token存在，则将其添加到请求头中
  if (token) {
    config.headers.token = `${token}`
  } else {
    // 如果token不存在，则将请求头中的Authorization字段设置为空
    window.location.href = '/#/login'
    // 重定向到登录页面的URL
    const unauthorizedError = new Error('用户未登录，请求被取消')
    return Promise.reject(unauthorizedError) // 取消当前请求
  }
  return config
}, error => {
  Promise.reject(error)
})
// 3.响应拦截器
userAxios.interceptors.response.use(response => {
  // 接收到响应数据并成功后的一些共有的处理，关闭loading等
  if (response.data.code === 500) {
    Message.error(response.data.msg)
    return Promise.reject(new Error('Invalid request'))
  }
  return response
}, error => {
  /** *** 接收到异常响应的处理开始 *****/
  if (error && error.response) {
    // 1.公共错误处理
    // 2.根据响应码具体处理
    switch (error.response.status) {
      case 400:
        error.message = '错误请求'
        break
      case 401:
        error.message = '未授权，请重新登录'
        break
      case 403:
        error.message = '拒绝访问'
        break
      case 404:
        error.message = '请求错误,未找到该资源'
        window.location.href = '/#/login'
        break
      case 405:
        error.message = '请求方法未允许'
        break
      case 408:
        error.message = '请求超时'
        break
      case 500:
        error.message = '服务器端出错'
        break
      case 501:
        error.message = '网络未实现'
        break
      case 502:
        error.message = '网络错误'
        break
      case 503:
        error.message = '服务不可用'
        break
      case 504:
        error.message = '网络超时'
        break
      case 505:
        error.message = 'http版本不支持该请求'
        break
      default:
        error.message = `连接错误${error.response.status}`
    }
  } else {
    // 超时处理
    if (JSON.stringify(error).includes('timeout')) {
      Message.error('服务器响应超时，请刷新当前页')
    }
    error.message = '连接服务器失败'
  }

  Message.error(error.message)

  return Promise.resolve(error.response)
})
export { userAxios, adminAxios }
