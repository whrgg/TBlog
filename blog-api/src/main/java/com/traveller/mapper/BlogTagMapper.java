package com.traveller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveller.entity.BlogTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    //根据博客文章id删除tags
    @Delete("delete from blog_tag where blog_id=#{blogId}")
    public void deleteByBlogId(Long blogId);


    //TODO:为什么识别不到ids呢？不加注解的话，mybatis-plus冲突？
    void deleteByBlogIds(@Param("ids") List<Long> ids);
}