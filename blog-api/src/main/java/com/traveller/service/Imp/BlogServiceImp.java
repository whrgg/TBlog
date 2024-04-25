package com.traveller.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveller.entity.Blog;
import com.traveller.entity.BlogTag;
import com.traveller.entity.vo.BlogVo;
import com.traveller.mapper.BlogMapper;
import com.traveller.mapper.BlogTagMapper;
import com.traveller.mapper.CategoryMapper;
import com.traveller.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BlogServiceImp extends ServiceImpl<BlogMapper,Blog> implements BlogService {
    //TODO:真的要这么多的查询方法嘛？有工厂方法简化嘛？
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogTagMapper tagMapper;
    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 用户端的无密码文章的查询，用随机文章的内容
     * @param page
     * @param pageSize
     * @return {@link IPage}<{@link Blog}>
     */
    @Override
    public IPage<Blog> pageBlogDesc(Integer page, Integer pageSize) {

        IPage IPage=new Page(page,pageSize);
        LambdaQueryWrapper<Blog> queryWrapper=new LambdaQueryWrapper<>();
        //注意密码不为空的就不用来凑热闹了
        //也不会用来推荐
        queryWrapper.isNull(Blog::getPassword);
        //不愿意公开的也算了
        queryWrapper.eq(Blog::getIsPublished,1);

        blogMapper.selectPage(IPage, queryWrapper);

        return  IPage;
    }

    /**
     * 用作管理端的管理查询
     * @param page
     * @param pageSize
     * @return {@link IPage}<{@link Blog}>
     */
    @Override
    public IPage<Blog> pageBlog(Integer page, Integer pageSize) {
        IPage IPage=new Page(page,pageSize);
        LambdaQueryWrapper<Blog> queryWrapper=new LambdaQueryWrapper<>();
        //注意密码为空的就不用来凑热闹了
        //也不会用来推荐
        queryWrapper.isNull(Blog::getPassword);
        //不愿意公开的也算了
        queryWrapper.eq(Blog::getIsPublished,0);
        //默认用时间的降序排序
        queryWrapper.orderByDesc(Blog::getUpdateTime);
        blogMapper.selectPage(IPage, queryWrapper);

        return  IPage;
    }

    /**
     * 使用aop自动注入创建时间创建者
     * @param blogVo
     */
    //TODO：要去实现自动注入的功能
    @Override
    public void saveBlog(BlogVo blogVo) {
        //首先存入blog,会自动返回id
        blogMapper.saveBlog(blogVo);
        //存入blog
        //前端传入的时候是包括了分类和标签的选择的

    }

    //多任务，开启事务管理注解
    @Transactional
    @Override
    public void removeBlogAndTagById(Long id) {
        blogMapper.deleteById(id);
        tagMapper.deleteByBlogId(id);
    }

    /**
     * @param blogVo
     * tags的新增和删除都是删除联系表而非本表
     */
    @Transactional
    @Override
    public void updateAll(BlogVo blogVo) {
        //更新博文本体
        blogMapper.updateBlog(blogVo);
        //根据博客的id删除blog-tag表中的联系
        tagMapper.deleteByBlogId(blogVo.getId());
        //然后增加新的
        List<Long> tags = blogVo.getTags();
        if(Objects.isNull(tags)||tags.size()==0)
            return;
        //增加新的
        tags.stream().forEach(tagId->{
            tagMapper.insert(new BlogTag(blogVo.getId(),tagId));
        });

    }
}
