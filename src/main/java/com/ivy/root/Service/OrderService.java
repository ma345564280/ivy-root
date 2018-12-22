package com.ivy.root.Service;

import com.ivy.root.vo.StatisticVo;

import java.text.ParseException;

public interface OrderService {

    StatisticVo queryDesignerOrdersOverView(Long designerId, Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException;
}
