package com.ivy.root.controller;


import com.ivy.root.service.VisitService;
import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.vo.StatisticVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/visit")
@Api(value = "访客中心", description = "访客中心")
public class VisitController {

    @Autowired
    VisitService visitService;

    @RequestMapping(value = "/queryVisitStatisticVo", method = RequestMethod.GET)
    public ResponseVo<StatisticVo> queryVisitStatisticVo(@RequestParam Long designerId, @RequestParam Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException {
        return ResponseVo.buildSuccessInstance(visitService.queryVisitStatisticVo(designerId, days));
    }
}
