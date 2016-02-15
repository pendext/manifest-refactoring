package com.manifestcorp.refactoring.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProcessor {

    static SimpleDateFormat format;

    static {
	   format = new SimpleDateFormat("yyyy-MM-dd");
    }	

    private Date parseDateString(String date) {
	    Date parsedDate = null;
		try {
			parsedDate = format.parse(date);
	   	} catch (ParseException e) {

    	}
	    return parsedDate;
    }

    public void saveDueDate(Account account, String date) {
        account.setDueDate(parseDateString(date));
    }

    public void saveStartDate(Account account, String date) {
        account.setStartDate(parseDateString(date));
    }


}
