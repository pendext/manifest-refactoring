package com.manifestcorp.refactoring.rental;

public class RegularRental extends Rental {

    public RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double getCost() {
        double amountForIndividualRental = 2;
        if (getDaysRented() > 2) {
            amountForIndividualRental += (getDaysRented() -2) * 1.5;
        }
        return amountForIndividualRental;
    }
}
