package com.traveller.controller.admin;

import com.traveller.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/admin")
public class AdminTestController {

    @GetMapping("/hello")
    public Result<String> message(){
        return Result.success("hello world");
    }
}
