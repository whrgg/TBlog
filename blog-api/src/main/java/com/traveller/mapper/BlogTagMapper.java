package com.traveller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveller.entity.BlogTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    //根据博客文章id删除tags
    @Delete("delete from blog_tag where blog_id=#{blogId}")
    public void deleteByBlogId(Long blogId);
}