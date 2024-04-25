package com.traveller.controller.admin;

import com.traveller.annotation.OperateLog;
import com.traveller.entity.Tag;
import com.traveller.service.TagService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户端标签")
@RestController
@RequestMapping("/admin/tag")
public class AdminTagController {
    @Autowired
    TagService tagService;

    @ApiOperation("标签的保存")
    @PostMapping("/save")
    public Result<String> save(@RequestBody Tag tag){

        tagService.save(tag);

        return Result.success("保存成功");
    }


    @ApiOperation(("标签的删除"))
    @OperateLog("删除评论各类")
    @PostMapping("/delete")
    public Result<String> delete(@RequestBody Tag tag){

        tagService.removeById(tag);

        return Result.success("删除标签");
    }

    @ApiOperation("更新")
    @OperateLog("更新评论各类状态")
    @PostMapping("/update")
    public Result<String> update(@RequestBody Tag tag){

        tagService.updateById(tag);

        return Result.success("更新标签");
    }
}
