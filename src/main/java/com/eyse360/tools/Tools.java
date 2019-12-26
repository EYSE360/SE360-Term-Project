package com.eyse360.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Tools {
    public static long getCurrentUnixTime() {
        return System.currentTimeMillis() / 1000L;
    }
    
    public static Date setCurrentTime(int time) {
        return new Date((long) time * 1000);
    }

    public static boolean isNullOrEmpty(List list) {
        return list != null && !list.isEmpty();
    }
}
