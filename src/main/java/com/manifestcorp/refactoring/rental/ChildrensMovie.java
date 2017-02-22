package com.manifestcorp.refactoring.rental;

public class ChildrensMovie extends Movie {

    private double amount = 1.5;

    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    double getAmount(int daysRented) {
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }
}
