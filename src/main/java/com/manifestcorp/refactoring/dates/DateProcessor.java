package com.manifestcorp.refactoring.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProcessor {

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
            parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }
}
