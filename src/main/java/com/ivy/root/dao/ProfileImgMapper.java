package com.ivy.root.dao;

import com.ivy.root.domain.ProfileImg;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProfileImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProfileImg record);

    int insertSelective(ProfileImg record);

    ProfileImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProfileImg record);

    int updateByPrimaryKey(ProfileImg record);

    int batchInsertProfileImgs(List<ProfileImg> profileImgs);

    List<ProfileImg> queryProfileImgsForShare(Map<String, Object> queryProfileImgsParam);
}