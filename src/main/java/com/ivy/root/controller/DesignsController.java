package com.ivy.root.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ivy.root.Service.DesignService;
import com.ivy.root.common.request.DesignsParamRequest;
import com.ivy.root.common.request.SaveDesignRequest;
import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.domain.Design;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600)
@RestController
@Api(value = "设计师作品中心", description = "设计师作品中心")
@RequestMapping(value="/designs")
public class DesignsController {

    private static final Logger logger = LoggerFactory.getLogger(DesignsController.class);


    @Autowired
    DesignService designService;

    @ApiOperation(value = "查询作品列表",notes = "分页-条件")
    @RequestMapping(value = "/queryDesigns", method = RequestMethod.POST)
    public ResponseVo<PageInfo> queryDesigns(@RequestBody DesignsParamRequest param) {
        PageInfo pageInfo = designService.queryDesigns(param);
        logger.debug("Designs : " + JSON.toJSONString(pageInfo));
        return new ResponseVo<PageInfo>().buildSuccessInstance(pageInfo);
    }

    @ApiOperation(value = "查询作品列表",notes = "分页-条件")
    @RequestMapping(value = "/submitDesign", method = RequestMethod.POST)
    public ResponseVo<String> submitDesign(@RequestBody SaveDesignRequest param) {
        String isSuccess = designService.saveDesign(param);
        return ResponseVo.buildSuccessInstance(isSuccess);
    }

}
