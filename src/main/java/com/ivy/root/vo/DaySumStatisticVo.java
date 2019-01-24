package com.ivy.root.vo;

import com.ivy.root.common.Util.DateUtils;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class DaySumStatisticVo {
    private Integer sum;
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
