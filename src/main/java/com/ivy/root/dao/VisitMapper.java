package com.ivy.root.dao;

import com.ivy.root.domain.Visit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Visit record);

    int insertSelective(Visit record);

    Visit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);

    List<Visit> queryRecentVisitors(@Param("designerId") Long designerId,@Param("days") Integer days);

    Long countVisitors(@Param("designerId") Long designerId);
}