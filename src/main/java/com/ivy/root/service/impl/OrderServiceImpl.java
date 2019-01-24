package com.ivy.root.service.impl;

import com.ivy.root.service.OrderService;
import com.ivy.root.dao.OrderMapper;
import com.ivy.root.domain.Order;
import com.ivy.root.vo.DaySumStatisticVo;
import com.ivy.root.vo.StatisticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public StatisticVo queryDesignerOrdersOverView(Long designerId , Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException {
        if(designerId == null) {
            return null;
        }

        Long totalOrders = orderMapper.counterAllOrders(designerId);
        List<Order> ordersInDays = orderMapper.statisticOrdersByDay(designerId, days);

        List<DaySumStatisticVo> daySumStatisticVos = DaySumStatisticVo.getInstance(Order.class, "createTime", days, ordersInDays, "yyyy-MM-dd", Calendar.DATE);

        return new StatisticVo(totalOrders, daySumStatisticVos);
    }
}
