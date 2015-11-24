package com.yevgenoliinykov.greetingApp.business;

import com.yevgenoliinykov.greetingApp.main.AppConstants;

public class GreetingService {

    /**
     * Returns the key of localized message depending on current hour.
     *
     * @param hour
     *            the current hour.
     * @return the key of localized message.
     */
    public static String getMessageKey(byte hour) {
	String result = "";
	if (hour < 0 || hour > 24) {
	    throw new IllegalArgumentException("The time is out of Earth time range");
	}
	if (hour >= AppConstants.MORNING_START_HOUR && hour < AppConstants.DAY_START_HOUR) {
	    result = AppConstants.MORNING_MSG_KEY;
	} else if (hour >= AppConstants.DAY_START_HOUR && hour < AppConstants.EVENING_START_HOUR) {
	    result = AppConstants.DAY_MSG_KEY;
	} else if (hour >= AppConstants.EVENING_START_HOUR && hour < AppConstants.NIGHT_START_HOUR) {
	    result = AppConstants.EVENING_MSG_KEY;
	} else if (hour >= AppConstants.NIGHT_START_HOUR || hour < AppConstants.DAY_START_HOUR) {
	    result = AppConstants.NIGHT_MSG_KEY;
	}
	return result;
    }
}