package com.traveller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveller.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select * from comment where blog_id=#{blogId} and page=#{page} and parent_comment_id=#{parentId}")
    List<Comment> selectByBlogIdAndPageAndParentId(@Param("blogId") Long blogId, @Param("page") Integer page, @Param("parentId") Long parentId);

    @Select(("select * from comment where parent_comment_id=#{id}"))
    List<Comment> selectChildById(Long id);
}