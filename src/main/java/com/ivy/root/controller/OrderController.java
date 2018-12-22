package com.ivy.root.controller;


import com.ivy.root.Service.OrderService;
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
@RequestMapping("/order")
@Api(value = "订单中心", description = "订单中心")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/queryDesignerOrdersOverView", method = RequestMethod.GET)
    public ResponseVo<StatisticVo> queryDesignerOrdersOverView(@RequestParam Long designerId, @RequestParam Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException {
        return ResponseVo.buildSuccessInstance(orderService.queryDesignerOrdersOverView(designerId, days));
    }
}
