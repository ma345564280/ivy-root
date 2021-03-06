package com.ivy.root.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* @Description:    日期相关工具方法
* @Author:         matao
* @CreateDate:     2019/3/11 14:13

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:13
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public class DateUtils {
    public static Long oneDayMilli = 24 * 60 * 60 * 1000L;

    public static Date getYearMonthDayDate(Date date) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String dateStr = year + "-" + month + "-" + day;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = sdf.parse(dateStr);
        return today;
    }

    public static Date getNowYearMonthDayDate() throws ParseException {
        return getYearMonthDayDate(new Date());
    }

    public static Date getDateDiffByDay(Date date, Integer diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, diff);
        return calendar.getTime();
    }

    public static Date getDateDiff(Date date, Integer diff, Integer dateUnit) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dateUnit, diff);
        return calendar.getTime();
    }

    public static String formatDate(String pattern, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parse2Date(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);

    }

}
