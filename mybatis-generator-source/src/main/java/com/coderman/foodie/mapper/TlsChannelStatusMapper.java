package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TlsChannelStatus;
import java.util.List;

public interface TlsChannelStatusMapper {
    int insert(TlsChannelStatus record);

    List<TlsChannelStatus> selectAll();
}