package com.traveller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveller.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where user_name= #{username}")
    User selectUserByUsername(String username);
}
