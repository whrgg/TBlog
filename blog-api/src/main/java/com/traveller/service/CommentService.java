package com.traveller.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.traveller.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    IPage getlistByBlogId(Integer page, Integer pageSize, Long blogId);

    List<Comment> selectChildById(Long id);
}