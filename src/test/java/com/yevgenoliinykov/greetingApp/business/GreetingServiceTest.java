package com.yevgenoliinykov.greetingApp.business;

import org.junit.Assert;
import org.junit.Test;

import com.yevgenoliinykov.greetingApp.main.AppConstants;

public class GreetingServiceTest {
    public final static byte MORNING_HOUR = 8;
    public final static byte DAY_HOUR = 12;
    public final static byte EVENING_HOUR = 20;
    public final static byte NIGHT_HOUR = 3;
    public final static byte ELEVEN_OCLOCK = 23;
    public final static byte WRONG_VALUE = 30;

    @Test
    public void getMessageKeyTestSuccess() {
	Assert.assertEquals(AppConstants.MORNING_MSG_KEY, GreetingService.getMessageKey(MORNING_HOUR));
	Assert.assertEquals(AppConstants.DAY_MSG_KEY, GreetingService.getMessageKey(DAY_HOUR));
	Assert.assertEquals(AppConstants.EVENING_MSG_KEY, GreetingService.getMessageKey(EVENING_HOUR));
	Assert.assertEquals(AppConstants.NIGHT_MSG_KEY, GreetingService.getMessageKey(NIGHT_HOUR));
	Assert.assertEquals(AppConstants.NIGHT_MSG_KEY, GreetingService.getMessageKey(ELEVEN_OCLOCK));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMessageKeyTestFail() {
	GreetingService.getMessageKey(WRONG_VALUE);
    }
}
