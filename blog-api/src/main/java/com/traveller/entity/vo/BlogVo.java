package com.traveller.entity.vo;

import com.traveller.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogVo extends Blog{

    List<Long> tags;
    String categoryName;

}
