package com.traveller.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.entity.Comment;
import com.traveller.entity.vo.CommentVo;
import com.traveller.mapper.CommentMapper;
import com.traveller.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author traveller
 * @date 2024/04/23
 * 关于评论的服务接口
 */
@Service
public class CommentServiceImp extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public IPage getlistByBlogId(Integer page, Integer pageSize, Long blogId) {

        //使用分页所有使用Lamb语句
        IPage<Comment> Ipage=new Page(page,pageSize);
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getBlogId,blogId);//博客id
        queryWrapper.eq(Comment::getPage,0);//关于博客页面的评论
        queryWrapper.eq(Comment::getParentCommentId,-1);//根评论
        commentMapper.selectPage(Ipage,queryWrapper);
        List<Comment> records = Ipage.getRecords();//拿到了该博客的全部的父评论


        List<CommentVo> voList=new ArrayList<>();
        for (Comment comment : records) {
            CommentVo vo=new CommentVo();
            List<Comment> list = commentMapper.selectByBlogIdAndPageAndParentId(blogId, 0, comment.getId());
            BeanUtils.copyProperties(comment,vo);
            vo.setChildren(list);
            voList.add(vo);
        }

        IPage<CommentVo> page1=new Page<>();
        BeanUtils.copyProperties(Ipage,page1,"records");

        page1.setRecords(voList);

        return page1;
    }

    @Override
    public List<Comment> selectChildById(Long id) {

        List<Comment> list = commentMapper.selectChildById(id);

        return list;
    }
}