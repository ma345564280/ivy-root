package com.ivy.root.dao;

import com.ivy.root.domain.DesignImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DesignImg record);

    int insertSelective(DesignImg record);

    DesignImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DesignImg record);

    int updateByPrimaryKey(DesignImg record);

    Integer saveDesignImgs(List<DesignImg> designImgs);
}