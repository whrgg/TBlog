package com.traveller.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.traveller.entity.Blog;
import com.traveller.entity.vo.BlogVo;

import java.util.List;

public interface BlogService extends IService<Blog> {

    public IPage<Blog> pageBlogDesc(Integer page, Integer pageSize);

    public IPage<Blog> pageBlog(Integer page, Integer pageSize);

    public void saveBlog(BlogVo blog);

    void removeBlogAndTagById(Long id);

    void updateAll(BlogVo blogVo);
}
