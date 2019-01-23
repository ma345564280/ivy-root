package com.ivy.root.controller;

import com.ivy.root.service.ApiService;
import com.ivy.root.common.exception.BusinessException;
import com.ivy.root.common.request.ShareInfoRequest;
import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import com.ivy.root.vo.ShareInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "OpenApi", description = "对外服务")
@RequestMapping(value="/openApi")
public class OpenApi {

    @Autowired
    ApiService apiService;

    @ApiOperation(value = "查询设计师分享信息",notes = "查询设计师分享信息")
    @RequestMapping(value = "/getShareInfo", method = RequestMethod.POST)
    public ResponseVo<ShareInfoVo> getShareInfo(@RequestBody ShareInfoRequest param) {
        if(param == null || param.getUserId() == null)
            throw new BusinessException(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);

        return ResponseVo.buildSuccessInstance(apiService.getShareInfo(param));
    }

    @ApiOperation(value = "保存分享页内容",notes = "保存分享页内容")
    @RequestMapping(value = "/saveShareInfo", method = RequestMethod.POST)
    public ResponseVo<String> saveShareInfo(@RequestBody ShareInfoRequest param) {
        if(param == null || param.getUserId() == null)
            throw new BusinessException(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        apiService.saveProfile(param);
        return ResponseVo.buildSuccessInstance(null);
    }
}
