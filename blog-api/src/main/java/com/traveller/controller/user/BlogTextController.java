package com.traveller.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.traveller.entity.Blog;
import com.traveller.service.BlogService;
import com.traveller.service.BlogTagService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author traveller
 * @date 2024/04/19
 * 博客文章内容
 */
@Api(tags ="用户端博客文章管理接口")
@RestController
@RequestMapping("/user")
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
    @GetMapping("/blog/desc")
    public Result<IPage<Blog>> GetBlog(int page,int pageSize){
        IPage<Blog> blogIPage = blogService.pageBlogDesc(page, pageSize);
        return Result.success(blogIPage);
    }



}
