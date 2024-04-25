package com.traveller.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.traveller.annotation.OperateLog;
import com.traveller.entity.Comment;
import com.traveller.service.CommentService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理评论")
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation("保存评论")
    @PostMapping("/save")
    public Result<String> saveComment(@RequestBody Comment comment){

        //comment的内容除了id全部由前端发来的决定
        //所以直接存即可
        commentService.save(comment);


        return Result.success("保存成功");
    }

    @ApiOperation("删除评论操作")
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody Comment comment){
        //判断是否是根节点
        if(comment.getParentCommentId()!=1){
            commentService.removeById(comment.getId());
        }else{
            List<Comment> list = commentService.selectChildById(comment.getId());
            for (Comment comment1 : list) {
                commentService.removeById(comment);
            }
            commentService.removeById(comment);
        }
        return Result.success("删除成功");
    }

    @ApiOperation("修改操作")
    @OperateLog("更新评论各类状态")
    @PutMapping("/update")
    public Result<String> update(@RequestBody Comment comment){
        commentService.updateById(comment);
        return Result.success("修改成功");
    }

}
