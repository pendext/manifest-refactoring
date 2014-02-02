package com.manifestcorp.refactoring;

public class StringBuilder {

    public String printInvoiceHeader() {
        String result = createHeaderOrFooterString(1);
        result += "************ Your Invoice ************\n\n";
        result += createInvoiceFillerLine();
        return result;
    }

    public String printAmountOwed(double amount) {
        String result = "***   Amount Owed     ***\n";
        result += createInvoiceFillerLine();
        result += createNewLines(3);
        result += "*** You owe $" + String.valueOf(amount) + " ***\n";
        return result;
    }

    public String printRefund(double refundAmount) {
        String result = createInvoiceFillerLine();
        result += "***   Amount Refunded ***\n";
        result += createInvoiceFillerLine();
        result += createNewLines(3);
        result += "*** Your refund is $" + String.valueOf(refundAmount) + " ***\n";
        return result;
    }

    public String printInvoiceClosingStatement(String customerName) {
        String result = "";
        result += createInvoiceFillerLine();
        result += createInvoiceFillerLine();
        result += "*** Thank you, " + customerName + "   ***\n";
        result += createHeaderOrFooterString(1);
        result += createHeaderOrFooterString(1);

        return result;
    }

    public String printFullInvoice(double amountOwed, double refundAmount, String customerName) {
        String result = printInvoiceHeader();
        result += printAmountOwed(amountOwed);
        result += printRefund(refundAmount);
        result += printInvoiceClosingStatement(customerName);
        return result;
    }

    private String createHeaderOrFooterString(int numberOfNewLines) {
        return "************ ************ ************" + createNewLines(numberOfNewLines);
    }

    private String createInvoiceFillerLine() {
        return "************ ************\n";
    }

    private String createNewLines(int numberOfNewLines) {
        String newLines = "";
        for (int i = 0; i < numberOfNewLines; i++) {
            newLines += "\n";
        }
        return newLines;
    }
}
