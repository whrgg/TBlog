package com.traveller.controller.admin;

import com.traveller.entity.Category;
import com.traveller.service.CategoryService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理端的分类接口")
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiOperation("保存分类")
    @PostMapping("/save")
    public Result<String> save(@RequestBody Category category){

        categoryService.save(category);

        return Result.success("保存成功");
    }

    @ApiOperation("修改")
    @PutMapping("/update")
    public Result<String> update(@RequestBody Category category){

        categoryService.updateById(category);

        return Result.success("修改成功");
    }


    /**
     * 直接写为传ids
     * @param ids
     * @return {@link Result}<{@link String}>
     */
    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody List<Long> ids){

        categoryService.removeByIds(ids);

        return Result.success("删除");
    }
}
