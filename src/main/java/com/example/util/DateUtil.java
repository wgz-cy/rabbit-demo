package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    public static final String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_MIN = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_DAY = "yyyy-MM-dd";
    public static final String PATTERN_MONTH = "yyyy-MM";
    public static final String PATTERN_ONLYTIME = "HH:mm:ss";
    public static final String PATTERN_ONLMIN = "HH:mm";
    public static final String PATTERN_DAY_END = "yyyy-MM-dd 23:59:59";
    public static final String PATTERN_ONLYDAY_END = "MM-dd";

    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 指定日期年初
     * @param date
     * @return
     */
    public static Date getYearBegin(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 指定日期年末
     * @param date
     * @return
     */
    public static Date getYearEnd(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DAY_OF_MONTH, c.getMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getMonthBegin(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    public static Date getMonthEnd(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 0);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getWeekBegin(Date date){
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getWeekEnd(Date date){
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        c.add(Calendar.DATE, 6);
        return c.getTime();
    }

    public static Date getHourBegin(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    public static Date getHourEnd(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getDayBegin(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();

    }
    public static Date getDayBegin(String date){
        try {
            return getDayBegin(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getDayEnd(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getDayEnd(String date){
        try {
            return getDayEnd(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getHourBegin(String date,int hour){
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return c.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Date getHourEnd(String date,int hour){
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            c.set(Calendar.MILLISECOND, 999);
            return c.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取只有年月日的时间
     * @param in
     * @return
     */
    public static Date getYmd(Date in){
        Calendar c = Calendar.getInstance();
        c.setTime(in);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    /**
     * 获取一天中的开始时间
     * @param in	输入的时间
     * @return
     */
    public static Date dateDayBegin(Date in){
        Calendar c = Calendar.getInstance();
        c.setTime(in);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    /**
     * 获取一天中的结束时间
     * @param in	输入的时间
     * @return
     */
    public static Date dateDayEnd(Date in){
        Calendar c = Calendar.getInstance();
        c.setTime(in);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getTerm(Date in,int type,int term){
        Calendar c = Calendar.getInstance();
        c.setTime(in);
        c.add(type, term);
        return c.getTime();
    }
    /**
     * 时间往后推一段时间
     * @param in	摇改变的时间
     * @param type	时间类型（时，分，秒）
     * @param term	时间间隔
     * @return
     */
    public static Date add(Date in,int type,int term){
        Calendar c = Calendar.getInstance();
        c.setTime(in);
        c.add(type, term);
        return c.getTime();
    }
    /**
     * 时间往前推一段时间
     * @param in	摇改变的时间
     * @param type	时间类型（时，分，秒）
     * @param term	时间间隔
     * @return
     */
    public static Date sub(Date in,int type,int term){
        Calendar c = Calendar.getInstance();
        c.setTime(in);
        c.add(type, -term);
        return c.getTime();
    }

    public static String format(Date in){
        if(null==in)
            return null;
        return df.format(in);
    }

    public static String format(Date in,String pattern){
        if(null==in)
            return null;
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(in);
    }

    public static Date parse(String str,String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parse(String str,String sourcepattern, String descpattern){
        SimpleDateFormat df = new SimpleDateFormat(sourcepattern);
        try {
            Date d = df.parse(str);
            return format(d, descpattern);
        } catch (ParseException e) {
            return str;
        }
    }

	/*public static String between(Date min,Date max){
		Calendar c = Calendar.getInstance();
		c.setTime(min);
		int yMin = c.get(Calendar.YEAR);
		int mMin = c.get(Calendar.MONTH);
		int dMin = c.get(Calendar.DAY_OF_MONTH);
	}*/

    public static long betweenDay(Date min,Date max){
        return (max.getTime()-min.getTime())/(1000*3600*24);
    }
    public static long betweenMonth(Date min,Date max){
        Calendar c = Calendar.getInstance();
        c.setTime(min);
        int mMin = c.get(Calendar.MONTH);
        int dMin = c.get(Calendar.DAY_OF_MONTH);
        c.setTime(max);
        int mMax = c.get(Calendar.MONTH);
        int dMax = c.get(Calendar.DAY_OF_MONTH);
        if(dMin<dMax){
            return mMax-mMin;
        }else{
            return mMax-mMin-1;
        }
    }
    public static long betweenDayExcludeMonth(Date min,Date max){
        Calendar c = Calendar.getInstance();
        c.setTime(min);
        int mMin = c.get(Calendar.MONTH);
        int dMin = c.get(Calendar.DAY_OF_MONTH);
        c.setTime(max);
        int mMax = c.get(Calendar.MONTH);
        int dMax = c.get(Calendar.DAY_OF_MONTH);
        if(dMin<=dMax){
            return dMax-dMin;
        }else{
            return betweenDay(add(min, Calendar.MONTH, mMax-mMin-1), max);
        }
    }

    public static long betweenYear(Date min,Date max){
        Calendar c = Calendar.getInstance();
        c.setTime(min);
        int yMin = c.get(Calendar.YEAR);
        int mMin = c.get(Calendar.MONTH);
        c.setTime(max);
        int yMax = c.get(Calendar.YEAR);
        int mMax = c.get(Calendar.MONTH);
        if(mMin<mMax){
            return yMax-yMin;
        }else{
            return yMax-yMin-1;
        }
    }

    public static long betweenMonthExcludeYear(Date min,Date max){
        Calendar c = Calendar.getInstance();
        c.setTime(min);
        int yMin = c.get(Calendar.YEAR);
        int mMin = c.get(Calendar.MONTH);
        c.setTime(max);
        int yMax = c.get(Calendar.YEAR);
        int mMax = c.get(Calendar.MONTH);
        return (yMax-yMin)*12+(mMax-mMin);
    }


    public static String dateFormat(Date in){
        if(null==in)
            return null;
        return sdf.format(in);
    }

    /**
     * 获取某个月份的天数
     * @param in
     * @return
     */
    public static int getDaysOfMonth(Date in) {
        if (in == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(in);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期是周几
     * @param date
     * @return
     */
    public static String getWeekDay(Date date) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        if (date == null) {
            return "";
        }
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取此日期是几号
     * @param in
     * @return
     */
    public static int getCurrentDays(Date in) {
        if (in == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(in);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取此日期的年份
     * @param in
     * @return
     */
    public static int getYear(Date in) {
        if (in == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(in);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 根据时间获取月份
     * @param in
     * @return
     */
    public static int getMonth(Date in) {
        if (in == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(in);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * n<0:获取n天前日期
     * n>0:获取n天后日期
     * n=0:获取当前日期
     * @param n
     * @return
     */
    public static Date getBeforOrFutureDate(final int n) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.DATE, n);
        return calendar.getTime();
    }

    /**
     * n<0:获取n月前日期
     * n>0:获取n月后日期
     * n=0:获取当前日期
     * @param date 指定日期
     * @param n
     * @return
     */
    public static Date getBeforOrFutureDateOfMonth(Date date, final int n) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, n);
        return calendar.getTime();
    }

    /**
     * n<0:获取n年前日期
     * n>0:获取n年后日期
     * n=0:获取当前日期
     * @param date 指定日期
     * @param n
     * @return
     */
    public static Date getBeforOrFutureDateOfYear(Date date, final int n) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, n);
        return calendar.getTime();
    }

    /**
     * 计算两个日期相差的月份数
     *
     * @param minDate
     * @param maxDate
     * @return
     */
    public static int countMonths(Date minDate, Date maxDate) {
        if (minDate == null || maxDate == null) {
            return 0;
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(minDate);
        c2.setTime(maxDate);
        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int minDay = c1.get(Calendar.DAY_OF_MONTH);
        int maxDay = c2.get(Calendar.DAY_OF_MONTH);
        int month = year * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        if (maxDay < minDay) {
            if (month > 0) {
                month--;
            }
        }
        return month;
    }

    /**
     * 将指定日期按照指定格式转成Integer类型
     *
     * @param in
     * @param pattern
     * @return
     */
    public static Integer formatInt(Date in, String pattern) {
        if (null == in)
            return null;
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return Integer.valueOf(df.format(in));
    }

    /**
     * 根据指定日期获得所在周的某一天日期
     * @param date
     * @param interval 1 周一，2 周二，3 周三，4 周四，5 周五，6 周六，7 周日
     * @return
     */
    public static Date getLocalWeekTime(Date date, int interval) {
        if (interval < 1 || interval > 7) {
            logger.error("根据当前日期获得所在周的日期区间：", "interval不合法！");
            return null;
        } else {
            interval--;
        }
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTime(date);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY); // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK); // 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day + interval); // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        logger.info("返回日期：" + sdf.format(cal.getTime()));
        return cal.getTime();
    }


    /**
     * 根据指定日期获得上周的某一天日期
     * @param date
     * @param interval 1 周一，2 周二，3 周三，4 周四，5 周五，6 周六，7 周日
     * @return
     */
    public static Date getLastWeekTime(Date date, int interval) {
        if (interval < 1 || interval > 7) {
            logger.error("根据当前日期获得所在周的日期区间：", "interval不合法！");
            return null;
        } else {
            interval--;
        }
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTime(date);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY); // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK); // 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day - 7 + interval); // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        logger.info("返回日期：" + sdf.format(cal.getTime()));
        return cal.getTime();
    }

    /**
     * 获取两个时间相差多少天
     * （日期格式 YYYY-MM-DD）
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 相差天数
     */
    public static long getIntervalTime(String start, String end, ChronoUnit unit) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        Long num = startDate.until(endDate, unit);
        return num;
    }
}
