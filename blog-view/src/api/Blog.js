import { userAxios, adminAxios } from '../utils/request'

export function getBlogPage (page, pageSize) {
  console.log(page, pageSize)
  return userAxios({
    url: '/blog/desc',
    method: 'GET',
    params: {
      page: page,
      pageSize: pageSize
    }
  })
}

export function getBlogById (id) {
  return userAxios({
    url: `/blog/${id}`,
    method: 'GET'
  })
}

export function saveBlog (token1, blog) {
  return adminAxios({
    url: '/blog/save',
    method: 'POST',
    headers: {
      token: token1
    },
    data: blog
  })
}

export function deleteBlog (token1, blog) {
  return adminAxios({
    url: '/blog/delete',
    method: 'POST',
    headers: {
      token: token1
    },
    data: blog
  })
}

export function update (token1, blog) {
  return adminAxios({
    url: '/blog/update',
    method: 'POST',
    headers: {
      token: token1
    },
    data: blog
  })
}
