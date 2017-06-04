package com.itheima.mobileplayer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:字符串操作工具类
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 独孤求败
 * Date       : 2016/10/14 15:17
 */
public class StringUtils {

    public static final int HOUR = 60 * 60 * 1000;
    public static final int SEC  = 1000;
    public static final int MIN  = 60 * 1000;

    /**
     * 格式化时间
     * @param time
     * @return 00:00:00 或者 00:00
     */
    public static String formatTime(int time) {
        int h = time / HOUR;
        int m = time % HOUR / MIN;
        int s = time % MIN / SEC;

        if (h >= 1) {
            //00:00:00
            return String.format("%02d:%02d:%02d", h, m, s);
        } else {
            //00:00
            return String.format("%02d:%02d", m, s);
        }
    }

    public static String formatSystemTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 截取音乐的名称
     */
    public static String getTitle(String t) {
        return t.substring(0,t.lastIndexOf("."));
    }
}
