package com.ivy.root.dao;

import com.ivy.root.domain.UserAuthority;

public interface UserAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    UserAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);
}