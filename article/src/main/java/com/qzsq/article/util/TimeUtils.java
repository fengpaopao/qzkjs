package com.qzsq.article.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName TimeUitls  时间工具类
 * @Description TODO
 * @Author liangkanglin
 * @Date 2019/5/10 11:04
 * Version 1.0
 **/
public class TimeUtils {

    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年


    /**
     * @param data       Date类型的时间
     * @param formatType 时间格式
     * @return
     * @Description date类型转换为String类型
     * @Date 2019/1/4 16:48
     **/
    public static String dateToString( Date data, String formatType ) {
        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * @param currentTime long类型的时间
     * @param formatType  时间格式
     * @return
     * @Description long类型转换为String类型
     * @Date 2019/1/4 16:49
     **/
    public static String longToString( long currentTime, String formatType )
            throws ParseException {
        Date date = longToDate(currentTime, formatType);
        String strTime = dateToString(date, formatType);
        return strTime;
    }

    /**
     * @param strTime    string类时间
     * @param formatType 时间格式
     * @return strTime的时间格式必须要与formatType的时间格式相同
     * @Description string类型转换为date类型
     * @Date 2019/1/4 16:50
     **/
    public static Date stringToDate( String strTime, String formatType )
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     * @param currentTime long类时间
     * @param formatType  时间格式
     * @return
     * @Description long转换为Date类型
     * @Date 2019/1/4 16:52
     **/
    public static Date longToDate( long currentTime, String formatType )
            throws ParseException {
        Date dateOld = new Date(currentTime);
        String sDateTime = dateToString(dateOld, formatType);
        Date date = stringToDate(sDateTime, formatType);
        return date;
    }

    /**
     * @param strTime    String类时间
     * @param formatType 时间格式
     * @return
     * @Description string类型转换为long类型
     * @Date 2019/1/4 16:53
     **/
    public static long stringToLong( String strTime, String formatType )
            throws ParseException {
        Date date = stringToDate(strTime, formatType);
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date);
            return currentTime;
        }
    }

    /**
     * @param date date类时间
     * @return
     * @Description date类型转换为long类型
     * @Date 2019/1/4 16:54
     **/
    public static long dateToLong( Date date ) {
        return date.getTime();
    }


    /**
     * @return String
     * @Description 返回yyyy-MM-dd HH:mm:ss的字符串
     * @Date 2019/1/4 14:58
     * @Param
     **/
    public static String getCurrentTimeStr() {
        return getCurrentTimeStr("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @return String
     * @Description 返回 yyyy-MM-dd的字符
     * @Date 2019/1/4 14:58
     * @Param
     **/
    public static String getCurrentTimeYear() {
        return getCurrentTimeStr("yyyy-MM-dd");
    }

    /**
     * @return String
     * @Description 返回 HH:mm:ss的字符
     * @Date 2019/1/4 14:58
     * @Param
     **/
    public static String getCurrentTimeStrHour() {
        return getCurrentTimeStr("HH:mm:ss");
    }

    /**
     * @return String
     * @Description 返回自定义时间格式的字符
     * @Date 2019/1/4 14:59
     * @Param custom  自定义时间格式
     **/
    public static String getCurrentTimeStr( String custom ) {
        Calendar curCalendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(custom);
        return df.format(curCalendar.getTime());
    }

    /**
     * @return String
     * @Description 将时间戳转成格式化时间 返回 yyyy-MM-dd HH:mm:ss
     * @Date 2019/1/4 14:57
     * @Param milliseconds  时间
     **/
    public static String getFormatTime( long milliseconds ) {
        return getFormatTime(milliseconds, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @return String
     * @Description 将时间戳转成格式化时间 返回 yyyy-MM-dd
     * @Date 2019/1/4 15:01
     * @Param milliseconds  时间
     **/
    public static String getFormatTimeYear( long milliseconds ) {
        return getFormatTime(milliseconds, "yyyy-MM-dd");
    }

    /**
     * @return String
     * @Description 将时间戳转成格式化时间 返回 HH:mm:ss
     * @Date 2019/1/4 15:01
     * @Param milliseconds   时间
     **/
    public static String getFormatTimeHour( long milliseconds ) {
        return getFormatTime(milliseconds, "HH:mm:ss");
    }

    /**
     * @return String
     * @Description 根据自定义参数来返回相关格式的时间
     * @Date 2019/1/4 15:01
     * @Param milliseconds  时间
     * @Param custom       自定义时间
     **/
    public static String getFormatTime( long milliseconds, String custom ) {
        SimpleDateFormat sdf = new SimpleDateFormat(custom);
        return sdf.format(new Date(milliseconds));
    }

    /**
     * @return String
     * @Description 返回文字描述的日期
     * @Date 2019/1/4 15:12
     * @Param date
     **/
    public static String getTimeFormatText( long date ) {
        if (date == 0) return "";
        date = date * 1000;
        long diff = new Date().getTime() - date;
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /**
     * @param date1 时间1
     * @param date2 时间2
     * @return int
     * @Description 计算两个日期之间相差的天数
     * @Date 2019/1/4 15:24
     **/
    public static int daysBetween( Date date1, Date date2 ) {
        boolean result = date1.before(date2);//对比时间的前后
        Date sdate, bdate;
        if (result == true) {
            sdate = date2;
            bdate = date1;
        } else {
            sdate = date1;
            bdate = date2;
        }
        int days = (int) ((sdate.getTime() - bdate.getTime()) / (1000 * 3600 * 24));
        return days;

    }


    /**
     * @param time 时间
     * @return String
     * @Description 获取分秒格式化字符串
     * @Date 2019/1/4 16:04
     **/
    public static String getFormatMiniteSecString( int time ) {
        int second = time % 60;
        int minute = time / 60;
        int hour = 0;
        if (minute >= 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String timeString = "";
        String secondString = "";
        String minuteString = "";
        String hourString = "";
        if (second < 10) {
            secondString = "0" + second;
        } else {
            secondString = second + "";
        }
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = minute + "";
        }
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = hour + "";
        }
        if (hour != 0) {
            timeString = hourString + ":" + minuteString + ":" + secondString;
        } else {
            timeString = minuteString + ":" + secondString;
        }
        return timeString;
    }

    /**
     * @param time
     * @return boolean
     * @Description 判断选择的日期是否是本周
     * @Date 2019/1/4 16:24
     **/
    public static boolean isThisWeek( long time ) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (paramWeek == currentWeek) return true;
        return false;
    }

    /**
     * @param time
     * @return boolean
     * @Description 判断选择的日期是否是今天
     * @Date 2019/1/4 16:24
     **/
    public static boolean isToday( long time ) {
        return isThisTime(time, "yyyy-MM-dd");
    }

    /**
     * @param time
     * @return boolean
     * @Description 判断选择的日期是否是本月
     * @Date 2019/1/4 16:24
     **/
    public static boolean isThisMonth( long time ) {
        return isThisTime(time, "yyyy-MM");
    }

    /**
     * @param time    pattern
     * @param pattern
     * @return boolean
     * @Description 处理时间对比的类
     * @Date 2019/1/4 16:24
     **/
    private static boolean isThisTime( long time, String pattern ) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if (param.equals(now)) return true;
        return false;
    }

    public static void main( String[] args ) throws ParseException {
        String format = "HH:mm:ss";
        Date nowTime = new SimpleDateFormat(format).parse("09:28:00");
        Date startTime = new SimpleDateFormat(format).parse("09:27:00");
        Date endTime = new SimpleDateFormat(format).parse("09:27:59");
        System.out.println(isEffectiveDate(nowTime, startTime, endTime));
        System.out.println(getFormatMiniteSecString(123));
    }

    /**
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return boolean
     * @Description 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * @Date 2019/1/4 16:42
     **/
    public static boolean isEffectiveDate( Date nowTime, Date startTime, Date endTime ) {
        if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime())
            return true;
        if (nowTime.after(startTime) && nowTime.before(endTime)) {
            return true;
        } else {
            return false;
        }
    }


    public static String addTime( String manufactureDate, int day ) {
        Calendar calendar = Calendar.getInstance();
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(format.parse(manufactureDate));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);//让日期加n
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
    }

    /**
     * @return
     * @Author ffc
     * @Description //TODO 获取当前日期
     * @Date 2019/5/16
     * @Param * @param null
     **/
    public static String currentDate() {
        LocalDate dates = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dates.format(formatter);
        return format;

    }

    /**
     * @return
     * @Author ffc
     * @Description //TODO 获取当前时间
     * @Date 2019/5/14
     * @Param * @param
     **/
//获取当前的小时
    public static String dateHour() {

        Date date = new Date();
        SimpleDateFormat hh = new SimpleDateFormat("HH");
        String format = hh.format(date);

        return format;
    }

    /**
     * @return
     * @Author ffc
     * @Description //TODO 字符串转localhostDate
     * @Date 2019/5/16
     * @Param * @param null
     **/
    public static LocalDate datestring( String beginDate ) {
        LocalDate beginDateTime = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return beginDateTime;

    }

    /**
     * @return
     * @Author ffc
     * @Description 当前日期加一天
     * @Date 2019/5/17
     * @Param * @param null
     **/
    public static String addDay( int day ) {
        //获取当前时间
        String s = TimeUtils.currentDate();
        //转换为localDate
        LocalDate datestring = TimeUtils.datestring(s);
        //让当前时间加一条
        LocalDate localDate = datestring.plusDays(1);
        String s1 = TimeUtils.stringDate(localDate);

        return s1;

    }

    public static String jainDay( int day ) {
        //获取当前时间
        String s = TimeUtils.currentDate();
        //转换为localDate
        LocalDate datestring = TimeUtils.datestring(s);
        //让当前时间加一条
        LocalDate localDate = datestring.minusDays(1);
        String s1 = TimeUtils.stringDate(localDate);

        return s1;

    }

    public static String jainwekk( LocalDate date, int day ) {

        //让当前时间加一条
        LocalDate localDate = date.minusDays(1);
        String s1 = TimeUtils.stringDate(localDate);

        return s1;

    }

    /**
     * @return
     * @Author ffc
     * @Description //TODO localDate转为string
     * @Date 2019/5/17
     * @Param * @param localDate
     **/
    public static String stringDate( LocalDate localDate ) {
        String s = localDate.toString();
        return s;

    }

    //获取当前时间分秒
    public static String getdateday() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        return format;

    }

    public static String Addingtime( String time ) {
        LocalTime parse = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime localTime = parse.plusHours(8);
//        String format = localTime.format(localTime);
        String s = localTime.toString();
        return s;

    }

    /**
     * @return
     * @Author ffc
     * @Description //TODO 判断两个时间相差多少
     * @Date 2019/5/29
     * @Param * @param null
     **/
    public static long Judge( String date ) {

        LocalDateTime parse = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.now();
        Period period = Period.between(LocalDate.from(parse), LocalDate.from(now));

//        if (ChronoUnit.YEARS == ChronoUnit.YEARS) {
//            if (ChronoUnit.MONTHS == ChronoUnit.MONTHS) {
////                return period.getYears() * 12 + period.getMonths();
//            }
//            ;
//            if (ChronoUnit.MINUTES == ChronoUnit.MINUTES) {
////                return period.getYears() * 12 + period.getMonths();
//            }
//            ;
//        }

        return ChronoUnit.SECONDS.between(parse, now);


    }

}



