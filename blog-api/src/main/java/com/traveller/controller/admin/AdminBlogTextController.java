package com.traveller.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.traveller.annotation.OperateLog;
import com.traveller.entity.Blog;
import com.traveller.entity.Category;
import com.traveller.entity.vo.BlogVo;
import com.traveller.service.BlogService;
import com.traveller.service.BlogTagService;
import com.traveller.service.CategoryService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author traveller
 * @date 2024/04/19
 * 博客文章内容
 */
@Api(tags = "管理端博客文章管理接口")
@RestController()
@RequestMapping("/admin/blog")
public class AdminBlogTextController {

    @Autowired
    BlogService blogService;
    @Autowired
    BlogTagService TagService;
    @Autowired
    CategoryService categoryService;

    /**
     * @param blogVo
     * @return {@link Result}<{@link String}>
     * 管理员保存文章
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public Result<String> saveBlog(@RequestBody BlogVo blogVo){

        blogService.saveBlog(blogVo);

        return Result.success("博客文章保存成功");

    }

    @ApiOperation("删除博客文章")
    @OperateLog("删除博客")
    @DeleteMapping("/delete")
    public Result<String> deleteBlog(@RequestBody BlogVo blogVo){

        blogService.removeBlogAndTagById(blogVo.getId());

        return Result.success("删除博客");
    }

    @ApiOperation("修改文章")
    @PutMapping("/update")
    public Result<String> updateBlog(@RequestBody BlogVo blogVo){

        //可以直接更新文章
        blogService.updateAll(blogVo);
        //先删标签在添加标签

        return Result.success("修改成功");
    }


}
