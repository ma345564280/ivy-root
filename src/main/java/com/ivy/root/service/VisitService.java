package com.ivy.root.service;

import com.ivy.root.vo.StatisticVo;

import java.text.ParseException;

public interface VisitService {
    StatisticVo queryVisitStatisticVo(Long designerId, Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException;
}
