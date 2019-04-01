package com.ivy.root.vo;

import com.ivy.root.common.util.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
* @Description:    日期-数据统计通用返回类
* @Author:         matao
* @CreateDate:     2019/2/26 17:16

* @UpdateUser:     matao
* @UpdateDate:     2019/2/26 17:16
* @UpdateRemark:   修改内容

* @Version:        1.0
*/

@Getter
@Setter
@ApiModel(description = "日期-数据统计通用返回类")
public class DaySumStatisticVo {
    @ApiModelProperty(value = "日期数据")
    private Integer sum;
    @ApiModelProperty(value = "日期")
    private String date;

    private DaySumStatisticVo() {

    }

    public DaySumStatisticVo(Integer sum, String date) {
        this.sum = sum;
        this.date = date;
    }

    public  static <T> List<DaySumStatisticVo> getInstance(Class clazz, String dateDimension, Integer diffRange, List<T> source, String datePattern, Integer dateUnit) throws NoSuchFieldException, ParseException, IllegalAccessException{
        if(clazz == null) {
            return null;
        }

        Field field = clazz.getDeclaredField(dateDimension);
        field.setAccessible(true);
        Map<String, Integer> counterMap = new HashMap<>();
        List<DaySumStatisticVo> ret = new ArrayList<>();

        for(int i = diffRange - 1; i >= 0; i--) {
            counterMap.put(
                    DateUtils.formatDate(datePattern,
                            DateUtils.getDateDiff(
                                DateUtils.getNowYearMonthDayDate(), -i, dateUnit)),0);
        }

        if(source != null && source.size() > 0) {
            for(T var: source) {
                Date dateVar = (Date) field.get(var);
                String createDate = DateUtils.formatDate(datePattern, dateVar);

                if(counterMap.containsKey(createDate)) {
                    counterMap.put(createDate, counterMap.get(createDate) + 1);
                }
            }
        }

        for(Map.Entry entry : counterMap.entrySet()) {
            ret.add(new DaySumStatisticVo((Integer) entry.getValue(), (String) entry.getKey()));
        }

        ret = ret.stream().sorted(Comparator.comparing(DaySumStatisticVo::getDate)).collect(Collectors.toList());
        return ret;
    }
}
