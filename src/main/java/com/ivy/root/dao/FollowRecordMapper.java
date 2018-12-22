package com.ivy.root.dao;

import com.ivy.root.domain.FollowRecord;

public interface FollowRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowRecord record);

    int insertSelective(FollowRecord record);

    FollowRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FollowRecord record);

    int updateByPrimaryKey(FollowRecord record);
}