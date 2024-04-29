package com.traveller.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.traveller.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentVo extends Comment{
    List<Comment> children;
}
