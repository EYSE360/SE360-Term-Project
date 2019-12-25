package com.eyse360.tools;

import java.util.List;

public class Tools {
    public static long getCurrentUnixTime() {
        return System.currentTimeMillis() / 1000L;
    }

    public static boolean isNullOrEmpty(List list) {
        return list != null && !list.isEmpty();
    }
}
