package com.manifestcorp.refactoring.rental;

public class RegularMovie extends Movie {

    private double amount = 2;

    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    double getAmount(int daysRented) {
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
