package com.traveller.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.entity.BlogTag;
import com.traveller.mapper.BlogTagMapper;
import com.traveller.service.BlogTagService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTagServiceImp extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {

    @Autowired
    BlogTagMapper blogTagMapper;


    @Override
    public void removeByBlogIds(List<Long> blogId) {
        blogTagMapper.deleteByBlogIds(blogId);
    }
}