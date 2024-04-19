package com.traveller.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.entity.Comment;
import com.traveller.mapper.CommentMapper;
import com.traveller.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}