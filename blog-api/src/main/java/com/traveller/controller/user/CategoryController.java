package com.traveller.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.traveller.entity.Category;
import com.traveller.mapper.CategoryMapper;
import com.traveller.service.CategoryService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户端的分类")
@RestController
@RequestMapping("/user/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiOperation("查询所有分类")
    @GetMapping("/list")
    public Result<List<Category>> selectAll(){

        List<Category> list = categoryService.list();

        return Result.success(list);
    }



}
