package com.traveller.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.traveller.entity.Comment;
import com.traveller.service.CommentService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "评论查询")
@RestController
@RequestMapping("/user/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation("根据博文id获取评论")
    @GetMapping("/bloglist")
    public Result<IPage> list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "4") Integer pageSize,
                       @RequestParam Long blogId){


        IPage Ipage = commentService.getlistByBlogId(page, pageSize, blogId);

        return Result.success(Ipage);

    }

}
