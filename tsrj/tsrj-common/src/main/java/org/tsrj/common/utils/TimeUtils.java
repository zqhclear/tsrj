package org.tsrj.common.utils;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author hqm
 * @Description: 时间工具类
 * @date Nov 5, 2014 3:37:07 PM
 */
public class TimeUtils {


    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static final String FORMAT_YMDA = "yyyy-MM-dd";


    public static String format(Date date) {
        if(date==null){
            return "";
        }

        long delta = new Date().getTime() - date.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return seconds <= 0 ? "刚刚" : seconds + ONE_SECOND_AGO;
        }
        if (delta < 60L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 30L * ONE_DAY) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        if (delta < 12L * 30L * ONE_DAY) {
            long months = toMonths(delta);
            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
        } else {
            long years = toYears(delta);
            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toDays(date) / 365L;
    }


    /**
     * 按照一定格式将时间转换成字符串格式
     *
     * @param pattern 字符串格式默认yyyy/MM/dd
     * @param date    时间
     * @return
     */
    public static String toString(String pattern, Date date) {
        return new SimpleDateFormat(pattern == null ? "yyyy/MM/dd" : pattern).format(date == null ? new Date() : date);
    }

    /**
     * 时间字符串转换为date类型
     *
     * @param date    字符串时间
     * @param pattern 字符串格式
     * @return
     */
    public static Date getDateByStr(String date, String pattern) {
        if (StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(pattern)) {
            try {
                return new SimpleDateFormat(pattern).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 时间转换进秒转换为（hh:mm:ss）格式
     *
     * @param seconds 时间（单位秒）
     * @return
     */
    public static String secToTime(long seconds) {
        String timeStr = ConstStrings.EMPTY;
        long hour = 0l;
        long minute = 0l;
        long second = 0l;
        if (seconds <= 0) {
            return "00:00:00";
        } else {
            minute = seconds / 60;
            if (minute < 60) {
                second = seconds % 60;
                timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                minute = minute % 60;
                second = seconds - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String secToTime(int seconds) {
        return secToTime((long) seconds);
    }

    public static String unitFormat(int i) {
        return unitFormat((long) i);
    }

    public static String unitFormat(long i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + i;
        } else {
            retStr = "" + i;
        }
        return retStr;
    }

    /**
     * 转换（hh:mm:ss）的时间为秒数
     *
     * @param timeStr
     */
    public static int timeStrToSec(String timeStr) {
        if (StringUtils.isEmpty(timeStr)) {
            return 0;
        }
        Integer sec = 0;
        int timeStep = 1;
        String[] times = timeStr.split(":");
        int len = times.length;
        for (int i = 0; i < len; i++) {
            sec += (Integer.valueOf(times[len - i - 1]) * timeStep);
            timeStep = (int) Math.pow(60, (i + 1) / 1);
            //timeStep = (i + 1) * 60;
        }
        return sec;
    }
    /**
     *
     */
    public static Date getDateHourBegin(Date date){
        DateTime dateTime = new DateTime(date);
        return dateTime.withTime(dateTime.getHourOfDay(),00,00,000).toDate();
    }
    public static Date getDateHourEnd(Date date){
        DateTime dateTime = new DateTime(date);
        return dateTime.withTime(dateTime.getHourOfDay(),59,59,999).toDate();
    }
    /**
     * @param date
     * @return
     */
    public static Date getDateEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.withTime(23, 59, 59, 999).toDate();
    }

    public static Date getDateBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.withTime(00, 00, 00, 000).toDate();
    }

    /**
     * 获取指定日期前后天数的最迟时间
     *
     * @param date
     * @param delta 前后日期差
     * @return
     */
    public static Date ceiling(Date date, int delta) {
        if (date == null) {
            return null;
        }
        return new DateTime(getDateEnd(date)).plusDays(delta).toDate();
    }

    public static Date ceiling(Date date) {
        if (date == null) {
            return null;
        }
        return getDateEnd(date);
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal;
    }

    /**
     * 获取距离今天前后几天的最迟时间
     *
     * @param delta
     * @return
     */
    public static Date ceiling(int delta) {
        return ceiling(new Date(), delta);
    }

    /**
     * 获取指定日期前后天数的最早时间
     *
     * @param date
     * @param delta 前后天数差
     * @return
     */
    public static Date floor(Date date, int delta) {
        return new DateTime(getStartDateOfDay(date)).plusDays(delta).toDate();
    }

    /**
     * 获取最早时间
     *
     * @param
     * @return
     */
    public static Date getStartDateOfDay(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.withTime(0, 0, 0, 0).toDate();
    }

    /**
     * 获取与当天前后几天的最早时间
     *
     * @param delta
     * @return
     */
    public static Date floor(int delta) {
        return floor(new Date(), delta);
    }

    /**
     * 把时间清零，获得当前日期的清零时间
     *
     * @param date
     * @return
     */
    public static Date floor(Date date) {
        return getStartDateOfDay(date);
    }

    /**
     * 获取与指定日期前后几天的最早时间
     *
     * @param delta
     * @return
     */
    public static Date floorer(Date date, int delta) {
        return floor(date, delta);
    }


    /**
     * 获取是星期几,用0,1,3，4，5，6，7表示
     */
    public static int getWeekOfDate(Date date) {
        return (new DateTime(date).getDayOfWeek());
    }

    /**
     * 比较两个日期是否为在同一月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMoth(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return Boolean.FALSE;
        }
        DateTime d1 = new DateTime(date1);
        DateTime d2 = new DateTime(date2);
        if (d1.monthOfYear().get() == d2.monthOfYear().get()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 比较两个日期是否为在同一周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeek(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return Boolean.FALSE;
        }
        DateTime d1 = new DateTime(date1);
        DateTime d2 = new DateTime(date2);
        if (d1.weekOfWeekyear().get() == d2.weekOfWeekyear().get()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 判断两日期是否为同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return Boolean.FALSE;
        }
        DateTime d1 = new DateTime(date1);
        DateTime d2 = new DateTime(date2);
        if (d1.dayOfMonth().get() == d2.dayOfMonth().get()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 获取当前时间前后几天
     *
     * @param delta 前后天数，支持正负数
     * @return
     */
    public static Date appointed(int delta) {
        Calendar cal = getCalendar(new Date());
        if (delta != 0) {
            cal.add(Calendar.DATE, delta);
        }
        return cal.getTime();
    }

    public static Date appointed(Date date, int delta) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, delta);
        return cal.getTime();
    }

    /**
     * 获取
     *
     * @param statisDate
     * @return
     */
    public static Date getStatisDate(Date statisDate) {
        return new DateTime(statisDate == null ? new Date() : statisDate).plusDays(-1).withTime(0, 0, 0, 0).toDate();
    }

    /**
     * 把时间date是时分秒归零
     *
     * @param date
     * @return
     */
    public static Date toDayTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        return new DateTime(date).withTime(0, 0, 0, 0).toDate();
    }

    /**
     * 判断指定时间是否是周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date) {
        int index = new DateTime(date).getDayOfWeek();
        if (index == 6 || index == 7) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 判断指定时间是否是周末
     *
     * @param
     * @return
     */
    public static String getYearMonthDay(DateTime dt) {
        String m = "";
        String d = "";

        int year = dt.getYear();
        int month = dt.getMonthOfYear();
        int day = dt.getDayOfMonth();
        if (month < 10) {
            m = "0" + month;

        } else {
            m = String.valueOf(month);
        }
        if (day < 10) {
            d = "0" + day;
        } else {
            d = String.valueOf(day);
        }
        return year + m + d;

    }

    /**
     * @param date
     * @param pattern
     * @param locale
     * @return Date
     * @Description: 根据方言和模式解析日期字符串
     * @author yaojf
     * @date 2015年5月20日 下午4:16:19
     */
    public static Date getDateByStrAndLocale(String date, String pattern,
                                             Locale locale) {
        if (StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(pattern)
                && locale != null) {
            try {
                return new SimpleDateFormat(pattern, locale).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @param date
     * @param pattern
     * @param locale
     * @return String
     * @Description: 根据方言和模式解析日期
     * @author yaojf
     * @date 2015年5月21日 上午11:23:29
     */
    public static String getStrByDateAndLocale(Date date, String pattern,
                                               Locale locale) {
        if (date != null && StringUtils.isNotEmpty(pattern)
                && locale != null) {
            DateFormat dateFormat = new SimpleDateFormat(pattern, locale);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return dateFormat.format(date);
        }
        return null;
    }

    public static boolean hourCompareForLess(String a, String b) {
        if (HHmmToMinute(a) < HHmmToMinute(b)) {
            return true;
        }
        return false;
    }

    /**
     * 将时间格式为hh:mm的字符串转换成分钟数
     *
     * @param time
     * @return
     */
    public static int HHmmToMinute(String time) {
        if (StringUtils.isNotEmpty(time)) {
            String[] strs = time.split(":");
            if (strs.length == 2) {
                return Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        // DateTime dt = new DateTime();
        // System.out.println("" + dt.getMonthOfYear());
        // System.out.println(getDateByStr("2015-04-20","yy-mm-dd"));
        // Date a=new Date();
        // System.out.println(a);
        // System.out.println((getDateByStr(null, "yyyyMMdd")));
//		System.out.println(HHmmToMinute("10:02"));
        System.out.println(Math.pow(60, 2 / 1));
        ;

        System.out.println(timeStrToSec("1:02:44"));
    }


    /**
     * 如果date为null返回“”
     *
     * @param pattern
     * @param date
     * @return
     */
    public static String toTimeString(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern == null ? "yyyy-MM-dd HH:mm:ss" : pattern);
        return date == null ? "" : simpleDateFormat.format(date);
    }

    public static boolean check(Date date1, Date date2) {
        boolean result = false;

        if (date1.getTime() > date2.getTime()) {
            result = true;
        } else if (date1.getTime() < date2.getTime()) {
            result = false;

        }
        return result;

    }

    public static String robotCeiling(int delta) {
        Date date = ceiling(new Date(), delta);
        return new SimpleDateFormat(FORMAT_YMDA).format(date);

    }


    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /**
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     *
     * @param date : 时间点
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    public static Date currentTime() {
        return new Date();
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int daysBetween(Date early, Date late) {

        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        return ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;
    }

    /**
     * 两个时间之间相差距离多少天
     * @param str1 时间参数 1：
     * @param str2 时间参数 2：
     * @return 相差天数
     */
    public static long getDistanceDays(String str1, String str2) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days=0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获取当天最晚的时间
     * @return
     * @throws ParseException
     */
    public static Date getDate() throws ParseException{
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String now = formatter.format(new Date());
        String hour = now.split(" ")[1].toString().split(":")[0];

        new Date().getTime();

        if (Integer.parseInt(hour) < 12) {
            Calendar todayEnd = Calendar.getInstance();
            todayEnd.set(Calendar.HOUR_OF_DAY, 23);
            todayEnd.set(Calendar.MINUTE, 59);
            todayEnd.set(Calendar.SECOND, 59);
            result = formatter.format(todayEnd.getTime());
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            result = formatter.format(calendar.getTime());
        }

        Date date = formatter.parse(result);
        return date;
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTimes(String str1, String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }
}
