package com.mtp.utils;

import java.util.Calendar;

/**
 * Created by morozov.yury on 29.6.15.
 */
public class TimeUtils {

    public static String getCurrentTime () {
        return Calendar.getInstance().getTime().toString();
    }

}
