package com.traveller.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.traveller.entity.BlogTag;

public interface BlogTagService extends IService<BlogTag> {
    public void removeByBlogId(Long blogId);
}