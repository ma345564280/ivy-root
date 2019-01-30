package com.ivy.root.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ivy.root.common.exception.BusinessException;
import com.ivy.root.common.request.AppointmentRequest;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import com.ivy.root.domain.Appointment;
import com.ivy.root.service.OrderService;
import com.ivy.root.common.response.ResponseVo;
import com.ivy.root.vo.StatisticVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/order")
@Api(value = "订单中心", description = "订单中心")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/queryDesignerOrdersOverView", method = RequestMethod.GET)
    public ResponseVo<StatisticVo> queryDesignerOrdersOverView(@RequestParam Long designerId, @RequestParam Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException {
        return ResponseVo.buildSuccessInstance(orderService.queryDesignerOrdersOverView(designerId, days));
    }


    @RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
    public ResponseVo saveAppointment(@RequestBody Appointment appointment) {
        logger.info("saveAppointment : " + JSON.toJSONString(appointment));
        int count = orderService.saveAppointment(appointment);
        return ResponseVo.buildSuccessInstance(count);
    }

    @RequestMapping(value = "/queryAppointment", method = RequestMethod.POST)
    public ResponseVo<PageInfo> queryAppointment(@RequestBody AppointmentRequest request) {
        if(request == null) {
            throw new BusinessException(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        }

        logger.info("queryAppointment : " + JSON.toJSONString(request));
        request.setDelFlag(0);
        PageInfo pageInfo = orderService.queryAppointment(request);
        return ResponseVo.buildSuccessInstance(pageInfo);
    }
}
