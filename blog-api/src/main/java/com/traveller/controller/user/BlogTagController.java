package com.traveller.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.traveller.entity.BlogTag;
import com.traveller.entity.Tag;
import com.traveller.service.BlogTagService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Blogtag接口")
@RestController
@RequestMapping("/user/blogtag")
public class BlogTagController {

    @Autowired
    BlogTagService tagservice;

    @ApiOperation("根据id获取tags关系")
    @GetMapping("/list/{id}")
    public Result<List<BlogTag>> list(@PathVariable Integer id){

        LambdaQueryWrapper<BlogTag> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(BlogTag::getBlogId,id);

        List<BlogTag> list = tagservice.list(queryWrapper);

        return Result.success(list);
    }


}
