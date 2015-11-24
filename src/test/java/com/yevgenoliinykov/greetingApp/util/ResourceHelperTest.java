package com.yevgenoliinykov.greetingApp.util;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;

import com.yevgenoliinykov.greetingApp.main.AppConstants;

public class ResourceHelperTest {

    public final static String LOCALE_EN = "en";
    public final static String LOCALE_RU = "ru";
    public final static String WRONG_KEY = "dadsad";

    @Test
    public void getValueFromMessagesTestSucces_En() {
	Locale localeEn = new Locale(LOCALE_EN, "");
	ResourceHelper rh = new ResourceHelper(localeEn);
	Assert.assertEquals("Good morning, World!", rh.getValueFromMessages(AppConstants.MORNING_MSG_KEY));
	Assert.assertEquals("Good day, World!", rh.getValueFromMessages(AppConstants.DAY_MSG_KEY));
	Assert.assertEquals("Good evening, World!", rh.getValueFromMessages(AppConstants.EVENING_MSG_KEY));
	Assert.assertEquals("Good night, World!", rh.getValueFromMessages(AppConstants.NIGHT_MSG_KEY));
    }

    @Test
    public void getValueFromMessagesTestSucces_Ru() {
	Locale localeRu = new Locale(LOCALE_RU, "");
	ResourceHelper rh = new ResourceHelper(localeRu);
	Assert.assertEquals("Доброе утро, Мир!", rh.getValueFromMessages(AppConstants.MORNING_MSG_KEY));
	Assert.assertEquals("Добрый день, Мир!", rh.getValueFromMessages(AppConstants.DAY_MSG_KEY));
	Assert.assertEquals("Добрый вечер, Мир!", rh.getValueFromMessages(AppConstants.EVENING_MSG_KEY));
	Assert.assertEquals("Доброй ночи, Мир!", rh.getValueFromMessages(AppConstants.NIGHT_MSG_KEY));
    }

    @Test(expected = NullPointerException.class)
    public void getValueFromMessagesTest_NullPointerExeption() {
	ResourceHelper rh = new ResourceHelper(new Locale("en", ""));
	Assert.assertEquals("Good morning, World!", rh.getValueFromMessages(null));
    }

    @Test(expected = MissingResourceException.class)
    public void getValueFromMessagesTest_MissingResourceExeption() {
	ResourceHelper rh = new ResourceHelper(new Locale("en", ""));
	Assert.assertEquals("Good morning, World!", rh.getValueFromMessages(WRONG_KEY));
    }
}
