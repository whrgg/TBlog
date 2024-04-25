package com.traveller.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.traveller.entity.BlogTag;

import java.util.List;

public interface BlogTagService extends IService<BlogTag> {
    public void removeByBlogIds(List<Long> blogId);
}