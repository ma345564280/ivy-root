package com.ivy.root.Service;


import com.github.pagehelper.PageInfo;
import com.ivy.root.common.request.DesignsParamRequest;
import com.ivy.root.common.request.SaveDesignRequest;
import com.ivy.root.domain.Design;

public interface DesignService {

    PageInfo<Design> queryDesigns(DesignsParamRequest param);

    String saveDesign(SaveDesignRequest param);
}
