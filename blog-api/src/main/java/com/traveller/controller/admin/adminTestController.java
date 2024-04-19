package com.traveller.controller.admin;

import com.traveller.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class adminTestController {

    @GetMapping("/hello")
    public Result<String> message(){
        return Result.sucessful("hello world");
    }
}
