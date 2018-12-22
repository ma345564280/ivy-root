package com.ivy.root.Service.ServiceImp;

import com.ivy.root.Service.VisitService;
import com.ivy.root.dao.VisitMapper;
import com.ivy.root.domain.Visit;
import com.ivy.root.vo.DaySumStatisticVo;
import com.ivy.root.vo.StatisticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    VisitMapper visitMapper;

    @Override
    public StatisticVo queryVisitStatisticVo(Long designerId, Integer days) throws ParseException, NoSuchFieldException, IllegalAccessException {

        List<Visit> visitList = visitMapper.queryRecentVisitors(designerId, days);
        Long totalVisitors = visitMapper.countVisitors(designerId);
        List<DaySumStatisticVo> daySumStatisticVos = DaySumStatisticVo.getInstance(Visit.class,
                "visitTime",
                days,
                visitList,
                "yyyy-MM-dd",
                Calendar.DATE);
        return new StatisticVo(totalVisitors, daySumStatisticVos);
    }
}
