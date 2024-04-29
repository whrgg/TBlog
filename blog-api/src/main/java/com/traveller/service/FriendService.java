package com.traveller.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.traveller.entity.Friend;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendService extends IService<Friend> {
}
