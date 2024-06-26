package com.traveller.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.traveller.entity.Blog;
import com.traveller.service.BlogService;
import com.traveller.service.BlogTagService;
import com.traveller.utils.MarkdownUtils;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author traveller
 * @date 2024/04/19
 * 博客文章内容
 */
@Slf4j
@Api(tags ="用户端博客文章管理接口")
@RestController
@RequestMapping("/user/blog")
public class BlogTextController {

    @Autowired
    BlogService blogService;

    /**
     * @param page
     * @param pageSize
     * @return {@link Result}<{@link IPage}<{@link Blog}>>
     * 分页查询blog的内容
     */
    @ApiOperation("获取文章相关内容")
    @GetMapping("/desc")
    public Result<IPage<Blog>> GetBlog(@Param("page") Integer page, @Param("pageSize") Integer pageSize){
        IPage<Blog> blogIPage = blogService.pageBlogDesc(page, pageSize);
        return Result.success(blogIPage);
    }

    @ApiOperation("根据id获取文章详情")
    @GetMapping("/{id}")
    public Result<Blog> GetBlogById(@PathVariable  Integer id){

        Blog blog = blogService.getById(id);
        String content = blog.getContent();
        content= MarkdownUtils.ParseMarkdown(content);
        blog.setContent(content);

        return Result.success(blog);
    }



}
