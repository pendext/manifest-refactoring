package com.manifestcorp.refactoring.dates;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class DateProcessorTest {

    DateProcessor dateProcessor;

    @Before
    public void setup() {
        dateProcessor = new DateProcessor();
    }

    @Test
    public void saveDueDateForAccountSavesDateCorrectly() throws Exception {
        String expectedDateString = "2-21-2014";
        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID());
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(expectedDateString);
        dateProcessor.saveDueDate(account, expectedDateString);
        assertEquals("The account doesn't have the correct due date",
                expectedDate, account.getDueDate());
    }

    @Test
    public void saveStartDateForAccountSavesDateCorrectly() throws Exception {
        String expectedDateString = "2-21-2014";
        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID());
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(expectedDateString);
        dateProcessor.saveStartDate(account, expectedDateString);
        assertEquals("The account doesn't have the correct due date",
                expectedDate, account.getStartDate());
    }

}
