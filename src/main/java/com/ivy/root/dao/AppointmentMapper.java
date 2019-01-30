package com.ivy.root.dao;

import com.ivy.root.common.request.AppointmentRequest;
import com.ivy.root.domain.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);

    List<Appointment> queryAppointmentByCondition(AppointmentRequest request);
}