package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HelpTopic;
import java.util.List;

public interface HelpTopicMapper {
    int deleteByPrimaryKey(Integer helpTopicId);

    int insert(HelpTopic record);

    HelpTopic selectByPrimaryKey(Integer helpTopicId);

    List<HelpTopic> selectAll();

    int updateByPrimaryKey(HelpTopic record);
}