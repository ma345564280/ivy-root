package com.ivy.root.dao;

import com.ivy.root.domain.Profile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Profile record);

    int insertSelective(Profile record);

    Profile queryProfileByUserId(@Param("userId") Long userId, @Param("profileStatus") int profileStatus);

    int updateStatusByUserId(@Param("userId") Long userId, @Param("profileStatus") int profileStatus);
}