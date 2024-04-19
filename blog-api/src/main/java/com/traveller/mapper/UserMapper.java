package com.traveller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveller.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username= #{username}")
    User selectUserByUsername(String username);

    @Insert("insert into user values (#{id},#{username},#{password},#{nickname},#{avatar},#{email},#{createTime},#{updateTime},#{role}) ")
    void save(User user);
}
