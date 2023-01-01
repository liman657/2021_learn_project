package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcChapter;
import java.util.List;

public interface ImcChapterMapper {
    int deleteByPrimaryKey(Integer chapterId);

    int insert(ImcChapter record);

    ImcChapter selectByPrimaryKey(Integer chapterId);

    List<ImcChapter> selectAll();

    int updateByPrimaryKey(ImcChapter record);
}