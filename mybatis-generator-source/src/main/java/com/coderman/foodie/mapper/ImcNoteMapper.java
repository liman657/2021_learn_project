package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcNote;
import java.util.List;

public interface ImcNoteMapper {
    int deleteByPrimaryKey(Integer noteId);

    int insert(ImcNote record);

    ImcNote selectByPrimaryKey(Integer noteId);

    List<ImcNote> selectAll();

    int updateByPrimaryKey(ImcNote record);
}