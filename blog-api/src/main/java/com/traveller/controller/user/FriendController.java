package com.traveller.controller.user;

import com.traveller.entity.Friend;
import com.traveller.service.FriendService;
import com.traveller.utils.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags ="用户端友链管理接口")
@RestController
@RequestMapping("/user/friend")
public class FriendController {
    @Autowired
    FriendService friendService;

    @GetMapping("/list")
    public Result<List<Friend>> getFriendList(){
        List<Friend> list = friendService.list();
        return Result.success(list);
    }
}
