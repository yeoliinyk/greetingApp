package com.yevgenoliinykov.greetingApp.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.yevgenoliinykov.greetingApp.main.App;

public class ResourceHelper {

    final static Logger logger = Logger.getLogger(App.class);

    Locale locale;

    public ResourceHelper(Locale locale) {
	this.locale = locale;
    }

    private ResourceBundle messageBundle;

    private ResourceBundle getMessageResources() {
	// TODO
	try {
	    messageBundle = ResourceBundle.getBundle("com.yevgenoliinykov.greetingApp.messages", locale);
	} catch (NullPointerException e) {
	    logger.error("Base name or locale is null.");
	} catch (MissingResourceException e) {
	    logger.error("Property file with localization is missing.");
	}
	return messageBundle;
    }

    /**
     * Returns localized message from property file by a key.
     *
     * @param key
     *            key of localized message.
     * @return localized message from property file.
     */
    public String getValueFromMessages(String key) {
	return getMessageResources().getString(key);
    }
}