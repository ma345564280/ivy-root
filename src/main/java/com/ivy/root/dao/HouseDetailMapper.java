package com.ivy.root.dao;

import com.ivy.root.domain.HouseDetail;

public interface HouseDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HouseDetail record);

    int insertSelective(HouseDetail record);

    HouseDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HouseDetail record);

    int updateByPrimaryKey(HouseDetail record);
}