package com.manifestcorp.refactoring;

public class InvoiceStringBuilder {

    public String printInvoiceHeader() {
        String result = createHeaderOrFooterString(1);
        result += String.format("************ Your Invoice ************%s", createNewLines(2));
        result += createInvoiceFillerLine(1);
        return result;
    }

    public String printAmountOwed(double amount) {
        String result = String.format("***   Amount Owed     ***%s", createNewLines(1));
        result += createInvoiceFillerLine(1);
        result += createNewLines(3);
        result += String.format("*** You owe $%s ***%s", String.valueOf(amount), createNewLines(1));
        return result;
    }

    public String printRefund(double refundAmount) {
        String result = createInvoiceFillerLine(1);
        result += String.format("***   Amount Refunded ***%s", createNewLines(1));
        result += createInvoiceFillerLine(1);
        result += createNewLines(3);
        result += String.format("*** Your refund is $%s ***%s", String.valueOf(refundAmount), createNewLines(1));
        return result;
    }

    public String printInvoiceClosingStatement(String customerName) {
        String result = "";
        result += createInvoiceFillerLine(2);
        result += String.format("*** Thank you, %s   ***%s", customerName, createNewLines(1));
        result += createHeaderOrFooterString(2);
        return result;
    }

    public String printFullInvoice(double amountOwed, double refundAmount, String customerName) {
        String result = printInvoiceHeader();
        result += printAmountOwed(amountOwed);
        result += printRefund(refundAmount);
        result += printInvoiceClosingStatement(customerName);
        return result;
    }

    private String createHeaderOrFooterString(int numberOfHeaderOrFooterStrings) {
        String headerOrFooterStrings = "";
        for (int i = 0; i < numberOfHeaderOrFooterStrings; i++) {
            headerOrFooterStrings += String.format("************ ************ ************%s", createNewLines(1));
        }
        return headerOrFooterStrings;
    }

    private String createInvoiceFillerLine(int numberOfInvoiceFillerLines) {
        String invoiceFillerLines = "";
        for (int i = 0; i < numberOfInvoiceFillerLines; i++) {
            invoiceFillerLines += String.format("************ ************%s", createNewLines(1));
        }
        return invoiceFillerLines;
    }

    private String createNewLines(int numberOfNewLines) {
        String newLines = "";
        for (int i = 0; i < numberOfNewLines; i++) {
            newLines += "\n";
        }
        return newLines;
    }
}
