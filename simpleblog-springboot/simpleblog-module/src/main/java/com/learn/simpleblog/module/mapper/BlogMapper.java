package com.learn.simpleblog.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.simpleblog.module.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper extends BaseMapper<Blog>{


    List<Blog> pageCenterBlog(IPage<Blog> iPage, @Param("paramMap") Map<String, Object> paramMap);

    Blog selectByPK(@Param("id") Integer id);

    int countByForwardBlog(@Param("userId") Long userId, @Param("blogId") Integer blogId);


    int countByUserId(@Param("userId") Integer userId);

    List<Blog> selectBlogByUIds(@Param("userIds") String userIds);

    List<Blog> selectPraiseBlogByUId(IPage<Blog> iPage, @Param("paramMap") Map<String, Object> paramMap);

    List<Blog> selectCollectBlogByUId(IPage<Blog> iPage, @Param("paramMap") Map<String, Object> paramMap);


    List<Blog> pageBlogAdmin(IPage<Blog> iPage, @Param("paramMap") Map<String, Object> paramMap);


    void deletes(@Param("ids") String ids);

    void actives(@Param("ids") String ids);


    List<Blog> selectAll();

    List<Blog> selectByIds(@Param("ids") String ids);
}