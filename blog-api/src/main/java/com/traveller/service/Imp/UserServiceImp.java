package com.traveller.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.constant.UserConstant;
import com.traveller.entity.User;
import com.traveller.mapper.UserMapper;
import com.traveller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {

    @Autowired
    UserMapper userMapper;

    //重写登录验证方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectUserByUsername(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException(UserConstant.USER_NOT_FOUND);
        }
        return user;
    }


    @Override
    public User selectUserByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
        user.setPassword(null);
        return user;
    }
}
