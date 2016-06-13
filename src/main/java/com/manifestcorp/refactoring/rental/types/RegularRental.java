package com.manifestcorp.refactoring.rental.types;

import com.manifestcorp.refactoring.rental.*;

public class RegularRental extends Rental {

    public RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getPrice() {
        double initialAmount = 2;
        if (this.getDaysRented() > 2) {
            initialAmount += (this.getDaysRented() - 2) * 1.5;
        }
        return initialAmount;
    }
}
