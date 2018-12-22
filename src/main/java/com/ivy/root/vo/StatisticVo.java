package com.ivy.root.vo;

import java.util.List;

public class StatisticVo {
    private Long totalRecords;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    private List<DaySumStatisticVo> daySumStatisticVo;

    public List<DaySumStatisticVo> getDaySumStatisticVo() {
        return daySumStatisticVo;
    }

    public void setDaySumStatisticVo(List<DaySumStatisticVo> daySumStatisticVo) {
        this.daySumStatisticVo = daySumStatisticVo;
    }

    public StatisticVo(Long totalRecords, List<DaySumStatisticVo> daySumStatisticVo) {
        this.totalRecords = totalRecords;
        this.daySumStatisticVo = daySumStatisticVo;
    }
}
