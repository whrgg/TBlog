package com.traveller.controller.user;

import com.traveller.entity.Tag;
import com.traveller.service.TagService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Api(tags = "标签管理")
@RestController
@RequestMapping("/user/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @ApiOperation("获取所有的标签")
    @GetMapping("/list")
    public Result<List<Tag>> selectAll(){

        List<Tag> list = tagService.list();

        return Result.success(list);

    }

    @ApiOperation("根据id获取标签")
    @GetMapping("/{id}")
    public Result<Tag> selectById(@PathVariable Integer id){

        Tag tag=tagService.getById(id);

        return Result.success(tag);
    }


}
