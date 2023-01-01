package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.AdministrableRoleAuthorizations;
import java.util.List;

public interface AdministrableRoleAuthorizationsMapper {
    int insert(AdministrableRoleAuthorizations record);

    List<AdministrableRoleAuthorizations> selectAll();
}