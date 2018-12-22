package com.ivy.root.dao;

import com.ivy.root.domain.Designer;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Designer record);

    int insertSelective(Designer record);

    Designer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Designer record);

    int updateByPrimaryKey(Designer record);
}