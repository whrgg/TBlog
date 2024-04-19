package com.traveller.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.traveller.entity.User;

public interface UserService extends IService<User> {
    User selectUserByUsername(String username);
}
