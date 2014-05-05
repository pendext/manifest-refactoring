package com.manifestcorp.refactoring.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProcessor {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public void saveDueDate(Account account, String date) {
        Date parsedDate = parseDate(date);
        account.setDueDate(parsedDate);
    }

    public void saveStartDate(Account account, String date) {
        Date parsedDate = parseDate(date);
        account.setStartDate(parsedDate);
    }

    private Date parseDate(String date) {
        Date parsedDate = null;
        try {
            parsedDate = new SimpleDateFormat(DATE_FORMAT).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }
}
