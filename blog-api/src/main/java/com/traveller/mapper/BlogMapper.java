package com.traveller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveller.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    @Insert("insert into blog ( title, first_picture, content, description, is_published," +
            " is_recommend, is_appreciation, is_comment_enabled, create_time, update_time, views, words, read_time, category_id, is_top, password, user_id) " +
            "values (#{title},#{firstPicture},#{content},#{description},#{isPublished}," +
            "#{isRecommend},#{isAppreciation},#{isCommentEnabled},#{createTime},#{updateTime},#{views},#{words},#{readTime},#{categoryId},#{isTop},#{password},#{userId})")
    Integer saveBlog(Blog blog);
}
