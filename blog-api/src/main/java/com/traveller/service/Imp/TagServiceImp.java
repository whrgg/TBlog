package com.traveller.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.entity.Tag;
import com.traveller.mapper.TagMapper;
import com.traveller.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImp extends ServiceImpl<TagMapper, Tag> implements TagService {
}
