package org.tsrj.common.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;

/**
 * 日期工具类
 * @author xiaohaizi
 * @date   2017年3月9日 下午2:37:42
 */
public class DateUtils {

	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyyMMdd
	 */
	public static final String YYYYMMDD = "yyyyMMdd";
	
	/**
	 * HHmmss
	 */
	public static final String HHmmss = "HHmmss";
	
	/**
	 * HH:mm
	 */
	public static final String HH_mm = "HH:mm";


	/**
	 * yyyy年MM月dd日
	 */
	public static final String YYYY_MM_DD_STR = "yyyy年MM月dd日";
	
	/**
	 * MM-DD
	 */
	public static final String MM_DD = "MM-dd";

	/**
	 * yyyy年MM月dd日 HH:mm
	 */
	public static final String YYYY年MM月DD日_HHmm = "yyyy年MM月dd日 HH:mm";

	/**
	 * dd
	 */
	public static final String dd = "dd";
	
	/**
	 * MM/DD
	 */
	public static final String MMDD = "MM/dd";
	
	/**
	 * yyyy年MM月
	 */
	public static final String yyyy_MM = "yyyy年MM月";

	/**
	 * yy-mm-dd
	 */
	public static final String yy_MM_dd = "yy-MM-dd";
	
	/**
	 * 获得当前格式化的时间
	 * YYYY_MM_DD_HH_MM_SS
	 */
	public static String getDefaultStringDate(){
		return getStringDate(new Date(), YYYY_MM_DD_HH_MM_SS);
	}
	
	
	/**
	 * 今天的00:00:00
	 * @return Date     
	 */
	public static Date getTodayAsStartOfDay(){
		return withTimeAtStartOfDay(new Date());
	}
	
	/**
	 * 今天的23:59:59
	 * @return Date     
	 */
	public static Date getTodayAsEndOfDay(){
		return withTimeAtEndOfDay(new Date());
	}
	
	/**
	 * 当前日期的00:00:00
	 * @param date
	 * @return      
	 * Date
	 */
	public static Date withTimeAtStartOfDay(Date date){
		DateTime dt = new DateTime(date);
		return dt.withTimeAtStartOfDay().toDate();
	}
	
	/**
	 * 当前日期的23:59:59
	 * @param date
	 */
	public static Date withTimeAtEndOfDay(Date date){
		DateTime dt = new DateTime(date);
		return dt.withTimeAtStartOfDay().plusDays(1).minusSeconds(1).toDate();
	}
	
	/**
	 * 获取当前月的月首
	 */
	public static Date withTimeAtStartOfMonth(Date date){
		DateTime dt = new DateTime(date);
		return dt.withDayOfMonth(1).withTimeAtStartOfDay().toDate();
	}
	
	/**
	 * 获取当前月的月尾
	 */
	public static Date withTimeAtEndOfMonth(Date date){
		DateTime dt = new DateTime(date);
		return dt.withDayOfMonth(1).withTimeAtStartOfDay().plusMonths(1).plusSeconds(-1).toDate();
	}
	
	/**
	 * 日期之间的天数
	 * @param startDate
	 * @param endDate
	 */
	public static int daysBetween(Date startDate, Date endDate){
		return Days.daysBetween(new DateTime(startDate).withTimeAtStartOfDay(), new DateTime(endDate).withTimeAtStartOfDay()).getDays();
	}

	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	/**
	 * 日期之间的秒数
	 * @param startDate
	 * @param endDate
	 */
	public static int secondsBetween(Date startDate, Date endDate){
		return Seconds.secondsBetween(new DateTime(startDate), new DateTime(endDate)).getSeconds();
	}
	
	/**
	 * 日期之间的分数
	 * @param startDate
	 * @param endDate
	 */
	public static int minutesBetween(Date startDate, Date endDate){
		return Minutes.minutesBetween(new DateTime(startDate), new DateTime(endDate)).getMinutes();
	}
	
	/**
	 * 日期之间的小时数
	 * @param startDate
	 * @param endDate
	 */
	public static int hoursBetween(Date startDate, Date endDate){
		return Hours.hoursBetween(new DateTime(startDate), new DateTime(endDate)).getHours();
	}
	
	/**
	 * 是否在当前日期之后
	 * @param date
	 */
	public static boolean isAfterNow(){
		return isAfterNow(new Date());
	}
	
	/**
	 * 是否在日期之前
	 * @param date
	 */
	public static boolean isBeforeNow(){
		return isAfterNow(new Date());
	}
	
	
	/**
	 * 是否在当前日期之后
	 * @param date
	 */
	public static boolean isAfterNow(Date date){
		DateTime dt = new DateTime(date);
		return dt.isAfterNow();
	}
	
	/**
	 * 是否在日期之前
	 * @param date
	 */
	public static boolean isBeforeNow(Date date){
		DateTime dt = new DateTime(date);
		return dt.isBeforeNow();
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @param pattern
	 */
	public static String getStringDate(Date date, String pattern){
		DateTime dt = new DateTime(date);
		return dt.toString(pattern);
	}
	
	/**
	 * 字符串转日期
	 * YYYY_MM_DD_HH_MM_SS
	 * @param dateStr
	 */
	public static Date getDateWithDateStr(String dateStr){
		return getDateWithDateStr(dateStr, YYYY_MM_DD_HH_MM_SS);
	}
	
	/**
	 * 字符串转日期
	 * @param dateStr
	 * @param pattern
	 */
	public static Date getDateWithDateStr(String dateStr, String pattern){
		 DateTime dt = DateTimeFormat.forPattern(pattern).parseDateTime(dateStr);
		 return dt.toDate();
	}
	
	/**
	 * 今日还剩余的秒数
	 * @return
	 */
	public static int getTodayEndSeconds(){
		return secondsBetween(getCurrentDate(), getTodayAsEndOfDay());
	}
	
	/**
	 * 当前时间
	 * @return      
	 * Date
	 */
	public static Date getCurrentDate(){
		DateTime dt = new DateTime();
		return dt.toDate();
	}
	
	
	/**
     * 把日期的时间变成(yyyy-MM-dd 23:59:59:999)
     */
    public static Date getEndTime(Date date)
    {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
    
    /**
     * 把日期的时间变成(yyyy-MM-dd HH:59:59:999)
     */
    public static Date getEndTimeAddHour(Date date)
    {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 计算两个日期间隔的秒数
     *
     * @param firstDate 小者
     * @param lastDate  大者
     * @return int 默认-1
     */
    public static int getTimeIntervalSencond(Date firstDate, Date lastDate)
    {
        if(null == firstDate || null == lastDate)
        {
            return -1;
        }
        long intervalMilli = lastDate.getTime() - firstDate.getTime();
        return (int) (intervalMilli / 1000);
    }
    
    /**
     * return current calendar instance
     *
     * @return Calendar
     */
    public static Calendar getCurrentCalendar()
    {
        return Calendar.getInstance();
    }

    /**
     * return current time
     *
     * @return current time
     */
    public static Timestamp getCurrentDateTime()
    {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 增加天数
     */
    public static Date addDate(Date date, int day)
    {
        if(null == date)
        {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        return calendar.getTime();
    }
    
    /**
     * 增加月份
     */
    public static Date addMonth(Date date, int month){
    	if(null == date)
        {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
        return calendar.getTime();
    }
    
    /**
     * 开奖时间
     */
    public static Date getDrawTime(Date date)
    {
        DateTime dateTime = new DateTime(date);
        int hour = dateTime.getHourOfDay();
        int minute = dateTime.getMinuteOfHour();
        if(hour >= 10 && hour <= 21)
        {//上午10:00到晚上22:00
            int m = minute / 10 * 10 + 13 - minute;
            if(m > 60)
            {
                dateTime = dateTime.plusHours(1);
                return DateUtils.getDateWithDateStr(DateUtils.getStringDate(dateTime.toDate(), "yyyy-MM-dd 00:03:30"),
                        "yyyy-MM-dd HH:mm:ss");
            }
            else
            {
                dateTime = dateTime.plusMinutes(m);
                return DateUtils.getDateWithDateStr(DateUtils.getStringDate(dateTime.toDate(), "yyyy-MM-dd HH:mm:30"),
                        "yyyy-MM-dd HH:mm:ss");
            }
        }
        else if(hour >= 22 || hour <= 1)
        {
            int m = minute / 5 * 5 + 8 - minute;
            if(m > 60)
            {
                dateTime = dateTime.plusHours(1);
                return DateUtils.getDateWithDateStr(DateUtils.getStringDate(dateTime.toDate(), "yyyy-MM-dd 00:00:30"),
                        "yyyy-MM-dd HH:mm:ss");
            }
            else
            {
                dateTime = dateTime.plusMinutes(m);
                return DateUtils.getDateWithDateStr(DateUtils.getStringDate(dateTime.toDate(), "yyyy-MM-dd HH:mm:30"),
                        "yyyy-MM-dd HH:mm:ss");
            }
        }
        else
        {
            return DateUtils.getDateWithDateStr(DateUtils.getStringDate(dateTime.toDate(), "yyyy-MM-dd 10:03:30"),
                    "yyyy-MM-dd HH:mm:ss");

        }
    }
    
    /**
     * 根据时间获得期数
     *
     * @param hour
     * @param minute
     * @return
     */
    public static String getSSCNum(int hour, int minute)
    {
    	int term = 0;	
    	int m = 0;
		if (hour > 2 && hour < 22) { // 白天期数（10分钟一期）（从24期~95期）
			if (hour < 10)
				term = 24;
			else {
				m = (hour - 10) * 60 + minute;
				int increase = (m / 10);
				if (m % 10 > 0)
					term = 25 + increase;
				else
					term = 24 + increase;
			}
		} else if (hour >= 22) { // 晚上期数（5分钟一期）（从96期~120期）
			m = (hour - 22) * 60 + minute;
			int increase = (m / 5);
			if (m % 5 > 0)
				term = 97 + increase;
			else
				term = 96 + increase;
		} else if (minute == 0 && hour == 0 || hour == 0 && minute < 5) {
			term = 120;
		} else { // 晚上期数（5分钟一期）（从1期~23期）
			m = hour * 60 + minute;
			int increase = (m / 5);
			term = increase;
		}
        return StringUtils.leftPad(term + "", 3, "0");
    }
    
    /** 
     * 
     * @param date
     * @return      
     * boolean      
     */  
    public static boolean isOlkActivityTime(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour >= 10 || hour <= 2;
    }
    
    public static String getOlkGreeting(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour >= 5 && hour < 10)
        {
            return "早上好";
        }
        else if(hour >= 10 && hour < 12)
        {
            return "上午好";
        }
        else if(hour >= 12 && hour < 18)
        {
            return "下午好";
        }
        else
        {
            return "晚上好";
        }
    }
    
    public static Date formatDate(Date d, String pattern)
    {
        return DateUtils.getDateWithDateStr(getStringDate(d, pattern));
    }
    
    /**
     * 返回未来的一个时间(2199-12-01)
     */
    public static Date getFutureDate()
    {
        return getDateWithDateStr("2199-12-01", "yyyy-HH-mm");
    }
    
	public static void main(String[] args) {
//		System.out.println(isBeforeNow(getDateWithDateStr("2017-03-11 00:00:00")));
		System.out.println(getTodayEndSeconds());
	}
	
	/**
	 * 获取当前时间的天
	 */
	public static Integer getDayByMonth(Date date){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
	}
	
	/**
	 * 获取当前时间的月份
	 */
	public static Integer getMonthByTime(Date date){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //calendar获得月份会少一天
        return calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取月份的天数
	 */
	public static Integer getDaysNumForMonth(Date time){
		if(time == null){
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return calendar.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 获取时间的指定增加（减少）月份的月尾
	 */
	public static Date getEndOfMonthByTimeAdd(Date time, Integer month){
		return withTimeAtEndOfMonth(addMonth(time, month));
	}
	
	/**
	 * 获取时间的指定增加（减少）月份的月初
	 */
	public static Date getStartOfMonthByTimeAdd(Date time, Integer month){
		return withTimeAtStartOfMonth(addMonth(time, month));
	}
}
