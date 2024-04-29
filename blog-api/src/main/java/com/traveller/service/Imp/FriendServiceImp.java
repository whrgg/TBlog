package com.traveller.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.entity.Friend;
import com.traveller.mapper.FriendMapper;
import com.traveller.service.FriendService;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImp extends ServiceImpl<FriendMapper, Friend> implements FriendService {
}
