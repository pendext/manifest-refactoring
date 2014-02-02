package com.manifestcorp.refactoring;

public class StringBuilder {

    public String printOwingAndInvoiceOpeningStatement(double amount) {
        String result = "";
        result += "************ ************ ************\n";
        result += "************ Your Invoice ************\n\n";
        result += "************ ************\n";
        result += "***   Amount Owed     ***\n";
        result += "************ ************\n";
        result += "\n\n\n";
        result += "*** You owe $" + String.valueOf(amount) + " ***\n";
        return result;
    }

    public String printRefund(double refundAmount) {
        String result = "";
        result += "************ ************\n";
        result += "***   Amount Refunded ***\n";
        result += "************ ************\n";
        result += "\n\n\n";
        result += "*** Your refund is $" + String.valueOf(refundAmount) + " ***\n";
        return result;
    }

    public String printInvoiceClosingStatement(String customerName) {
        String result = "";
        result += "************ ************\n";
        result += "************ ************\n";
        result += "*** Thank you, " + customerName + "   ***\n";
        result += "************ ************ ************\n";
        result += "************ ************ ************\n";

        return result;
    }

    public String printFullInvoice(double amountOwed, double refundAmount, String customerName) {
        String result = printOwingAndInvoiceOpeningStatement(amountOwed);
        result += printRefund(refundAmount);
        result += printInvoiceClosingStatement(customerName);
        return result;
    }
}
