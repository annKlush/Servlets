package org.example;

import java.time.ZoneId;
import java.util.Set;

public class TimeZone {
    private static final Set<String> TIMEZONE_IDS = ZoneId.getAvailableZoneIds();

    public static boolean isValidTimezone(String timezone) {
        return TIMEZONE_IDS.contains(timezone);
    }
}
