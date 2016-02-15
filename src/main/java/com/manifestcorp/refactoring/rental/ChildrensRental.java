package com.manifestcorp.refactoring.rental;

public class ChildrensRental extends Rental {

    public ChildrensRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double getCost() {
        double amountForIndividualRental = 1.5;
        if (getDaysRented() > 3) {
            amountForIndividualRental += (getDaysRented() - 3) * 1.5;
        }
        return amountForIndividualRental;
    }
}
