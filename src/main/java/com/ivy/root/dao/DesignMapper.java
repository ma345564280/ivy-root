package com.ivy.root.dao;

import com.ivy.root.common.request.DesignsParamRequest;
import com.ivy.root.domain.Design;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignMapper {

    List<Design> queryDesignsByCondition(DesignsParamRequest param);

    Integer saveDesign(Design design);
}