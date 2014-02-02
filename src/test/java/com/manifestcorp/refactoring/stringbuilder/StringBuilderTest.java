package com.manifestcorp.refactoring.stringbuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTest {

    public StringBuilder stringBuilder;

    @Before
    public void setup() {
        stringBuilder = new StringBuilder();
    }

    @Test
    public void printOwingAndInvoiceClosingStatementCreatesCorrectInvoiceString() {
        double amount = 3.00;
        String expectedResult = "";
        expectedResult += "************ ************ ************\n";
        expectedResult += "************ Your Invoice ************\n\n";
        expectedResult += "************ ************\n";
        expectedResult += "***   Amount Owed     ***\n";
        expectedResult += "************ ************\n";
        expectedResult += "\n\n\n";
        expectedResult += "*** You owe $" + String.valueOf(amount) + " ***\n";

        assertEquals("The returned string are not equal.", expectedResult,
                stringBuilder.printOwingAndInvoiceOpeningStatement(amount));
    }

    @Test
    public void printRefundCreatesCorrectInvoiceString() {
        double refundAmount = 3.00;
        String expectedResult = "";
        expectedResult += "************ ************\n";
        expectedResult += "***   Amount Refunded ***\n";
        expectedResult += "************ ************\n";
        expectedResult += "\n\n\n";
        expectedResult += "*** Your refund is $" + String.valueOf(refundAmount) + " ***\n";

        assertEquals("The returned strings are not equal.", expectedResult,
                stringBuilder.printRefund(refundAmount));
    }

    @Test
    public void printInvoiceClosingStatementCreatesValidStatement() {
        String customerName = "Custy McCustomer";
        String expectedResult = "";
        expectedResult += "************ ************\n";
        expectedResult += "************ ************\n";
        expectedResult += "*** Thank you, " + customerName + "   ***\n";
        expectedResult += "************ ************ ************\n";
        expectedResult += "************ ************ ************\n";

        assertEquals("The invoice closing statement is not correct.", expectedResult,
                stringBuilder.printInvoiceClosingStatement(customerName));
    }

    @Test
    public void printFullInvoicePrintsCorrectFullInvoice() {
        double amount = 4.00;
        double refundAmount = 3.00;
        String customerName = "Chet Youbetcha";

        String expectedResult = "";
        expectedResult += "************ ************ ************\n";
        expectedResult += "************ Your Invoice ************\n\n";
        expectedResult += "************ ************\n";
        expectedResult += "***   Amount Owed     ***\n";
        expectedResult += "************ ************\n";
        expectedResult += "\n\n\n";
        expectedResult += "*** You owe $" + String.valueOf(amount) + " ***\n";
        expectedResult += "************ ************\n";
        expectedResult += "***   Amount Refunded ***\n";
        expectedResult += "************ ************\n";
        expectedResult += "\n\n\n";
        expectedResult += "*** Your refund is $" + String.valueOf(refundAmount) + " ***\n";
        expectedResult += "************ ************\n";
        expectedResult += "************ ************\n";
        expectedResult += "*** Thank you, " + customerName + "   ***\n";
        expectedResult += "************ ************ ************\n";
        expectedResult += "************ ************ ************\n";

        assertEquals("The full invoice output in incorrect", expectedResult,
                stringBuilder.printFullInvoice(amount, refundAmount, customerName));
    }

}
