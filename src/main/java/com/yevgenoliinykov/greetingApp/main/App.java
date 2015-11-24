package com.yevgenoliinykov.greetingApp.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.yevgenoliinykov.greetingApp.business.GreetingService;
import com.yevgenoliinykov.greetingApp.util.ResourceHelper;

public class App {

    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
	logger.info("Starting the app...");
	byte currentHour;
	String messageKey;
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH");
	logger.info("Getting time in hours.");
	currentHour = Byte.valueOf(sdf.format(calendar.getTime()));
	logger.info("Current hour is '" + currentHour + "'.Getting message key...");
	messageKey = GreetingService.getMessageKey(currentHour);
	ResourceHelper rh = new ResourceHelper(Locale.getDefault());
	logger.info("Getting message for greeting by the '" + messageKey + "' key. Printing message to console.");
	System.out.println(rh.getValueFromMessages(messageKey));
	logger.info("Closing the app...");
    }
}
