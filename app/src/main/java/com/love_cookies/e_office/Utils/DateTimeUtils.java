package com.love_cookies.e_office.Utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by xiekun on 2016/4/14 0014.
 *
 * 时间日期工具类
 */
public class DateTimeUtils {

    /**
     * 获取当前时间
     */
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        return formatter.format(curDate);
    }

    /**
     * 获取当前年
     */
    public static String getCurrentYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        return formatter.format(curDate);
    }
}
