package com.traveller.controller.user;

import com.traveller.entity.BlogTag;
import com.traveller.service.BlogTagService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("用户端的tag接口")
@RestController
@RequestMapping("/user/tags")
public class BlogTagController {

    @Autowired
    BlogTagService tagservice;

    @ApiOperation("获取tags")
    @GetMapping("/list")
    public Result<List<BlogTag>> list(){

        List<BlogTag> list = tagservice.list();

        return Result.success(list);
    }

}
