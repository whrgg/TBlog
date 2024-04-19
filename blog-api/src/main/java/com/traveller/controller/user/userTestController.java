package com.traveller.controller.user;

import com.traveller.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userTestController {

    @GetMapping("/hello")
    public Result<String> message(){
        return Result.sucessful("hello world");
    }
}
