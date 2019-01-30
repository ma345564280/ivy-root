package com.ivy.root.service;

import com.github.pagehelper.PageInfo;
import com.ivy.root.common.request.AppointmentRequest;
import com.ivy.root.domain.Appointment;
import com.ivy.root.vo.StatisticVo;

import java.text.ParseException;

public interface OrderService {

    StatisticVo queryDesignerOrdersOverView(Long designerId, Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException;

    int saveAppointment(Appointment appointment);

    PageInfo queryAppointment(AppointmentRequest request);
}
