package com.ivy.root.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivy.root.common.exception.BusinessException;
import com.ivy.root.common.request.AppointmentRequest;
import com.ivy.root.common.rootenum.AppointmentStatusEnum;
import com.ivy.root.common.rootenum.ProjectTypeEnum;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import com.ivy.root.dao.AppointmentMapper;
import com.ivy.root.domain.Appointment;
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

    @Autowired
    AppointmentMapper appointmentMapper;

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

    @Override
    public int saveAppointment(Appointment appointment) {
        appointment.setStatus(Byte.valueOf(String.valueOf(AppointmentStatusEnum.DESIGN_COMPANY.getCode())));
        appointment.setCreateTime(new Date());
        int count = appointmentMapper.insertSelective(appointment);

        return count;
    }

    @Override
    public PageInfo queryAppointment(AppointmentRequest request) {
        if (request == null) {
            throw new BusinessException(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        }

        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<Appointment> appointments = appointmentMapper.queryAppointmentByCondition(request);

        if(appointments != null && appointments.size() > 0) {
            appointments.stream().forEach(a -> {
                a.setProjectTypeDesc(ProjectTypeEnum.getDescription(Integer.valueOf(a.getProjectType())));
            });
        }

        PageInfo<Appointment> pageInfo = new PageInfo<>(appointments);
        return pageInfo;
    }
}
