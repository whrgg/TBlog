package com.traveller.entity.vo;

import com.traveller.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogVo extends Blog{

    List<Long> tags;
    String categoryName;

    @Override
    public void setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        super.setUpdateTime(updateTime);
    }
}
