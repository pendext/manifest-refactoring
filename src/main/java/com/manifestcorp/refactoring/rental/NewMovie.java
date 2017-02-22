package com.manifestcorp.refactoring.rental;

public class NewMovie extends Movie {


    public NewMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    double getAmount(int daysRented) {
        return daysRented * 3;
    }

}
