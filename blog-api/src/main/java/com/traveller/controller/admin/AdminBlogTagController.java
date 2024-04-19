package com.traveller.controller.admin;

import com.traveller.entity.BlogTag;
import com.traveller.service.BlogTagService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理端标签接口")
@RestController
@RequestMapping("/admin/tag")
public class AdminBlogTagController {

    @Autowired
    BlogTagService tagService;

    @ApiOperation("存tag")
    @PostMapping("/save")
    public Result<String> save(@RequestBody BlogTag blogTag){

        tagService.save(blogTag);

        return Result.success("保存成功");
    }

    @ApiOperation("修改tag")
    @PutMapping("/update")
    public Result<String> update(@RequestBody BlogTag blogTag){

        tagService.updateById(blogTag);

        return Result.success("保存成功");
    }

    @ApiOperation("删除tag")
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody List<Long> ids){

        tagService.removeBatchByIds(ids);

        return Result.success("删除成功");
    }

}
